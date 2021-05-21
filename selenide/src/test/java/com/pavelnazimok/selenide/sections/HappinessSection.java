package com.pavelnazimok.selenide.sections;

import com.codeborne.selenide.SelenideElement;
import com.pavelnazimok.selenide.utils.HappinessLevel;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.sleep;

public class HappinessSection {

    private final ChangeReasonSection changeReasonPopup = new ChangeReasonSection();

    private final SelenideElement self = $(withText("Happiness")).parent();

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    private final SelenideElement
            happinessLevelField = self.$("#HappinessLevel"),

            editButton = self.$("#btnEditHappiness"),
            cancelEditButton = self.$(byText("Cancel")),
            saveButton = self.$("[id*='btnSave']"),

            totallyUnhappyLabel = self.$("#HappinessLevel_TK0"),
            unhappyLabel = self.$("#HappinessLevel_TK1"),
            happyLabel = self.$("#HappinessLevel_TK2"),
            prettyHappyLabel = self.$("#HappinessLevel_TK3"),
            totallyHappyLabel = self.$("#HappinessLevel_TK4"),

            sliderTrack = self.$("#HappinessLevel_T"),
            sliderThumb = self.$("#HappinessLevel_MD");

    public ChangeReasonSection changeReasonPopup() {
        return changeReasonPopup;
    }

    @Step("Click 'edit happiness' button")
    public HappinessSection clickEditButton() {
        editButton.click();
        return this;
    }

    @Step("Click 'save happiness' button")
    public HappinessSection clickSaveButton() {
        saveButton.click();
        return this;
    }

    @Step("Set happiness level to position {position}")
    public HappinessSection setHappinessLevel(final int position) {
        final int sliderTrackLeftMostPosition = -(sliderTrack.getSize().getWidth() / 2);
        sliderTrack.click(sliderTrackLeftMostPosition, 0);
        sleep(500);

        final int levelOffset = sliderTrack.getSize().getWidth() / 5; // Total count of positions could be a parameter

        actions().dragAndDropBy(sliderThumb, levelOffset * position, 0).perform();

        return this;
    }

    @Step("Assert happiness level equals {happinessLevel}")
    public HappinessSection shouldHaveHappinessLevel(final HappinessLevel happinessLevel) {
        happinessLevelField.shouldHave(exactText(happinessLevel.value));
        return this;
    }
}
