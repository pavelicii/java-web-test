package com.pavelnazimok.selenium.tests;

import com.pavelnazimok.selenium.pages.LoginPage;
import com.pavelnazimok.selenium.pages.MainPage;
import com.pavelnazimok.selenium.pages.QueriesPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueriesTest extends BaseTest {

    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        mainPage = new LoginPage(getDriver()).open().loginAsDrMitchell();
    }

    @Test
    public void shouldUpdateOpenQueryCount() {
        final QueriesPage queriesPage = mainPage
                .clickViewQueries();

        queriesPage
                .replyOnAllQueries("Some reply")
                .refresh();

        assertThat(queriesPage.getOpenQueryCount())
                .as("Check open query count is 0 after everything has been replied")
                .isEqualTo(0);
    }
}
