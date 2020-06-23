package com.pavelnazimok.selenide.utils;

import com.codeborne.selenide.logevents.LogEvent;
import io.qameta.allure.selenide.AllureSelenide;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

// Allure listener replacement to get rid of redundant steps in the report
// See: https://github.com/allure-framework/allure-java/issues/445
public class SkipSearchStepsAllureListener extends AllureSelenide {
    private final Set<String> methodsToSkipReporting = new HashSet<>(asList(
            "$",
            "$x",
            "$$",
            "$$x",
            "find",
            "element",
            "elements",
            "get element",
            "get elements",
            "parent",
            "sibling",
            "preceding",
            "last child",
            "closest",
            "find all"
    ));

    @Override
    public void beforeEvent(final LogEvent event) {
        if (shouldSkipEvent(event.getSubject())) {
            return;
        }
        super.beforeEvent(event);
    }

    @Override
    public void afterEvent(final LogEvent event) {
        if (shouldSkipEvent(event.getSubject())) {
            return;
        }
        super.afterEvent(event);
    }

    private boolean shouldSkipEvent(final String method) {
        return methodsToSkipReporting.stream().anyMatch(method::startsWith);
    }
}
