package com.venki.auto.hooks;

import com.venki.auto.utils.BrowserFactory;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.Logger;

 public class Setup {

    static final Logger logger=Logger.getLogger(Setup.class.getSimpleName());

    public static WebDriver driver;

     @BeforeAll
    public static void before_All()throws Exception{
        System.out.println("Browser type is"+System.getProperty("browser"));
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        logger.info("Initializing the browser");
        driver = new ChromeDriver();
    }
     @Before
     public void before(Scenario scenario){
         BrowserFactory.globalScenario=scenario;
     }

     /**
      * @param scenario
      * @throws Exception
      */
     @After()
    public void after(Scenario scenario) throws Exception{
        System.out.println("The status of test is "+ scenario.getStatus());
        if (scenario.getStatus().toString().equalsIgnoreCase("FAILED")){
            BrowserFactory.attachScreenShot();
        }
    }


    @AfterAll
    public static void after_All()throws Exception{
        System.out.println("Tear down the scenario");
        driver.quit();
    }
}
