package com.pavelnazimok.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(final WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "uc_dmitchell")
    private WebElement drMitchellButton;

    @FindBy(id = "uc_moliver")
    private WebElement drOliverButton;

    @FindBy(id = "Logondmitchell_CD")
    private WebElement enterAsDrMitchellButton;

    @FindBy(id = "Logonmoliver_CD")
    private WebElement enterAsDrOliverButton;

    public LoginPage open() {
        driver.get("https://demos.devexpress.com/RWA/ClinicalStudy/");
        return new LoginPage(driver);
    }

    public MainPage loginAsDrMitchell() {
        drMitchellButton.click();
        enterAsDrMitchellButton.click();
        waitUntilLoadingIndicatorDisappears();
        return new MainPage(driver);
    }

    public MainPage loginAsDrOliver() {
        drOliverButton.click();
        enterAsDrOliverButton.click();
        waitUntilLoadingIndicatorDisappears();
        return new MainPage(driver);
    }
}
