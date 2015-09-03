/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.esign.logistics.test.selenium;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

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
    
    @BeforeClass
    public static void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        home = new HomePage(driver);
    }
    
    @Test
    public void testA() {
        home.clickOnAddMapButton();
        AddMapModal modal = new AddMapModal(driver);
        assertTrue(modal.isPageOpened());
        
        modal.setMapName(MAP);
        modal.clickOnAddMapOkButton();
        assertTrue(home.isAlertAddMapSuccessMessage(MAP));
    }
    
    @Test
    public void testB() {
        home.clickOnAddMapButton();
        AddMapModal modal = new AddMapModal(driver);
        assertTrue(modal.isPageOpened());
        
        modal.setMapName(MAP);
        modal.clickOnAddMapOkButton();
        assertTrue(home.isAlertMapAlreadyExistsErrorMessage());
    }
    
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
    
    @Test
    public void testF() {
        home.clickOnRemoveMapButton();
        RemoveMapModal modal = new RemoveMapModal(driver);
        assertTrue(modal.isPageOpened(MAP));
        
        modal.clickOnRemoveMapYesButton();
        assertTrue(home.isAlertRemoveMapSuccessMessage(MAP));
    }
    
    @AfterClass
    public static void close() {
        driver.close();
    }
    
}