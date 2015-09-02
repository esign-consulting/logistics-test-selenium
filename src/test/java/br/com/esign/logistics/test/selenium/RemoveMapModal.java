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
public class RemoveMapModal {

    private final WebDriver driver;

    @FindBy(tagName = "h3")
    private WebElement heading;

    @FindBy(name = "removeMapYesButton")
    private WebElement removeMapYesButton;

    @FindBy(name = "removeMapNoButton")
    private WebElement removeMapNoButton;

    public RemoveMapModal(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened(String mapName) {
        return heading.getText().contains(mapName + ": Remove Map");
    }
    
    public void clickOnRemoveMapYesButton() {
        removeMapYesButton.click();
    }
    
    public void clickOnRemoveMapNoButton() {
        removeMapNoButton.click();
    }

}
