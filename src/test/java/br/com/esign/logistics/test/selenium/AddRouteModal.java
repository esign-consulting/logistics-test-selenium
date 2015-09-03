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
public class AddRouteModal {

    private final WebDriver driver;

    @FindBy(tagName = "h3")
    private WebElement heading;

    @FindBy(id = "originName")
    private WebElement originName;
    
    @FindBy(id = "destinationName")
    private WebElement destinationName;
    
    @FindBy(id = "distance")
    private WebElement distance;

    @FindBy(name = "addRouteOkButton")
    private WebElement addRouteOkButton;

    @FindBy(name = "addRouteCancelButton")
    private WebElement addRouteCancelButton;

    public AddRouteModal(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened(String map) {
        return heading.getText().contains(map.concat(": New Route"));
    }
    
    public void setOriginName(String origin) {
        originName.clear();
        originName.sendKeys(origin);
    }
    
    public void setDestinationName(String destination) {
        destinationName.clear();
        destinationName.sendKeys(destination);
    }
    
    public void setDistance(String d) {
        distance.clear();
        distance.sendKeys(d);
    }
    
    public void clickOnAddRouteOkButton() {
        addRouteOkButton.click();
    }
    
    public void clickOnAddRouteCancelButton() {
        addRouteCancelButton.click();
    }

}
