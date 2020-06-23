package com.pavelnazimok.selenium.pages;

import com.pavelnazimok.selenium.sections.PatientTabsSection;
import com.pavelnazimok.selenium.sections.PatientsMenuSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientSummaryPage extends BasePage {

    public PatientSummaryPage(final WebDriver driver) {
        super(driver);
        patientsMenu = new PatientsMenuSection<>(driver, this);
        patientTabs = new PatientTabsSection<>(driver, this);
    }

    private final PatientsMenuSection<PatientSummaryPage> patientsMenu;
    private final PatientTabsSection<PatientSummaryPage> patientTabs;

    @FindBy(id = "PatientInitialsLabel")
    private WebElement patientInitialsField;

    @FindBy(xpath = "//label[@id='dxLabelForPatientNumber']/following-sibling::span")
    private WebElement patientNumberField;

    @FindBy(id = "IsActive")
    private WebElement activeField;

    @FindBy(id = "IsEnrolled")
    private WebElement enrolledField;

    @FindBy(id = "EnrollDate")
    private WebElement enrollDateField;

    @FindBy(id = "RandomisationNumber")
    private WebElement randomizationNumberField;

    @FindBy(id = "RandomisationDate")
    private WebElement randomizationDateField;

    @FindBy(id = "btnEditPatient_CD")
    private WebElement editButton;

    public PatientsMenuSection<PatientSummaryPage> patientsMenu() {
        return patientsMenu;
    }

    public PatientTabsSection<PatientSummaryPage> patientTabs() {
        return patientTabs;
    }

    public String getPatientInitials() {
        return patientInitialsField.getText();
    }

    public String getPatientNumber() {
        return patientNumberField.getText();
    }

    public String getActiveStatus() {
        return activeField.getText();
    }

    public String getEnrolledStatus() {
        return enrolledField.getText();
    }

    public String getEnrolledDate() {
        return enrollDateField.getText();
    }

    public String getRandomizationNumber() {
        return randomizationNumberField.getText();
    }

    public String getRandomizationDate() {
        return randomizationDateField.getText();
    }
}
