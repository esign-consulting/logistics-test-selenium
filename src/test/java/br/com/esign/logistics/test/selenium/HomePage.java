/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.esign.logistics.test.selenium;

import java.text.MessageFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author gustavomunizdocarmo
 */
public class HomePage {
    
    private final WebDriver driver;
    
    private static final  String PAGE_URL = "http://localhost:8080/logistics";
    
    @FindBy(xpath = "//div[@role='alert']/div/span")
    private WebElement alert;
    
    @FindBy(name = "addMapButton")
    private WebElement addMapButton;
    
    @FindBy(name = "removeMapButton")
    private WebElement removeMapButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }
    
    public void clickOnAddMapButton() {
        addMapButton.click();
    }
    
    public void selectMap(String mapName) {
        WebElement map = driver.findElement(By.xpath("//a[@class='accordion-toggle']/span[text()='" + mapName + "']"));
        map.click();
    }
    
    public void clickOnRemoveMapButton() {
        removeMapButton.click();
    }
    
    public boolean equalsAlertMessage(String message) {
        return alert.getText().equals(message);
    }
    
    public boolean isAlertAddMapSuccessMessage(String mapName) {
        String msg = MessageFormat.format("The map ''{0}'' was successfully created.", mapName);
        return equalsAlertMessage(msg);
    }
    
    public boolean isAlertMapAlreadyExistsErrorMessage() {
        return equalsAlertMessage("The map already exists.");
    }
    
    public boolean isAlertRemoveMapSuccessMessage(String mapName) {
        String msg = MessageFormat.format("The map ''{0}'' was successfully removed.", mapName);
        return equalsAlertMessage(msg);
    }
    
}