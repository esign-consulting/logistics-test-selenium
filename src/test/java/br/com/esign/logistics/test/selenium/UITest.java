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
    
    private final String MAP_NAME = "Selenium UITest";
    
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
        
        modal.setMapName(MAP_NAME);
        modal.clickOnAddMapOkButton();
        assertTrue(home.isAlertAddMapSuccessMessage(MAP_NAME));
    }
    
    @Test
    public void testB() {
        home.clickOnAddMapButton();
        AddMapModal modal = new AddMapModal(driver);
        assertTrue(modal.isPageOpened());
        
        modal.setMapName(MAP_NAME);
        modal.clickOnAddMapOkButton();
        assertTrue(home.isAlertMapAlreadyExistsErrorMessage());
    }
    
    @Test
    public void testC() {
        home.selectMap(MAP_NAME);
        home.clickOnRemoveMapButton();
        RemoveMapModal modal = new RemoveMapModal(driver);
        assertTrue(modal.isPageOpened(MAP_NAME));
        
        modal.clickOnRemoveMapYesButton();
        assertTrue(home.isAlertRemoveMapSuccessMessage(MAP_NAME));
    }
    
    @AfterClass
    public static void close() {
        driver.close();
    }
    
}