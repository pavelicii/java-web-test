package com.pavelnazimok.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import com.pavelnazimok.selenide.sections.PatientsMenuSection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.pavelnazimok.selenide.utils.SelenideExtensions.setChecked;

@SuppressWarnings("UnusedReturnValue")
public class NewPatientPage {

    private final PatientsMenuSection patientsMenu = new PatientsMenuSection();

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    private final SelenideElement
            patientInitialsTextBox = $("#PatientInitials_I"),
            patientNumberField = $("#dxLabelForPatientNumber").parent().$("span"),
            activeCheckBox = $("#IsActive_S_D"),
            enrolledCheckBox = $("#IsEnrolled_S_D"),
            enrollDateTextBox = $("#EnrollDate_I"),
            randomizationNumberTextBox = $("#RandomisationNumber_I"),
            randomizationNumberUpButton = $("#dxLabelForRandomisationNumber").parent().$("[alt='+']"),
            randomizationNumberDownButton = $("#dxLabelForRandomisationNumber").parent().$("[alt='-']"),
            randomizationDateTextBox = $("#RandomisationDate_I"),
            saveButton = $("#btnSave");

    public PatientsMenuSection patientsMenu() {
        return patientsMenu;
    }

    @Step("Type patient's initials: {initials}")
    public NewPatientPage typePatientInitials(final String initials) {
        patientInitialsTextBox.setValue(initials);
        return this;
    }

    @Step("Set Active status to {active}")
    public NewPatientPage setActive(final boolean active) {
        activeCheckBox.execute(setChecked(active));
        return this;
    }

    @Step("Set enrolled status to {enrolled}")
    public NewPatientPage setEnrolled(final boolean enrolled) {
        enrolledCheckBox.execute(setChecked(enrolled));
        return this;
    }

    @Step("Click 'save new patient' button")
    public NewPatientPage clickSaveButton() {
        saveButton.click();
        return this;
    }

    @Step("Create new patient")
    public NewPatientPage createNewPatient(
            final String initials,
            final boolean active,
            final boolean enrolled,
            final String enrollDate,
            final String randomizationNumber,
            final String randomizationDate
    ) {
        patientInitialsTextBox.setValue(initials);
        setActive(active);
        setEnrolled(enrolled);
        enrollDateTextBox.setValue(enrollDate);
        randomizationNumberTextBox.setValue(randomizationNumber);
        randomizationDateTextBox.setValue(randomizationDate);
        saveButton.click();
        return this;
    }
}
