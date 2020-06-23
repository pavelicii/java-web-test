package com.pavelnazimok.selenide.sections;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

@SuppressWarnings("UnusedReturnValue")
public class HeaderSection {

    private final SelenideElement self = $("#headerContent");

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    private final SelenideElement
            helloField = self.$(".loggedUser").$(withText("Hello")),
            logoutButton = self.$("#btnLogout_CD");

    @Step("Click 'logout' button")
    public HeaderSection clickLogoutButton() {
        logoutButton.click();
        return this;
    }

    @Step("Assert greet message has name: {username}")
    public HeaderSection shouldGreetUser(final String username) {
        helloField.shouldHave(Condition.exactText("Hello, " + username));
        return this;
    }
}
