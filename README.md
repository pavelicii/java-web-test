# Java Web Test Automation

### Description

I use this repository as a base for a web test automation project or just as a part of my programming portfolio.

It consists of 2 modules with the same tests but different test automation frameworks: **Selenium** and **Selenide**.

## Selenide module

Usually, you want a framework witch provides concise fluent API for tests and Selenide is one of the available choices.

### Tools

* [Selenide](https://github.com/selenide/selenide) — browser automation
* [JUnit5](https://github.com/junit-team/junit5) — Java testing framework
* [Allure](https://github.com/allure-framework/allure2) — test reporting tool
* [Selenoid](https://github.com/aerokube/selenoid)* — Docker browser farm

> **First you need to [install Selenoid](https://aerokube.com/selenoid/latest/#_quick_start_guide). 
> To use it, replace default Selenide WebDriver with [your own Remote WebDriver](selenide/src/test/java/com/pavelnazimok/selenide/utils/SelenoidRemoteWebDriver.java).*

### Test Design Pattern

**Page Object** with the addition of **Sections** (a.k.a. Fragments or Widgets).

* [`pages`](selenide/src/test/java/com/pavelnazimok/selenide/pages)
* [`sections`](selenide/src/test/java/com/pavelnazimok/selenide/sections)
* [`tests`](selenide/src/test/java/com/pavelnazimok/selenide/tests)

### Test reporting

To generate and show the Allure report:

1. `mvn clean test -pl selenide`
2. `mvn allure:serve`
3. `http://localhost:8080` will be automatically opened in the browser

### Lint checks

Some basic [Checkstyle](https://github.com/checkstyle/checkstyle) checks adapted for UI testing ([`checkstyle.xml`](checkstyle.xml)).

To run: `mvn checkstyle:checkstyle`

## Selenium module

Nowadays I don't expect to work directly with Selenium, but it's important to have experience with it since the majority of test frameworks are based on Selenium.

### Tools

* [Selenium](https://github.com/SeleniumHQ/selenium) — browser automation
* [JUnit5](https://github.com/junit-team/junit5) — Java testing framework
* [AssertJ](https://github.com/joel-costigliola/assertj-core) — a rich set of assertions
* [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) — automatic management of Selenium WebDriver binaries

### Test Design Pattern

**Fluent Page Object**, described in [Selenium Wiki]((https://github.com/SeleniumHQ/selenium/wiki/PageObjects)), with the addition of **Sections** (a.k.a. Fragments or Widgets).

* [`pages`](selenium/src/test/java/com/pavelnazimok/selenium/pages)
* [`sections`](selenium/src/test/java/com/pavelnazimok/selenium/sections)
* [`tests`](selenium/src/test/java/com/pavelnazimok/selenium/tests)

This version of Page Object requires every step to return some page, so we can chain all the steps. 

I don't prefer this version because in the test it makes it hard to track where we currently are on the website 
since all transitions between pages end up being hidden in the method chaining.

It also becomes hard to maintain when you want to implement reusable Sections instead of just vanilla Page Objects. 
In this project, I've used generics to map Section to an appropriate Page.