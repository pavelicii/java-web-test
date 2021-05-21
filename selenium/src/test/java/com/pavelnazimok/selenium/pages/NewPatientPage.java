package com.pavelnazimok.selenium.pages;

import com.pavelnazimok.selenium.sections.PatientsMenuSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPatientPage extends BasePage {

    public NewPatientPage(final WebDriver driver) {
        super(driver);
        patientsMenu = new PatientsMenuSection<>(driver, this);
    }

    private final PatientsMenuSection<NewPatientPage> patientsMenu;

    @FindBy(id = "PatientInitials_I")
    private WebElement patientInitialsTextBox;

    @FindBy(xpath = "//label[@id='dxLabelForPatientNumber']/following-sibling::span")
    private WebElement patientNumberField;

    @FindBy(id = "IsActive_S_D")
    private WebElement activeCheckBox;

    @FindBy(id = "IsEnrolled_S_D")
    private WebElement enrolledCheckBox;

    @FindBy(id = "EnrollDate_I")
    private WebElement enrollDateTextBox;

    @FindBy(id = "RandomisationNumber_I")
    private WebElement randomizationNumberTextBox;

    @FindBy(xpath = "//label[@id='dxLabelForRandomisationNumber']/following-sibling::*//img[@alt='+']")
    private WebElement randomizationNumberUpButton;

    @FindBy(xpath = "//label[@id='dxLabelForRandomisationNumber']/following-sibling::*//img[@alt='-']")
    private WebElement randomizationNumberDownButton;

    @FindBy(id = "RandomisationDate_I")
    private WebElement randomizationDateTextBox;

    @FindBy(id = "btnSave_CD")
    private WebElement saveButton;

    public PatientsMenuSection<NewPatientPage> patientsMenu() {
        return patientsMenu;
    }

    public NewPatientPage typePatientInitials(final String initials) {
        patientInitialsTextBox.sendKeys(initials);
        return this;
    }

    public NewPatientPage typeEnrollDate(final String date) {
        enrollDateTextBox.sendKeys(date);
        return this;
    }

    public NewPatientPage typeRandomizationDate(final String date) {
        randomizationDateTextBox.sendKeys(date);
        return this;
    }

    public NewPatientPage typeRandomizationNumber(final String number) {
        randomizationNumberTextBox.sendKeys(number);
        return this;
    }

    public NewPatientPage increaseRandomizationNumber() {
        randomizationNumberUpButton.click();
        return this;
    }

    public NewPatientPage decreaseRandomizationNumber() {
        randomizationNumberDownButton.click();
        return this;
    }

    public NewPatientPage setActive(final boolean active) {
        if (active && !activeCheckBox.isSelected()) {
            activeCheckBox.click();
        } else if (!active && activeCheckBox.isSelected()) {
            activeCheckBox.click();
        }
        return this;
    }

    public NewPatientPage setEnrolled(final boolean enrolled) {
        if (enrolled && !enrolledCheckBox.isSelected()) {
            enrolledCheckBox.click();
        } else if (!enrolled && enrolledCheckBox.isSelected()) {
            enrolledCheckBox.click();
        }
        return this;
    }

    public PatientSummaryPage clickSave() {
        saveButton.click();
        waitUntilLoadingIndicatorDisappears();
        return new PatientSummaryPage(driver);
    }

    public PatientSummaryPage createNewPatient(
            final String initials,
            final boolean active,
            final boolean enrolled,
            final String enrollDate,
            final String randomizationNumber,
            final String randomizationDate
    ) {
        typePatientInitials(initials);
        setActive(active);
        setEnrolled(enrolled);
        typeEnrollDate(enrollDate);
        typeRandomizationNumber(randomizationNumber);
        typeRandomizationDate(randomizationDate);
        clickSave();
        return new PatientSummaryPage(driver);
    }
}
