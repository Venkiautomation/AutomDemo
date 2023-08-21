package com.venki.auto.actions;

import com.venki.auto.utils.BrowserFactory;
import com.venki.auto.utils.Objects.Elements;
import com.venki.auto.utils.Setup;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TestActions {
      BrowserFactory browserFactory=new BrowserFactory();

      List<Map<String, String>> list;

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
            if (value){
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
                  validateCalendarDaysOfmonth();
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
            String text = browserFactory.getText(By.cssSelector(Elements.blueCircle));
            System.out.println("The date highlighted is "+text);
            Date dt = new Date();
            Assert.assertEquals(dt.getDate(),Integer.parseInt(text));
      }

      public void login(String type) throws Exception {
            String username=getValueFromProp("userName1");
            String password=getValueFromProp("password1");
//            browserFactory.sendKeys(By.id(""),username);
//            browserFactory.sendKeys(By.id(""),password);
            System.out.println("Successfully logged in with username "+username +"and password "+password);
      }
      public void createEvent(DataTable dataTable) throws InterruptedException {
             this.list = dataTable.asMaps();
            System.out.println("Size of list is "+list.size());
            for (Map<String,String>value:list) {
                  traverseToMonth(value.get("Month"));
                  WebElement date = getDate(value.get("Date"));
                  date.click();
                  browserFactory.sendKeys(By.cssSelector(Elements.eventTextField),value.get("Event Name"));
                  browserFactory.sendKeys(By.cssSelector(Elements.eventdescription),value.get("Description"));
                  browserFactory.clickElement(By.xpath(Elements.getLabelElement(value.get("Label Color"))));
                  browserFactory.clickElement(By.cssSelector(Elements.eventSaveButton));

            }
            Thread.sleep(3000);
      }
      public WebElement getDate(String input){
            List<WebElement> dates = browserFactory.getListOfWebElements(By.xpath(Elements.listOfdates));
            List<WebElement> cursor = browserFactory.getListOfWebElements(By.xpath(Elements.cursor));
            WebElement element=null;
             for(int i=0;i<dates.size();i++) {
                  if (dates.get(i).getText().equalsIgnoreCase(input)) {
                        element = cursor.get(i);
                  }
             }
            return element;
      }
      public void traverseToMonth(String month){
            if (month.equalsIgnoreCase("current")){
                  System.out.println("You are already in current month");
            } else if (month.equalsIgnoreCase("next")) {
                  System.out.println("navigating to next month");
                  browserFactory.clickElement(By.xpath(Elements.mainMonthRighttButton));
            } else if (month.equalsIgnoreCase("previous")) {
                  System.out.println("navigating to previous month");
                  browserFactory.clickElement(By.xpath(Elements.mainMonthLeftButton));
            }
      }

      public void  validateEventCreation(){
            int count=0;
            for (Map<String,String>value:this.list){
                  System.out.println("The eventCard name is "+browserFactory.getListOfWebElements(By.xpath(Elements.eventCard)).get(count).getText());
                  Assert.assertEquals(value.get("Event Name"),(browserFactory.getListOfWebElements(By.xpath(Elements.eventCard)).get(count).getText()));
                  count++;
            }
      }
      public void validateColorOfLabel(String color){
            if (color.equalsIgnoreCase("red")){
                  for (WebElement element:browserFactory.getListOfWebElements(By.xpath(Elements.eventCard))){
                        String c=Color.fromString(element.getCssValue("background-color")).asRgba();
                        System.out.println("The rgb value is "+ c);
                        Assert.assertEquals("rgba(254, 202, 202, 1)",c);
                  }

            }
            else {
                  throw new RuntimeException("Plz Implement other validations");
            }

      }

      public void deleteEvent(String name) throws InterruptedException {
            for (WebElement element:browserFactory.getListOfWebElements(By.xpath(Elements.eventCard))){
                  String text=element.getText();
                  if (text.equalsIgnoreCase(name)){
                        element.click();
                        browserFactory.clickElement(By.cssSelector(Elements.deleteButton));
                        Thread.sleep(3000);
                  }
            }
      }

      public void  deleteEventValidation(String name,int count){
            for (WebElement element:browserFactory.getListOfWebElements(By.xpath(Elements.eventCard))){
                  if (name.equalsIgnoreCase(element.getText())){
                        Assert.fail();
                  }
            }
            int listOfCards = browserFactory.getListOfWebElements(By.xpath(Elements.eventCard)).size();
            System.out.println("Event count is "+listOfCards);
            Assert.assertTrue(count==listOfCards);
      }


}

