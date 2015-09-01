/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.esign.logistics.test.selenium;

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

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }
    
    public void clickOnAddMapButton() {
        addMapButton.click();
    }
    
    public boolean equalsAlertMessage(String message) {
        return alert.getText().equals(message);
    }
    
}