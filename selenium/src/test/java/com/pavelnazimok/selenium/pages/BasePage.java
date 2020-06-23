package com.pavelnazimok.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.pavelnazimok.selenium.tests.BaseTest.TIMEOUT_EXPLICIT_WAIT;
import static com.pavelnazimok.selenium.tests.BaseTest.TIMEOUT_IMPLICIT_WAIT;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, TIMEOUT_EXPLICIT_WAIT);
    }

    public Actions actions() {
        return new Actions(driver);
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    protected void sleep(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void waitUntilLoadingIndicatorDisappears() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingIndicator_LD")));
        driver.manage().timeouts().implicitlyWait(TIMEOUT_IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    protected WebElement waitUntilElementIsClickable(final WebElement webElement) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        driver.manage().timeouts().implicitlyWait(TIMEOUT_IMPLICIT_WAIT, TimeUnit.SECONDS);
        return webElement;
    }
}
