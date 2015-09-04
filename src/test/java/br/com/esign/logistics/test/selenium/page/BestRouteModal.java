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
