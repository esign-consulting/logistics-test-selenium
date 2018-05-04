# logistics-test-selenium

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Project for UI testing the [Logistics](https://github.com/esign-consulting/logistics) application. The test is based on [Selenium](https://www.seleniumhq.org) and is executed through [Maven](https://maven.apache.org) **(installation required)**.

Besides Maven, the test also requires the installation of the [Firefox](https://www.mozilla.org) web browser, and the use of [geckodriver](https://github.com/mozilla/geckodriver), for enabling Selenium to interact with Firefox. Dowload it from https://github.com/mozilla/geckodriver/releases and extract it into the project folder.

In order to run the test, execute the command `mvn test -Dpage.url=<logistics_url> -Dwebdriver.gecko.driver=geckodriver`, replacing *<logistics_url>* by the URL where the Logistics application is available. The command `mvn test -Dpage.url=http://www.esign.com.br/logistics -Dwebdriver.gecko.driver=geckodriver`, for example, executes the test against the instance of the application at http://www.esign.com.br/logistics.

The test opens the Firefox web browser and validates the Logistics application functionalities like it was a ordinary user, but in an automatic manner. If the *page.url* parameter was not defined, be sure the application is available on http://localhost:8080/logistics, the default URL.
