package com.pavelnazimok.selenium.tests;

import com.pavelnazimok.selenium.pages.LoginPage;
import com.pavelnazimok.selenium.pages.MainPage;
import com.pavelnazimok.selenium.pages.NewPatientPage;
import com.pavelnazimok.selenium.pages.PatientBaselinePage;
import com.pavelnazimok.selenium.pages.PatientFirstDayPage;
import com.pavelnazimok.selenium.pages.PatientSummaryPage;
import com.pavelnazimok.selenium.sections.HappinessSection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PatientTest extends BaseTest {

    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        mainPage = new LoginPage(getDriver()).open().loginAsDrMitchell();
    }

    @Test
    public void shouldCreateNewPatient() {
        final NewPatientPage newPatientPage = mainPage
                .patientsMenu().clickNewPatient();

        final PatientSummaryPage patientSummaryPage = newPatientPage
                .typePatientInitials("QW")
                .setEnrolled(true)
                .clickSave();

        assertThat(patientSummaryPage.getPatientInitials())
                .as("Patient's initials")
                .isEqualTo("QW");
        assertThat(patientSummaryPage.getEnrolledStatus())
                .as("Enrolled status")
                .isEqualTo("Yes");
    }

    @Test
    public void shouldChangeSex() {
        final PatientBaselinePage patientBaselinePage = mainPage
                .patientsMenu().clickPatient(1)
                .patientTabs().clickBaselineTab();

        patientBaselinePage
                .demographics().clickEdit()
                .demographics().selectSex("Female")
                .demographics().clickSave()
                .demographics().changeReasonPopup().typeChangeReason("Some reason")
                .demographics().changeReasonPopup().clickSaveButton();

        assertThat(patientBaselinePage.demographics().getSex())
                .as("Patient's sex")
                .isEqualTo("Female");
    }

    @Test
    public void shouldChangeHappinessLevel() {
        final PatientFirstDayPage patientFirstDayPage = mainPage
                .patientsMenu().clickPatient(1)
                .patientTabs().clickFirstDayTab();

        patientFirstDayPage
                .happiness().clickEdit()
                .happiness().moveSliderToPosition(5)
                .happiness().clickSave()
                .happiness().changeReasonPopup().typeChangeReason("Some reason")
                .happiness().changeReasonPopup().clickSaveButton();

        assertThat(patientFirstDayPage.happiness().getHappinessLevel())
                .as("Patient's happiness level")
                .isEqualTo(HappinessSection.LEVEL_TOTALLY_HAPPY);
    }
}
