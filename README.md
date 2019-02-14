# logistics-test-selenium

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT) [![Build status](https://travis-ci.org/esign-consulting/logistics-test-selenium.svg?branch=master)](https://travis-ci.org/esign-consulting/logistics-test-selenium)

Project for UI testing the [Logistics](https://github.com/esign-consulting/logistics) application. The test is based on [Selenium](https://www.seleniumhq.org) and is executed through [Maven](https://maven.apache.org) **(installation required)**.

## Geckodriver

Besides Maven, the test also requires the installation of the [Firefox](https://www.mozilla.org) web browser, and the use of [geckodriver](https://github.com/mozilla/geckodriver), for enabling Selenium to interact with Firefox. Download it from <https://github.com/mozilla/geckodriver/releases> and extract it into the project folder. If your operating system is a 64-bit Linux distribution, for example, execute the command:

`wget -c https://github.com/mozilla/geckodriver/releases/download/v0.24.0/geckodriver-v0.24.0-linux64.tar.gz -O - | tar -xz`.

## Running the test

In order to run the test, execute the command `mvn test -Dpage.url=<logistics_url> -Dwebdriver.gecko.driver=geckodriver`, replacing *<logistics_url>* with the URL where the Logistics application is available. The command `mvn test -Dpage.url=http://www.esign.com.br/logistics -Dwebdriver.gecko.driver=geckodriver`, for example, executes the test against the instance of the application at <http://www.esign.com.br/logistics>.

The test opens the Firefox web browser and validates the Logistics application functionalities like it was an ordinary user, but in an automatic manner. If the *page.url* parameter was not defined, be sure the application is available on <http://localhost:8080/logistics>, the default URL.

### Headless mode

You can also prevent the Firefox web browser from openning, by adding the option *-Dheadless=true*. In this scenario, everything happens in the background, you are not able to see the web application while the tests run.
