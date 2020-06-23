package com.pavelnazimok.selenide.sections;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class VitalsSection {

    private final SelenideElement self = $(withText("Vitals")).parent();

    private final ChangeReasonSection changeReasonPopup = new ChangeReasonSection();

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    private final SelenideElement
            actualTimeField = self.$("#ActualTime"),
            heightField = self.$("#Height"),
            weightField = self.$("#Weight"),
            temperatureField = self.$("#Temperature"),
            hearthRateField = self.$("#HeartRate"),
            bloodPressureSystolicField = self.$("#BloodPressureSystolic"),
            bloodPressureDiastolicField = self.$("#BloodPressureDiastolic"),

            editButton = self.$("#btnEditVitals"),
            cancelEditButton = self.$(byText("Cancel")),
            saveButton = self.$("[id*='btnSave']"),

            actualTimeTextBox = self.$("#ActualTime_I"),
            heightTextBox = self.$("#Height_I"),
            weightTextBox = self.$("#Weight_I"),
            temperatureTextBox = self.$("#Temperature_I"),
            hearthRateTextBox = self.$("#HeartRate_I"),
            bloodPressureSystolicTextBox = self.$("#BloodPressureSystolic_I"),
            bloodPressureDiastolicTextBox = self.$("#BloodPressureDiastolic_I");

    public ChangeReasonSection changeReasonPopup() {
        return changeReasonPopup;
    }
}
