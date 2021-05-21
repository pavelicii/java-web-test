package com.pavelnazimok.selenium.sections;

import com.pavelnazimok.selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;

public abstract class BaseSection<T> extends BasePage {

    protected T pageType;

    public BaseSection(final WebDriver driver, final T pageType) {
        super(driver);
        this.pageType = pageType;
    }
}
