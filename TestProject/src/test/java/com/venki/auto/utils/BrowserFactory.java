package com.venki.auto.utils;

import com.venki.auto.hooks.Setup;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    private final String path="TestData.properties";
    public void clickOnElement(By by){
        Setup.driver.findElement(by).click();
    }
     public static Scenario globalScenario;
    public void closeBrowser(){
        Setup.driver.close();
    }

    public void navigateToUrl(String url){
        Setup.driver.get(url);
        Setup.driver.manage().window().maximize();
    }

    public String getValueFromPropertyFile(String value) {
        Properties props=new Properties();
        try{
            FileReader reader=new FileReader(path);
            props.load(reader);
        }
      catch (Exception e){
            e.printStackTrace();
      }
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
    public void sendKeys(By by,String value){
        Setup.driver.findElement(by).sendKeys(value);
    }
    public String getCssValue(By by,String cssValue){
        String text = Setup.driver.findElement(by).getCssValue(cssValue);
        return text;
    }

    public Sheet getDataFromExcel(String fileName,String name) throws IOException {
        File file =    new File("path to file");
        FileInputStream inputStream = new FileInputStream(file);
        Workbook excelBook = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        if(fileExtensionName.equals(".xlsx")){
            excelBook = new XSSFWorkbook(inputStream);
        }

        else if(fileExtensionName.equals(".xls")){
            excelBook = new HSSFWorkbook(inputStream);
        }
        assert excelBook != null;
        return excelBook.getSheet(name);


    }

    public static void attachScreenShot() throws IOException {
        System.out.println("Taking screen shot");
        byte[] ss = ((TakesScreenshot) Setup.driver).getScreenshotAs(OutputType.BYTES);
        File s1 = ((TakesScreenshot) Setup.driver).getScreenshotAs(OutputType.FILE);
        File DestFile=new File("./screenshot/screen.png");
        FileUtils.copyFile(s1, DestFile);

        globalScenario.attach(ss,"image/png","devansh");

    }
}
