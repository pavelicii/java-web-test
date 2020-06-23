package com.pavelnazimok.selenide.pages;

import com.pavelnazimok.selenide.sections.DemographicsSection;
import com.pavelnazimok.selenide.sections.PatientTabsSection;
import com.pavelnazimok.selenide.sections.PatientsMenuSection;
import com.pavelnazimok.selenide.sections.VisitInfoSection;
import com.pavelnazimok.selenide.sections.VitalsSection;

public class PatientBaselinePage {

    private final PatientsMenuSection patientsMenu = new PatientsMenuSection();
    private final PatientTabsSection patientTabs = new PatientTabsSection();
    private final VisitInfoSection visitInfo = new VisitInfoSection();
    private final DemographicsSection demographics = new DemographicsSection();
    private final VitalsSection vitals = new VitalsSection();

    public PatientsMenuSection patientsMenu() {
        return patientsMenu;
    }

    public PatientTabsSection patientTabs() {
        return patientTabs;
    }

    public VisitInfoSection visitInfo() {
        return visitInfo;
    }

    public DemographicsSection demographics() {
        return demographics;
    }

    public VitalsSection vitals() {
        return vitals;
    }
}
