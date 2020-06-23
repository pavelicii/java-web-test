package com.pavelnazimok.selenide.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

@SuppressWarnings("UnusedReturnValue")
public class LoginPage {

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    private final SelenideElement
            drMitchellButton = $("#uc_dmitchell"),
            drOliverButton = $("#uc_moliver"),
            enterAsDrMitchellButton = $("#Logondmitchell_CD"),
            enterAsDrOliverButton = $("#Logonmoliver_CD");

    @Step("Open login page URL")
    public LoginPage open() {
        Selenide.open("/");
        return this;
    }

    @Step("Login as Dr.Mitchell")
    public LoginPage loginAsDrMitchell() {
        drMitchellButton.click();
        enterAsDrMitchellButton.click();
        return this;
    }

    @Step("Login as Dr.Oliver")
    public LoginPage loginAsDrOliver() {
        drOliverButton.click();
        enterAsDrOliverButton.click();
        return this;
    }
}
