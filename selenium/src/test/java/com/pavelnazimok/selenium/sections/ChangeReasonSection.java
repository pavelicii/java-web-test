package com.pavelnazimok.selenium.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangeReasonSection<T> extends BaseSection<T> {

    public ChangeReasonSection(final WebDriver driver, final T pageType) {
        super(driver, pageType);
    }

    @FindBy(xpath = "//textarea[contains(@id, 'ChangeReason_I')]")
    private WebElement changeReasonTextBox;

    @FindBy(xpath = "//div[contains(@id, 'NoteSave')]")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@id, 'NoteCancel')]")
    private WebElement cancelButton;

    public T typeChangeReason(final String reason) {
        changeReasonTextBox.sendKeys(reason);
        return pageType;
    }

    public T clickSaveButton() {
        saveButton.click();
        waitUntilLoadingIndicatorDisappears();
        return pageType;
    }

    public T clickCancelButton() {
        cancelButton.click();
        waitUntilLoadingIndicatorDisappears();
        return pageType;
    }
}
