package com.pavelnazimok.selenide.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.pavelnazimok.selenide.utils.SkipSearchStepsAllureListener;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    @BeforeAll
    public static void configureSelenide() {
        Configuration.baseUrl = "https://demos.devexpress.com/RWA/ClinicalStudy";
        Configuration.startMaximized = true;
        Configuration.screenshots = true;
        Configuration.savePageSource = false;
        Configuration.browser = "chrome";

        SelenideLogger.addListener("AllureSelenide", new SkipSearchStepsAllureListener()
                .includeSelenideSteps(true)
                .screenshots(true)
                .savePageSource(false)
        );
    }

    // Uncomment to run with Selenoid
//    @BeforeEach
//    public void configureSelenoid() {
//        Configuration.driverManagerEnabled = false;
//        Configuration.browser = SelenoidRemoteWebDriver.class.getName();
//    }

    @AfterEach
    public void clearBrowserHistory() {
        Selenide.clearBrowserLocalStorage();
        Selenide.clearBrowserCookies();
        WebDriverRunner.clearBrowserCache();
    }

    @AfterAll
    public static void deleteListenerFromCurrentThread() {
        SelenideLogger.removeListener("AllureSelenide");
    }
}
