/* 
 * The MIT License
 *
 * Copyright 2015 Esign Consulting Ltda.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.com.esign.logistics.test.selenium.page;

import java.text.MessageFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author gustavomunizdocarmo
 */
public class HomePage {
    
    private final WebDriver driver;
    
    private static final String PAGE_URL = getPageUrl();
    
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
    
    private static String getPageUrl() {
        String pageUrl = System.getProperty("page.url");
        return (pageUrl == null || pageUrl.isEmpty())
                ? "http://localhost:8080/logistics"
                : pageUrl;
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }
    
    public void clickOnAddMapButton() {
        waitForElement(addMapButton);
        addMapButton.click();
    }
    
    public void clickOnRemoveMapButton() {
        waitForElement(removeMapButton);
        removeMapButton.click();
    }
    
    public void clickOnAddRouteButton() {
        waitForElement(addRouteButton);
        addRouteButton.click();
    }
    
    public void clickOnBestRouteButton() {
        waitForElement(bestRouteButton);
        bestRouteButton.click();
    }
    
    public void selectMap(String map) {
        WebElement mapAccordion = driver.findElement(By.xpath("//a[@class='accordion-toggle']/span[text()='" + map + "']"));
        waitForElement(mapAccordion);
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

    private void waitForElement(WebElement element) {
        WebDriverWait driverWait = new WebDriverWait(driver, 20);
        driverWait.until(ExpectedConditions.visibilityOf(element));
        driverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
}