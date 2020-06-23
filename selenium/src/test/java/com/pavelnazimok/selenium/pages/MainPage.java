package com.pavelnazimok.selenium.pages;

import com.pavelnazimok.selenium.sections.PatientsMenuSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    public MainPage(final WebDriver driver) {
        super(driver);
        patientsMenu = new PatientsMenuSection<>(driver, this);
    }

    private final PatientsMenuSection<MainPage> patientsMenu;

    @FindBy(xpath = "//img[@alt='Add a New Patient']")
    private WebElement addNewPatientButton;

    @FindBy(xpath = "//img[@alt='View Queries']")
    private WebElement viewQueriesButton;

    public PatientsMenuSection<MainPage> patientsMenu() {
        return patientsMenu;
    }

    public NewPatientPage clickAddNewPatient() {
        addNewPatientButton.click();
        return new NewPatientPage(driver);
    }

    public QueriesPage clickViewQueries() {
        viewQueriesButton.click();
        return new QueriesPage(driver);
    }
}
