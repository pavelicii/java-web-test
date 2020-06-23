package com.pavelnazimok.selenide.sections;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

@SuppressWarnings("UnusedReturnValue")
public class ChangeReasonSection {

    private final SelenideElement self = $("[id*='pcChangeNotification'] .dxpc-mainDiv");

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    private final SelenideElement
            changeReasonTextBox = self.$x(".//textarea[contains(@id, 'ChangeReason_I')]"),
            saveButton = self.$("[id*='NoteSave']"),
            cancelButton = self.$("[id*='NoteCancel']");

    @Step("Type change reason: {reason}")
    public ChangeReasonSection typeReason(final String reason) {
        changeReasonTextBox.setValue(reason);
        return this;
    }

    @Step("Click 'save change reason' button")
    public ChangeReasonSection clickSaveButton() {
        saveButton.click();
        return this;
    }
}
