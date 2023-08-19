package com.venki.auto.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    private final String path="TestData.properties";
    public void clickOnElement(By by){
        Setup.driver.findElement(by).click();
    }

    public void closeBrowser(){
        Setup.driver.close();
    }

    public void navigateToUrl(String url){
        Setup.driver.get(url);
        Setup.driver.manage().window().maximize();
    }

    public String getValueFromPropertyFile(String value) throws Exception {
        Properties props=new Properties();
        FileReader reader=new FileReader(path);
        props.load(reader);
        System.out.println("The value returned by property file is "+props.getProperty(value));
        String keyValue = props.getProperty(value).toString();
        return keyValue;
    }
    public void implicitlyWait(int time){
        Setup.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
    public void explicitlyWait(By by,int time){
        WebDriverWait wait = new WebDriverWait(Setup.driver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        System.out.println("Element is displayed");
    }
    public boolean  isElelmentDisplayed(By by){
       boolean value =Setup.driver.findElement(by).isDisplayed();
       return value;
    }
    public WebElement findElementByClass(String locator){
        return Setup.driver.findElement(By.cssSelector(locator));
    }
    public void clickElement(By by){
        Setup.driver.findElement(by).click();
    }
    public String getText(By by){
        String text = Setup.driver.findElement(by).getText();
        return text;
    }

    public List<WebElement> getListOfWebElements(By by){
        List<WebElement> list = Setup.driver.findElements(by);
        return list;
    }
}
