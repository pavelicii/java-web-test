package com.pavelnazimok.selenium.pages;

import com.pavelnazimok.selenium.sections.DemographicsSection;
import com.pavelnazimok.selenium.sections.PatientTabsSection;
import com.pavelnazimok.selenium.sections.PatientsMenuSection;
import com.pavelnazimok.selenium.sections.VisitInfoSection;
import com.pavelnazimok.selenium.sections.VitalsSection;
import org.openqa.selenium.WebDriver;

public class PatientBaselinePage extends BasePage {

    public PatientBaselinePage(final WebDriver driver) {
        super(driver);
        patientsMenu = new PatientsMenuSection<>(driver, this);
        patientTabs = new PatientTabsSection<>(driver, this);
        visitInfo = new VisitInfoSection<>(driver, this);
        demographics = new DemographicsSection<>(driver, this);
        vitals = new VitalsSection<>(driver, this);
    }

    private final PatientsMenuSection<PatientBaselinePage> patientsMenu;
    private final PatientTabsSection<PatientBaselinePage> patientTabs;
    private final VisitInfoSection<PatientBaselinePage> visitInfo;
    private final DemographicsSection<PatientBaselinePage> demographics;
    private final VitalsSection<PatientBaselinePage> vitals;

    public PatientsMenuSection<PatientBaselinePage> patientsMenu() {
        return patientsMenu;
    }

    public PatientTabsSection<PatientBaselinePage> patientTabs() {
        return patientTabs;
    }

    public VisitInfoSection<PatientBaselinePage> visitInfo() {
        return visitInfo;
    }

    public DemographicsSection<PatientBaselinePage> demographics() {
        return demographics;
    }

    public VitalsSection<PatientBaselinePage> vitals() {
        return vitals;
    }
}
