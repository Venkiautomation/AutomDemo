package com.venki.auto.utils;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.Logger;

 public class Setup {

    static final Logger logger=Logger.getLogger(Setup.class.getSimpleName());

    public static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Browser type is"+System.getProperty("browser"));
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        logger.info("Initializing the browser");
        driver = new ChromeDriver();
    }


    @AfterAll
    public static void afterAll(){
        System.out.println("Tear down the scenario");
        driver.quit();
    }
}
