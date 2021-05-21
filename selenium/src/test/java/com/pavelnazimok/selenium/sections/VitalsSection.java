package com.pavelnazimok.selenium.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VitalsSection<T> extends BaseSection<T> {

    public VitalsSection(final WebDriver driver, final T pageType) {
        super(driver, pageType);
        changeReasonPopup = new ChangeReasonSection<>(driver, this.pageType);
    }

    private final ChangeReasonSection<T> changeReasonPopup;

    @FindBy(id = "ActualTime")
    private WebElement actualTimeField;

    @FindBy(id = "Height")
    private WebElement heightField;

    @FindBy(id = "Weight")
    private WebElement weightField;

    @FindBy(id = "Temperature")
    private WebElement temperatureField;

    @FindBy(id = "HeartRate")
    private WebElement hearthRateField;

    @FindBy(id = "BloodPressureSystolic")
    private WebElement bloodPressureSystolicField;

    @FindBy(id = "BloodPressureDiastolic")
    private WebElement bloodPressureDiastolicField;

    @FindBy(id = "btnEditVitals")
    private WebElement editButton;

    @FindBy(id = "ActualTime_I")
    private WebElement actualTimeTextBox;

    @FindBy(id = "Height_I")
    private WebElement heightTextBox;

    @FindBy(id = "Weight_I")
    private WebElement weightTextBox;

    @FindBy(id = "Temperature_I")
    private WebElement temperatureTextBox;

    @FindBy(id = "HeartRate_I")
    private WebElement hearthRateTextBox;

    @FindBy(id = "BloodPressureSystolic_I")
    private WebElement bloodPressureSystolicTextBox;

    @FindBy(id = "BloodPressureDiastolic_I")
    private WebElement bloodPressureDiastolicTextBox;

    @FindBy(xpath = "//h2[contains(text(), 'Vitals')]/parent::*//div[contains(@id, 'btnSave')]")
    private WebElement saveButton;

    @FindBy(xpath = "//h2[contains(text(), 'Vitals')]/parent::*//a[text() = 'Cancel']")
    private WebElement cancelEditButton;

    public ChangeReasonSection<T> changeReasonPopup() {
        return changeReasonPopup;
    }

    public T clickEdit() {
        editButton.click();
        waitUntilLoadingIndicatorDisappears();
        return pageType;
    }

    public T clickSave() {
        saveButton.click();
        waitUntilLoadingIndicatorDisappears();
        return pageType;
    }

    public T clickCancelEdit() {
        cancelEditButton.click();
        waitUntilLoadingIndicatorDisappears();
        return pageType;
    }
}
