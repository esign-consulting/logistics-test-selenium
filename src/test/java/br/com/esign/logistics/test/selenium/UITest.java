/* 
 * The MIT License
 *
 * Copyright 2015 Esign Consulting Ltda.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.com.esign.logistics.test.selenium;

import br.com.esign.logistics.test.selenium.page.AddRouteModal;
import br.com.esign.logistics.test.selenium.page.RemoveMapModal;
import br.com.esign.logistics.test.selenium.page.BestRouteModal;
import br.com.esign.logistics.test.selenium.page.AddMapModal;
import br.com.esign.logistics.test.selenium.page.HomePage;

import java.time.Duration;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author gustavomunizdocarmo
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UITest {

    private static WebDriver driver;
    private static HomePage home;

    private final String MAP = "Selenium UITest";
    private final String PLACEA = "A";
    private final String PLACEB = "B";
    private final String PLACED = "D";

    /**
     * Starts the driver and opens the homepage.
     */
    @BeforeClass
    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(Boolean.getBoolean("headless"));
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        home = new HomePage(driver);
    }

    /**
     * Adds a map.
     */
    @Test
    public void testA() {
        home.clickOnAddMapButton();
        AddMapModal modal = new AddMapModal(driver);
        assertTrue(modal.isPageOpened());

        modal.setMapName(MAP);
        modal.clickOnAddMapOkButton();
        assertTrue(home.isAlertAddMapSuccessMessage(MAP));
    }

    /**
     * Checks the unique map constraint.
     */
    @Test
    public void testB() {
        home.clickOnAddMapButton();
        AddMapModal modal = new AddMapModal(driver);
        assertTrue(modal.isPageOpened());

        modal.setMapName(MAP);
        modal.clickOnAddMapOkButton();
        assertTrue(home.isAlertMapAlreadyExistsErrorMessage());
    }

    /**
     * Adds routes to the map.
     */
    @Test
    public void testC() {
        home.selectMap(MAP);

        home.clickOnAddRouteButton();
        AddRouteModal modal = new AddRouteModal(driver);
        assertTrue(modal.isPageOpened(MAP));

        modal.setOriginName(PLACEA);
        modal.setDestinationName(PLACEB);
        modal.setDistance("10");
        modal.clickOnAddRouteOkButton();
        assertTrue(home.isAlertAddRouteSuccessMessage(PLACEA, PLACEB));

        home.clickOnAddRouteButton();
        modal = new AddRouteModal(driver);
        assertTrue(modal.isPageOpened(MAP));

        modal.setOriginName(PLACEB);
        modal.setDestinationName(PLACED);
        modal.setDistance("15");
        modal.clickOnAddRouteOkButton();
        assertTrue(home.isAlertAddRouteSuccessMessage(PLACEB, PLACED));
    }

    /**
     * Checks the unique route constaint.
     */
    @Test
    public void testD() {
        home.clickOnAddRouteButton();
        AddRouteModal modal = new AddRouteModal(driver);
        assertTrue(modal.isPageOpened(MAP));

        modal.setOriginName(PLACEA);
        modal.setDestinationName(PLACEB);
        modal.setDistance("10");
        modal.clickOnAddRouteOkButton();
        assertTrue(home.isAlertRouteAlreadyExistsErrorMessage());
    }

    /**
     * Checks the best route functionality.
     */
    @Test
    public void testE() {
        home.clickOnBestRouteButton();
        BestRouteModal modal = new BestRouteModal(driver);
        assertTrue(modal.isPageOpened(MAP));

        modal.setOriginName(PLACEA);
        modal.setDestinationName(PLACED);
        modal.setAutonomy("10");
        modal.setGasPrice("2.50");
        modal.clickOnBestRouteOkButton();
        assertTrue(home.isAlertBestRouteSuccessMessage("A -> B -> D", "6.25"));
    }

    /**
     * Removes the map.
     */
    @Test
    public void testF() {
        home.clickOnRemoveMapButton();
        RemoveMapModal modal = new RemoveMapModal(driver);
        assertTrue(modal.isPageOpened(MAP));

        modal.clickOnRemoveMapYesButton();
        assertTrue(home.isAlertRemoveMapSuccessMessage(MAP));
    }

    /**
     * Closes the driver.
     */
    @AfterClass
    public static void close() {
        driver.close();
    }

}