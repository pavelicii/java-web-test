package com.pavelnazimok.selenium.sections;

import com.pavelnazimok.selenium.pages.NewPatientPage;
import com.pavelnazimok.selenium.pages.PatientSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientsMenuSection<T> extends BaseSection<T> {

    public PatientsMenuSection(final WebDriver driver, final T pageType) {
        super(driver, pageType);
    }

    @FindBy(id = "btnNewPatient_CD")
    private WebElement newPatientButton;

    @FindBy(xpath = "//a[contains(@id, 'navigationLeftTab')]/span[text() = 'Active']")
    private WebElement activeTab;

    @FindBy(xpath = "//a[contains(@id, 'navigationLeftTab')]/span[text() = 'Inactive']")
    private WebElement inactiveTab;

    public NewPatientPage clickNewPatient() {
        waitUntilElementIsClickable(newPatientButton).click();
        return new NewPatientPage(driver);
    }

    public T clickActiveTab() {
        waitUntilElementIsClickable(activeTab).click();
        return pageType;
    }

    public T clickInactiveTab() {
        waitUntilElementIsClickable(inactiveTab).click();
        return pageType;
    }

    public PatientSummaryPage clickPatient(final String patient) {
        waitUntilElementIsClickable(
                driver.findElement(By.xpath(String.format("//table[@id = 'PatientListGrid_DXMainTable']//div[@class = 'patientItem']//span[text() = '%s']", patient)))
        ).click();
        waitUntilLoadingIndicatorDisappears();
        sleep(500); // Known bug: If you open any Patient tab too fast it will automatically switch to the previous one
        return new PatientSummaryPage(driver);
    }

    public PatientSummaryPage clickPatient(final int rowNumber) {
        waitUntilElementIsClickable(
                driver.findElement(By.xpath(String.format("//table[@id = 'PatientListGrid_DXMainTable']//tr[%d]", rowNumber)))
        ).click();
        waitUntilLoadingIndicatorDisappears();
        sleep(500);
        return new PatientSummaryPage(driver);
    }
}
