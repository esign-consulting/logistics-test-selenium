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
public class BestRouteModal {

    private final WebDriver driver;

    @FindBy(tagName = "h3")
    private WebElement heading;

    @FindBy(id = "originName")
    private WebElement originName;
    
    @FindBy(id = "destinationName")
    private WebElement destinationName;
    
    @FindBy(id = "autonomy")
    private WebElement autonomy;
    
    @FindBy(id = "gasPrice")
    private WebElement gasPrice;

    @FindBy(name = "bestRouteOkButton")
    private WebElement bestRouteOkButton;

    @FindBy(name = "bestRouteCancelButton")
    private WebElement bestRouteCancelButton;

    public BestRouteModal(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened(String map) {
        return heading.getText().contains(map.concat(": Best Route"));
    }
    
    public void setOriginName(String origin) {
        originName.clear();
        originName.sendKeys(origin);
    }
    
    public void setDestinationName(String destination) {
        destinationName.clear();
        destinationName.sendKeys(destination);
    }
    
    public void setAutonomy(String a) {
        autonomy.clear();
        autonomy.sendKeys(a);
    }
    
    public void setGasPrice(String p) {
        gasPrice.clear();
        gasPrice.sendKeys(p);
    }
    
    public void clickOnBestRouteOkButton() {
        bestRouteOkButton.click();
    }
    
    public void clickOnBestRouteCancelButton() {
        bestRouteCancelButton.click();
    }

}
