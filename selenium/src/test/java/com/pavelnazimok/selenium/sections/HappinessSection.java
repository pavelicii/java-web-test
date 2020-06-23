package com.pavelnazimok.selenium.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HappinessSection<T> extends BaseSection<T> {

    public static final String LEVEL_TOTALLY_UNHAPPY = "Totally Unhappy (0%)";
    public static final String LEVEL_UNHAPPY = "Unhappy (25%)";
    public static final String LEVEL_HAPPY = "Happy (50%)";
    public static final String LEVEL_PRETTY_UNHAPPY = "Pretty Happy (75%)";
    public static final String LEVEL_TOTALLY_HAPPY = "Totally Happy (100%)";

    public HappinessSection(final WebDriver driver, final T pageType) {
        super(driver, pageType);
        changeReasonPopup = new ChangeReasonSection<>(driver, T);
    }

    private final ChangeReasonSection<T> changeReasonPopup;

    @FindBy(id = "HappinessLevel")
    private WebElement happinessLevelField;

    @FindBy(id = "btnEditHappiness")
    private WebElement editButton;

    @FindBy(id = "HappinessLevel_TK0")
    private WebElement totallyUnhappyLabel;

    @FindBy(id = "HappinessLevel_TK1")
    private WebElement unhappyLabel;

    @FindBy(id = "HappinessLevel_TK2")
    private WebElement happyLabel;

    @FindBy(id = "HappinessLevel_TK3")
    private WebElement prettyHappyLabel;

    @FindBy(id = "HappinessLevel_TK4")
    private WebElement totallyHappyLabel;

    @FindBy(id = "HappinessLevel_T")
    private WebElement sliderTrack;

    @FindBy(id = "HappinessLevel_MD")
    private WebElement sliderThumb;

    @FindBy(xpath = "//h2[contains(text(), 'Happiness')]/parent::*//div[contains(@id, 'btnSave')]")
    private WebElement saveButton;

    @FindBy(xpath = "//h2[contains(text(), 'Happiness')]/parent::*//a[text() = 'Cancel']")
    private WebElement cancelEditButton;

    public ChangeReasonSection<T> changeReasonPopup() {
        return changeReasonPopup;
    }

    public String getHappinessLevel() {
        return happinessLevelField.getText();
    }

    public T clickEdit() {
        editButton.click();
        waitUntilLoadingIndicatorDisappears();
        return T;
    }

    public T clickSave() {
        saveButton.click();
        waitUntilLoadingIndicatorDisappears();
        return T;
    }

    public T clickCancelEdit() {
        cancelEditButton.click();
        waitUntilLoadingIndicatorDisappears();
        return T;
    }

    public T moveSliderToPosition(final int position) {
        final int sliderTrackLeftMostPosition = -(sliderTrack.getSize().getWidth() / 2);
        actions().moveToElement(sliderTrack, sliderTrackLeftMostPosition, 0).click().perform();
        sleep(500);

        final int levelOffset = sliderTrack.getSize().getWidth() / 5; // Total count of positions could be a parameter

        actions().dragAndDropBy(sliderThumb, levelOffset * (position - 1), 0).perform();

        return T;
    }

    public T setTotallyUnhappy() {
        totallyHappyLabel.click();
        return T;
    }

    public T setUnhappy() {
        unhappyLabel.click();
        return T;
    }

    public T setHappy() {
        happyLabel.click();
        return T;
    }

    public T setPrettyHappy() {
        prettyHappyLabel.click();
        return T;
    }

    public T setTotallyHappy() {
        totallyHappyLabel.click();
        return T;
    }
}
