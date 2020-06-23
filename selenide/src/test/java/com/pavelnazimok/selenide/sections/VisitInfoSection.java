package com.pavelnazimok.selenide.sections;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class VisitInfoSection {

    private final SelenideElement self = $(withText("Visit Information")).parent();

    private final ChangeReasonSection changeReasonPopup = new ChangeReasonSection();

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    private final SelenideElement
            visitDateField = self.$("#VisitDate"),
            visitTimeField = self.$("#VisitTime"),
            expectedVisitDateField = self.$("#ExpectedVisitDate"),

            editButton = self.$("#btnEditVisit"),
            cancelEditButton = self.$(byText("Cancel")),
            saveButton = self.$("[id*='btnSave']"),

            visitDateTextBox = self.$("#VisitDate_I"),
            visitTimeTextBox = self.$("#VisitTime_I"),
            expectedVisitDateTextBox = self.$("#ExpectedVisitDate_I");

    public ChangeReasonSection changeReasonPopup() {
        return changeReasonPopup;
    }
}
