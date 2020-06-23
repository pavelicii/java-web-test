package com.pavelnazimok.selenide.utils;

import com.codeborne.selenide.Command;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class SelenideExtensions {

    public static Command<SelenideElement> setChecked(final boolean checked) {
        return (proxy, locator, args) -> {
            if (checked && !proxy.isSelected()) {
                proxy.click();
            } else if (!checked && proxy.isSelected()) {
                proxy.click();
            }
            return proxy;
        };
    }

    public static Command<SelenideElement> javaScriptClick() {
        return (proxy, locator, args) -> {
            executeJavaScript("arguments[0].click()", proxy);
            return proxy;
        };
    }

    public static Condition clickable = and("can be clicked", visible, enabled);
}
