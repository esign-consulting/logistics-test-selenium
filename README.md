# logistics-test-selenium

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT) [![Build status](https://travis-ci.org/esign-consulting/logistics-test-selenium.svg?branch=master)](https://travis-ci.org/esign-consulting/logistics-test-selenium)

Project for UI testing the [Logistics](https://github.com/esign-consulting/logistics) application. The test is based on [Selenium](https://www.seleniumhq.org) and is executed through [Maven](https://maven.apache.org) **(installation required)**.

## Running the test

In order to run the test, execute the command `mvn test -Dpage.url=<logistics_url>`, replacing *<logistics_url>* with the URL where the Logistics application is available. The command `mvn test -Dpage.url=http://www.esign.com.br/logistics`, for example, executes the test against the instance of the application at <http://www.esign.com.br/logistics>.

The test opens the Chrome web browser and validates the Logistics application functionalities like it was an ordinary user, but in an automatic manner. If the *page.url* parameter was not defined, be sure the application is available on <http://localhost:8080/logistics>, the default URL.

### Headless mode

You can also prevent the Chrome web browser from openning, by adding the option *-Dheadless=true*. In this scenario, everything happens in the background, you are not able to see the web application while the tests run.

### Running with Docker

Alternativelly, you can run the test with Docker. To test against a local instance of the Logistics application available on port 8080, for example, execute `docker run --rm --name test --network host -e LOGISTICS_URL=http://localhost:8080/logistics esignbr/logistics-test-selenium`.
