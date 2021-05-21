package com.pavelnazimok.selenium.pages;

import com.pavelnazimok.selenium.sections.PatientsMenuSection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.pavelnazimok.selenium.tests.BaseTest.TIMEOUT_IMPLICIT_WAIT;
import static org.assertj.core.api.Assertions.assertThat;

public class QueriesPage extends BasePage {

    public static final Pattern PATTERN_QUERY_COUNTER = Pattern.compile("(\\d) total queries, (\\d) open");

    public QueriesPage(final WebDriver driver) {
        super(driver);
        patientsMenu = new PatientsMenuSection<>(driver, this);
    }

    private final PatientsMenuSection<QueriesPage> patientsMenu;

    @FindBy(xpath = "//h1[text()='Queries']/following-sibling::span")
    private WebElement queryCounter;

    @FindBy(xpath = "//span[@class='dx-vam'][text() = 'Reply']")
    private List<WebElement> replyButtons;

    @FindBy(id = "SubmitReply")
    private WebElement queryReplyButton;

    @FindBy(id = "ReplyQueryClose")
    private WebElement queryCloseButton;

    @FindBy(id = "AnsweredQueryClose")
    private WebElement answeredQueryCloseButton;

    @FindBy(id = "Answer_I")
    private WebElement replyTextBox;

    public PatientsMenuSection<QueriesPage> patientsMenu() {
        return patientsMenu;
    }

    public int getTotalQueryCount() {
        final Matcher matcher = PATTERN_QUERY_COUNTER.matcher(queryCounter.getText());
        assertThat(matcher.matches()).isTrue();
        return Integer.parseInt(matcher.group(1));
    }

    public int getOpenQueryCount() {
        final Matcher matcher = PATTERN_QUERY_COUNTER.matcher(queryCounter.getText());
        assertThat(matcher.matches()).isTrue();
        return Integer.parseInt(matcher.group(2));
    }

    public QueriesPage openQuery(final int index) {
        driver.findElement(By.xpath(String.format("//table[@id = 'QueryGrid_DXMainTable']//tr[%d]/td[4]//div[contains(@id, 'replyButton')]", index))).click();
        waitUntilQueryLoadingIndicatorDisappears();
        return this;
    }

    public QueriesPage openQuery(final String title) {
        driver.findElement(By.xpath(String.format("//table[@id = 'QueryGrid_DXMainTable']//td[2][text() = '%s']//following-sibling::td[2]//div[contains(@id, 'replyButton')]", title))).click();
        return this;
    }

    public QueriesPage typeReply(final String reply) {
        replyTextBox.sendKeys(reply);
        return this;
    }

    public QueriesPage clickReply() {
        queryReplyButton.click();
        waitUntilQueryLoadingIndicatorDisappears();
        return this;
    }

    public QueriesPage clickCloseQuery() {
        queryCloseButton.click();
        return this;
    }

    public QueriesPage clickCloseAnsweredQuery() {
        answeredQueryCloseButton.click();
        return this;
    }

    public QueriesPage replyOnAllQueries(final String reply) {
        while (replyButtons.size() > 0) {
            waitUntilQueryLoadingIndicatorDisappears();

            driver.findElement(By.xpath("//span[@class='dx-vam'][text() = 'Reply']")).click();

            typeReply(reply);
            clickReply();
            clickCloseAnsweredQuery();
        }

        return this;
    }

    public void waitUntilQueryLoadingIndicatorDisappears() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        sleep(1000); // Sometimes there is random delay before the loading indicator, and sometimes it doesn't appear at all
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("QueryGrid_LD")));
        driver.manage().timeouts().implicitlyWait(TIMEOUT_IMPLICIT_WAIT, TimeUnit.SECONDS);
    }
}
