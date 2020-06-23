package com.pavelnazimok.selenide.tests;

import com.pavelnazimok.selenide.pages.LoginPage;
import com.pavelnazimok.selenide.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Feature("Login page")
public class LoginTest extends BaseTest {

    @BeforeEach
    public void openLoginPage() {
        new LoginPage().open();
    }

    // This test should fail for demonstration purposes
    @Test
    @Description("Login user greet message")
    public void shouldDisplayUserGreetMessage() {
        new LoginPage()
                .loginAsDrMitchell();

        new MainPage().header()
                .shouldGreetUser("Devid Mitchell");
    }
}
