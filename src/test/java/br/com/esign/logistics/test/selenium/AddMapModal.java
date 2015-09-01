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
public class AddMapModal {

    private final WebDriver driver;

    @FindBy(tagName = "h3")
    private WebElement heading;

    @FindBy(id = "mapName")
    private WebElement mapName;

    @FindBy(name = "addMapOkButton")
    private WebElement addMapOkButton;

    @FindBy(name = "addMapCancelButton")
    private WebElement addMapCancelButton;

    public AddMapModal(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened() {
        return heading.getText().contains("New Map");
    }
    
    public void setMapName(String name) {
        mapName.clear();
        mapName.sendKeys(name);
    }
    
    public void clickOnAddMapOkButton() {
        addMapOkButton.click();
    }
    
    public void clickOnAddMapCancelButton() {
        addMapCancelButton.click();
    }

}
