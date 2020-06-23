package com.pavelnazimok.selenium.sections;

import com.pavelnazimok.selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;

public abstract class BaseSection<T> extends BasePage {

    @SuppressWarnings("checkstyle:MemberName")
    protected T T;

    public BaseSection(final WebDriver driver, final T pageType) {
        super(driver);
        this.T = pageType;
    }
}
