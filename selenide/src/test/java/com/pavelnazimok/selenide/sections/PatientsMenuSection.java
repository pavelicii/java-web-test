package com.pavelnazimok.selenide.sections;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.pavelnazimok.selenide.utils.SelenideExtensions.javaScriptClick;

public class PatientsMenuSection {

    private final SelenideElement self = $("#patientNavigation");

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    private final SelenideElement
            newPatientButton = self.$("#btnNewPatient_CD"),
            activeTab = self.$("#navigationLeftTab").$(byText("Active")),
            inactiveTab = self.$("#navigationLeftTab").$(byText("Inactive"));

    @Step("Click 'new patient' button")
    public PatientsMenuSection clickNewPatientButton() {
        newPatientButton.execute(javaScriptClick());
        return this;
    }

    @Step("Click on patient {patient}")
    public PatientsMenuSection clickPatient(final String patient) {
        self.$("#PatientListGrid").$(byText(patient)).execute(javaScriptClick());
        sleep(500); // Known bug: If you open any Patient tab too fast it will automatically switch to the previous one
        return this;
    }

    @Step("Click on patient number {rowNumber}")
    public PatientsMenuSection clickPatient(final int rowNumber) {
        self.$$("#PatientListGrid_DXMainTable tr").get(rowNumber).execute(javaScriptClick());
        sleep(500);
        return this;
    }
}
