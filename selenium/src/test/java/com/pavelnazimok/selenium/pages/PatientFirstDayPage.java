package com.pavelnazimok.selenium.pages;

import com.pavelnazimok.selenium.sections.HappinessSection;
import com.pavelnazimok.selenium.sections.PatientTabsSection;
import com.pavelnazimok.selenium.sections.PatientsMenuSection;
import com.pavelnazimok.selenium.sections.VisitInfoSection;
import com.pavelnazimok.selenium.sections.VitalsSection;
import org.openqa.selenium.WebDriver;

public class PatientFirstDayPage extends BasePage {

    public PatientFirstDayPage(final WebDriver driver) {
        super(driver);
        patientsMenu = new PatientsMenuSection<>(driver, this);
        patientTabs = new PatientTabsSection<>(driver, this);
        visitInfo = new VisitInfoSection<>(driver, this);
        happiness = new HappinessSection<>(driver, this);
        vitals = new VitalsSection<>(driver, this);
    }

    private final PatientsMenuSection<PatientFirstDayPage> patientsMenu;
    private final PatientTabsSection<PatientFirstDayPage> patientTabs;
    private final VisitInfoSection<PatientFirstDayPage> visitInfo;
    private final HappinessSection<PatientFirstDayPage> happiness;
    private final VitalsSection<PatientFirstDayPage> vitals;

    public PatientsMenuSection<PatientFirstDayPage> patientsMenu() {
        return patientsMenu;
    }

    public PatientTabsSection<PatientFirstDayPage> patientTabs() {
        return patientTabs;
    }

    public VisitInfoSection<PatientFirstDayPage> visitInfo() {
        return visitInfo;
    }

    public HappinessSection<PatientFirstDayPage> happiness() {
        return happiness;
    }

    public VitalsSection<PatientFirstDayPage> vitals() {
        return vitals;
    }
}
