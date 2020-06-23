package com.pavelnazimok.selenide.utils;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class SelenoidRemoteWebDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(final DesiredCapabilities capabilities) {
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("83.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        try {
            return new RemoteWebDriver(
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    capabilities
            );
        } catch (final MalformedURLException e) {
            throw new RuntimeException("Unable to create driver", e);
        }
    }
}
