package com.pavelnazimok.selenide.tests;

import com.pavelnazimok.selenide.pages.LoginPage;
import com.pavelnazimok.selenide.pages.MainPage;
import com.pavelnazimok.selenide.pages.NewPatientPage;
import com.pavelnazimok.selenide.pages.PatientBaselinePage;
import com.pavelnazimok.selenide.pages.PatientFirstDayPage;
import com.pavelnazimok.selenide.pages.PatientSummaryPage;
import com.pavelnazimok.selenide.utils.HappinessLevel;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Feature("Patient profile")
public class PatientTest extends BaseTest {

    @BeforeEach
    public void login() {
        new LoginPage()
                .open()
                .loginAsDrMitchell();
    }

    @Test
    @Description("New patient creation with defined initials and enrolled status")
    public void shouldCreateNewPatient() {
        new MainPage().patientsMenu()
                .clickNewPatientButton();

        new NewPatientPage()
                .typePatientInitials("QW")
                .setEnrolled(true)
                .clickSaveButton();

        new PatientSummaryPage()
                .shouldHaveInitials("QW")
                .shouldBeEnrolled(true);
    }

    @Test
    @Description("Patient's sex change")
    public void shouldChangeSex() {
        new MainPage().patientsMenu()
                .clickPatient(0);
        new PatientSummaryPage().patientTabs()
                .clickBaselineTab();

        final PatientBaselinePage patientBaselinePage = new PatientBaselinePage();

        patientBaselinePage.demographics()
                .clickEditButton()
                .selectSex("Female")
                .clickSaveButton();
        patientBaselinePage.demographics().changeReasonPopup()
                .typeReason("Some reason")
                .clickSaveButton();
        patientBaselinePage.demographics()
                .shouldHaveSex("Female");
    }

    @Test
    @Description("Patient's happiness level change")
    public void shouldChangeHappinessLevel() {
        new MainPage().patientsMenu()
                .clickPatient(0);

        new PatientSummaryPage().patientTabs()
                .clickFirstDayTab();

        final PatientFirstDayPage patientFirstDayPage = new PatientFirstDayPage();

        patientFirstDayPage.happiness()
                .clickEditButton()
                .setHappinessLevel(4)
                .clickSaveButton();
        patientFirstDayPage.happiness().changeReasonPopup()
                .typeReason("Some reason")
                .clickSaveButton();
        patientFirstDayPage.happiness()
            .shouldHaveHappinessLevel(HappinessLevel.TOTALLY_HAPPY);
    }
}
