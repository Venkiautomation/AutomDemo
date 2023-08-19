package com.venki.auto.actions;

import com.venki.auto.utils.BrowserFactory;
import com.venki.auto.utils.Objects.Elements;
import com.venki.auto.utils.Setup;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

public class TestActions {
      BrowserFactory browserFactory=new BrowserFactory();
      public void enterUrl() throws Exception {
            try {
                  browserFactory.navigateToUrl("http://localhost:3000/");
            }
            catch (Exception e){
                  e.printStackTrace();
            }
      }

      public void checkIfElemetIsDisplayed(By by){
            boolean value = browserFactory.isElelmentDisplayed(by);
            if (value==true){
                  System.out.println("element is present");
            }
            else {
                  Assert.fail("failing because element is not preset");
            }
      }

      public int getCurrentMonth(){
            LocalDate currentdate= LocalDate.now();
            Month month = currentdate.getMonth();
            System.out.println("The current month is "+month);
            System.out.println("The current month is "+currentdate.getMonthValue());
            return currentdate.getMonthValue();
      }

      public void goToMonth(int number,By by){
            for (int i=0;i<number;i++){
                  browserFactory.clickElement(by);
            }
      }

      public String getMainMonthText(){
          return browserFactory.getText(By.cssSelector(Elements.mainMonth));
      }


      public String getMiniMonthText(){
            return browserFactory.getText(By.cssSelector(Elements.miniMonth));
      }

      public String getValueFromProp(String value) throws Exception {
            String valueFromPropertyFile = browserFactory.getValueFromPropertyFile(value);
            return valueFromPropertyFile;
      }

      public void refreshPage(){
            Setup.driver.navigate().refresh();
      }

      public void validateCalendarDaysOfmonth(){
            Assert.assertTrue("calendar grid is not displayed",browserFactory.isElelmentDisplayed(By.cssSelector(Elements.calendarGrid)));
            Assert.assertTrue("calendar days are not displayed",browserFactory.isElelmentDisplayed(By.cssSelector(Elements.listOfCalendarDates)));
            List<WebElement> list = browserFactory.getListOfWebElements(By.cssSelector(Elements.listOfCalendarDates));
            System.out.println("The size of days are "+list.size());
            Assert.assertEquals("The number of days does not match rows and columns",list.size(),35);
      }

      public void validateBlueCircle(){
            String text = browserFactory.getText(By.xpath(Elements.blueCircle));
            System.out.println("The date highlighted is "+text);
            Date dt = new Date();
            Assert.assertEquals(dt.getDate(),Integer.parseInt(text));
      }



}
