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
    
    @FindBy(name = "addRouteButton")
    private WebElement addRouteButton;
    
    @FindBy(name = "bestRouteButton")
    private WebElement bestRouteButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }
    
    public void clickOnAddMapButton() {
        addMapButton.click();
    }
    
    public void clickOnRemoveMapButton() {
        removeMapButton.click();
    }
    
    public void clickOnAddRouteButton() {
        addRouteButton.click();
    }
    
    public void clickOnBestRouteButton() {
        bestRouteButton.click();
    }
    
    public void selectMap(String map) {
        WebElement mapAccordion = driver.findElement(By.xpath("//a[@class='accordion-toggle']/span[text()='" + map + "']"));
        mapAccordion.click();
    }
    
    public boolean equalsAlertMessage(String message) {
        return alert.getText().equals(message);
    }
    
    public boolean isAlertAddMapSuccessMessage(String map) {
        String msg = MessageFormat.format("The map ''{0}'' was successfully created.", map);
        return equalsAlertMessage(msg);
    }
    
    public boolean isAlertMapAlreadyExistsErrorMessage() {
        return equalsAlertMessage("The map already exists.");
    }
    
    public boolean isAlertRemoveMapSuccessMessage(String map) {
        String msg = MessageFormat.format("The map ''{0}'' was successfully removed.", map);
        return equalsAlertMessage(msg);
    }
    
    public boolean isAlertAddRouteSuccessMessage(String origin, String destination) {
        String msg = MessageFormat.format("The routes ''{0}' -> '{1}'' and ''{1}' -> '{0}'' were successfully created.", new Object[] {origin, destination});
        return equalsAlertMessage(msg);
    }
    
    public boolean isAlertRouteAlreadyExistsErrorMessage() {
        return equalsAlertMessage("The route already exists.");
    }
    
    public boolean isAlertBestRouteSuccessMessage(String route, String cost) {
        String msg = MessageFormat.format("The route ''{0}'' is the best, once the cost for delivering is {1}.", new Object[] {route, cost});
        return equalsAlertMessage(msg);
    }
    
}