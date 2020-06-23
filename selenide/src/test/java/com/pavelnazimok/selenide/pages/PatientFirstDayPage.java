package com.pavelnazimok.selenide.pages;

import com.pavelnazimok.selenide.sections.HappinessSection;
import com.pavelnazimok.selenide.sections.PatientTabsSection;
import com.pavelnazimok.selenide.sections.PatientsMenuSection;
import com.pavelnazimok.selenide.sections.VisitInfoSection;
import com.pavelnazimok.selenide.sections.VitalsSection;

public class PatientFirstDayPage {

    private final PatientsMenuSection patientsMenu = new PatientsMenuSection();
    private final PatientTabsSection patientTabs = new PatientTabsSection();
    private final VisitInfoSection visitInfo = new VisitInfoSection();
    private final HappinessSection happiness = new HappinessSection();
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

    public HappinessSection happiness() {
        return happiness;
    }

    public VitalsSection vitals() {
        return vitals;
    }
}
