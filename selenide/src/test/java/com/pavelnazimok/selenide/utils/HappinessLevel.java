package com.pavelnazimok.selenide.utils;

public enum HappinessLevel {

    TOTALLY_UNHAPPY("Totally Unhappy (0%)"),
    UNHAPPY("Unhappy (25%)"),
    HAPPY("Happy (50%)"),
    PRETTY_UNHAPPY("Pretty Happy (75%)"),
    TOTALLY_HAPPY("Totally Happy (100%)");

    public final String value;

    HappinessLevel(final String value) {
        this.value = value;
    }
}
