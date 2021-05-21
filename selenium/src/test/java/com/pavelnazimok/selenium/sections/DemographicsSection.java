package com.pavelnazimok.selenium.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemographicsSection<T> extends BaseSection<T> {

    public DemographicsSection(final WebDriver driver, final T pageType) {
        super(driver, pageType);
        changeReasonPopup = new ChangeReasonSection<>(driver, this.pageType);
    }

    private final ChangeReasonSection<T> changeReasonPopup;

    @FindBy(id = "DateOfBirth")
    private WebElement dateOfBirthField;

    @FindBy(id = "Race")
    private WebElement raceField;

    @FindBy(id = "Sex")
    private WebElement sexField;

    @FindBy(id = "Other")
    private WebElement otherField;

    @FindBy(id = "btnEditDemog")
    private WebElement editButton;

    @FindBy(id = "DateOfBirth_I")
    private WebElement dateOfBirthDropdown;

    @FindBy(id = "Race_I")
    private WebElement raceDropdown;

    @FindBy(id = "Sex_I")
    private WebElement sexDropdown;

    @FindBy(id = "Other_I")
    private WebElement otherTextBox;

    @FindBy(xpath = "//h2[contains(text(), 'Demographics')]/parent::*//div[contains(@id, 'btnSave')]")
    private WebElement saveButton;

    @FindBy(xpath = "//h2[contains(text(), 'Demographics')]/parent::*//a[text() = 'Cancel']")
    private WebElement cancelEditButton;

    public ChangeReasonSection<T> changeReasonPopup() {
        return changeReasonPopup;
    }

    public String getSex() {
        return sexField.getText();
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

    public T selectSex(final String sex) {
        this.sexDropdown.click();
        waitUntilElementIsClickable(
                driver.findElement(By.xpath(String.format("//td[@id='Sex_CC']//td[text() = '%s']", sex)))
        ).click();
        return pageType;
    }
}
