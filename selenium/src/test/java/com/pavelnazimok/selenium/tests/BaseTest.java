package com.pavelnazimok.selenium.tests;

import com.pavelnazimok.selenium.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    public static final int TIMEOUT_IMPLICIT_WAIT = 10;
    public static final int TIMEOUT_EXPLICIT_WAIT = 10;

    private WebDriver driver;

    @BeforeEach
    public void setUpBase() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT_IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDownBase() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected LoginPage openSite() {
        driver.get("https://demos.devexpress.com/RWA/ClinicalStudy/");
        return new LoginPage(driver);
    }
}
