package com.pavelnazimok.selenide.sections;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class DemographicsSection {

    private final ChangeReasonSection changeReasonPopup = new ChangeReasonSection();

    private final SelenideElement self = $(withText("Demographics")).parent();

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    private final SelenideElement
            dateOfBirthField = self.$("#DateOfBirth"),
            raceField = self.$("#Race"),
            sexField = self.$("#Sex"),
            otherField = self.$("Other"),

            editButton = self.$("#btnEditDemog"),
            cancelEditButton = self.$(byText("Cancel")),
            saveButton = self.$("[id*='btnSave']"),

            dateOfBirthDropdown = self.$("#VisitDate_I"),
            raceDropdown = self.$("#VisitTime_I"),
            sexDropdown = self.$("#Sex_I"),
            otherTextBox = self.$("#Other_I");

    public ChangeReasonSection changeReasonPopup() {
        return changeReasonPopup;
    }

    @Step("Click 'edit demographics' button")
    public DemographicsSection clickEditButton() {
        editButton.click();
        return this;
    }

    @Step("Click 'save demographics' button")
    public DemographicsSection clickSaveButton() {
        saveButton.click();
        return this;
    }

    @Step("Select {sex} from sex dropdown")
    public DemographicsSection selectSex(final String sex) {
        sexDropdown.click();
        $("#Sex_CC").$(byText(sex)).click();
        return this;
    }

    @Step("Assert patient's sex equals {sex}")
    public DemographicsSection shouldHaveSex(final String sex) {
        sexField.shouldHave(exactText(sex));
        return this;
    }
}
