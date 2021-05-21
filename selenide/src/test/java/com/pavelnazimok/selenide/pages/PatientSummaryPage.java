package com.pavelnazimok.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import com.pavelnazimok.selenide.sections.PatientTabsSection;
import com.pavelnazimok.selenide.sections.PatientsMenuSection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class PatientSummaryPage {

    private final PatientsMenuSection patientsMenu = new PatientsMenuSection();
    private final PatientTabsSection patientTabs = new PatientTabsSection();

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    private final SelenideElement
            patientInitialsField = $("#PatientInitialsLabel"),
            patientNumberField = $("#dxLabelForPatientNumber").parent().$("span"),
            activeField = $("#IsActive"),
            enrolledField = $("#IsEnrolled"),
            enrollDateField = $("#EnrollDate"),
            randomizationNumberField = $("#RandomisationNumber"),
            randomizationDateField = $("#RandomisationDate"),
            editButton = $("#btnEditPatient");

    public PatientsMenuSection patientsMenu() {
        return patientsMenu;
    }

    public PatientTabsSection patientTabs() {
        return patientTabs;
    }

    @Step("Assert patient's initials equal {initials}")
    public PatientSummaryPage shouldHaveInitials(final String initials) {
        patientInitialsField.shouldHave(exactText(initials));
        return this;
    }

    @Step("Assert patient's enrolled status equals {enrolled}")
    public PatientSummaryPage shouldBeEnrolled(final boolean enrolled) {
        if (enrolled) {
            enrolledField.shouldHave(exactText("Yes"));
        } else {
            enrolledField.shouldHave(exactText("No"));
        }
        return this;
    }
}
