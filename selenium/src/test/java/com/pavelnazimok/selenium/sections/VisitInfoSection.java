package com.pavelnazimok.selenium.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VisitInfoSection<T> extends BaseSection<T> {

    public VisitInfoSection(final WebDriver driver, final T pageType) {
        super(driver, pageType);
        changeReasonPopup = new ChangeReasonSection<>(driver, this.pageType);
    }

    private final ChangeReasonSection<T> changeReasonPopup;

    @FindBy(id = "VisitDate")
    private WebElement visitDateField;

    @FindBy(id = "VisitTime")
    private WebElement visitTimeField;

    @FindBy(id = "ExpectedVisitDate")
    private WebElement expectedVisitDateField;

    @FindBy(id = "btnEditVisit")
    private WebElement editButton;

    @FindBy(id = "VisitDate_I")
    private WebElement visitDateTextBox;

    @FindBy(id = "VisitTime_I")
    private WebElement visitTimeTextBox;

    @FindBy(id = "ExpectedVisitDate_I")
    private WebElement expectedVisitDateTextBox;

    @FindBy(xpath = "//h2[contains(text(), 'Visit Information')]/parent::*//div[contains(@id, 'btnSave')]")
    private WebElement saveButton;

    @FindBy(xpath = "//h2[contains(text(), 'Visit Information')]/parent::*//a[text() = 'Cancel']")
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
