package com.pavelnazimok.selenide.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.pavelnazimok.selenide.sections.PatientsMenuSection;
import io.qameta.allure.Step;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
import static org.assertj.core.api.Assertions.assertThat;

public class QueriesPage {

    public static final Pattern PATTERN_QUERY_COUNTER = Pattern.compile("(\\d) total queries, (\\d) open");

    private final PatientsMenuSection patientsMenu = new PatientsMenuSection();

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    private final SelenideElement
            queryCounter = $(byText("Queries")).parent().$("span"),
            replyTextBox = $("#Answer_I"),
            queryReplyButton = $("#SubmitReply"),
            queryCloseButton = $("#ReplyQueryClose"),
            answeredQueryCloseButton = $("#AnsweredQueryClose");

    private final ElementsCollection replyButtons = $$x("//*[contains(@id, 'replyButton')]//*[text() = 'Reply']");

    public PatientsMenuSection patientsMenu() {
        return patientsMenu;
    }

    @Step("Get total query count")
    public int getTotalQueryCount() {
        final Matcher matcher = PATTERN_QUERY_COUNTER.matcher(queryCounter.getText());
        assertThat(matcher.matches()).isTrue();
        return Integer.parseInt(matcher.group(1));
    }

    @Step("Get open query count")
    public int getOpenQueryCount() {
        final Matcher matcher = PATTERN_QUERY_COUNTER.matcher(queryCounter.getText());
        assertThat(matcher.matches()).isTrue();
        return Integer.parseInt(matcher.group(2));
    }

    @Step("Open query number {index}")
    public QueriesPage openQuery(final int index) {
        $("#QueryGrid_DXMainTable tr", index).$("td", 3).$("[id*='replyButton']").click();
        return this;
    }

    @Step("Open query with title: {title}")
    public QueriesPage openQuery(final String title) {
        $("#QueryGrid_DXMainTable").$x(String.format("td[2][text() = '%s']", title)).parent().$("[id*='replyButton']").click();
        return this;
    }

    @Step("Reply on all unreplied queries with: {reply}")
    public QueriesPage replyOnAllQueries(final String reply) {
        replyButtons.shouldHave(sizeGreaterThan(0));

        for (int i = replyButtons.size(); i > 0; i--) {
            replyButtons.first().click();
            replyTextBox.setValue(reply);
            queryReplyButton.click();
            answeredQueryCloseButton.click();
            replyButtons.shouldHave(size(i - 1)); // Wait until collection updates
        }

        return this;
    }
}
