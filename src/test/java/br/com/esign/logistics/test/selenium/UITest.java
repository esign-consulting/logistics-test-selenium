/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.esign.logistics.test.selenium;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;

/**
 *
 * @author gustavomunizdocarmo
 */
public class UITest {
    
    private WebDriver driver;
    
    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @Test
    public void addMapTest() {
        HomePage home = new HomePage(driver);
        home.clickOnAddMapButton();
        
        AddMapModal modal = new AddMapModal(driver);
        assertTrue(modal.isPageOpened());
        
        modal.setMapName("Rio de Janeiro");
        modal.clickOnAddMapOkButton();
        
        assertTrue(home.equalsAlertMessage("The map 'Rio de Janeiro' was successfully created."));
    }
    
    @After
    public void close() {
        driver.close();
    }
    
}