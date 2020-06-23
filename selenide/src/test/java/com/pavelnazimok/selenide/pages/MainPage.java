package com.pavelnazimok.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import com.pavelnazimok.selenide.sections.HeaderSection;
import com.pavelnazimok.selenide.sections.PatientsMenuSection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.pavelnazimok.selenide.utils.SelenideExtensions.javaScriptClick;

@SuppressWarnings("UnusedReturnValue")
public class MainPage {

    private final HeaderSection header = new HeaderSection();
    private final PatientsMenuSection patientsMenu = new PatientsMenuSection();

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    private final SelenideElement
            addNewPatientButton = $("[alt='Add a New Patient']"),
            viewQueriesButton = $("[alt='View Queries']");

    public PatientsMenuSection patientsMenu() {
        return patientsMenu;
    }

    public HeaderSection header() {
        return header;
    }

    @Step("Open Queries page")
    public MainPage clickViewQueriesButton() {
        viewQueriesButton.execute(javaScriptClick());
        return this;
    }
}
