package com.pavelnazimok.selenium.sections;

import com.pavelnazimok.selenium.pages.PatientBaselinePage;
import com.pavelnazimok.selenium.pages.PatientFirstDayPage;
import com.pavelnazimok.selenium.pages.PatientSummaryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientTabsSection<T> extends BaseSection<T> {

    public PatientTabsSection(final WebDriver driver, final T pageType) {
        super(driver, pageType);
    }

    @FindBy(xpath = "//a[contains(@id, 'PatientVisitsTabt')]/span[text() = 'Summary']")
    private WebElement summaryTab;

    @FindBy(xpath = "//a[contains(@id, 'PatientVisitsTabt')]/span[text() = 'Baseline']")
    private WebElement baselineTab;

    @FindBy(xpath = "//a[contains(@id, 'PatientVisitsTabt')]/span[text() = '1st Day']")
    private WebElement firstDayTab;

    @FindBy(xpath = "//a[contains(@id, 'PatientVisitsTabt')]/span[text() = '10th Day']")
    private WebElement tenthDayTab;

    @FindBy(className = "addNewAE")
    private WebElement addNewTabButton;

    public PatientSummaryPage clickSummaryTab() {
        summaryTab.click();
        waitUntilLoadingIndicatorDisappears();
        return new PatientSummaryPage(driver);
    }

    public PatientBaselinePage clickBaselineTab() {
        baselineTab.click();
        waitUntilLoadingIndicatorDisappears();
        return new PatientBaselinePage(driver);
    }

    public PatientFirstDayPage clickFirstDayTab() {
        firstDayTab.click();
        waitUntilLoadingIndicatorDisappears();
        return new PatientFirstDayPage(driver);
    }

    public PatientFirstDayPage clickTenthDayTab() {
        tenthDayTab.click();
        waitUntilLoadingIndicatorDisappears();
        return new PatientFirstDayPage(driver);
    }
}
