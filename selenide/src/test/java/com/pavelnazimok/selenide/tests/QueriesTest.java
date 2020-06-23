package com.pavelnazimok.selenide.tests;

import com.codeborne.selenide.Selenide;
import com.pavelnazimok.selenide.pages.LoginPage;
import com.pavelnazimok.selenide.pages.MainPage;
import com.pavelnazimok.selenide.pages.QueriesPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Feature("Queries page")
public class QueriesTest extends BaseTest {

    @BeforeEach
    public void login() {
        new LoginPage()
                .open()
                .loginAsDrMitchell();
    }

    @Test
    @Description("Open query count update")
    public void shouldUpdateOpenQueryCount() {
        new MainPage()
                .clickViewQueriesButton();

        final QueriesPage queriesPage = new QueriesPage();

        queriesPage
                .replyOnAllQueries("Some reply");

        Selenide.refresh();

        assertThat(queriesPage.getOpenQueryCount())
                .as("Count of open queries")
                .isEqualTo(0);
    }
}
