package com.pavelnazimok.selenide.sections;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@SuppressWarnings("UnusedReturnValue")
public class PatientTabsSection {

    private final SelenideElement self = $("#PatientVisitsTabt");

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    private final SelenideElement
            summaryTab = self.$(byText("Summary")),
            baselineTab = self.$(byText("Baseline")),
            firstDayTab = self.$(byText("1st Day")),
            tenthDayTab = self.$(byText("10th Day")),
            addNewTabButton = self.$(".addNewAE");

    @Step("Open {tab} tab")
    public PatientTabsSection clickTab(final String tab) {
        self.$(byText(tab)).click();
        return this;
    }

    @Step("Open Baseline tab")
    public PatientTabsSection clickBaselineTab() {
        baselineTab.click();
        return this;
    }

    @Step("Open 1st Day tab")
    public PatientTabsSection clickFirstDayTab() {
        firstDayTab.click();
        return this;
    }
}
