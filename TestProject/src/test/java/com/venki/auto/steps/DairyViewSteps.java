package com.venki.auto.steps;

import com.venki.auto.actions.TestActions;
import com.venki.auto.utils.Objects.Elements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Date;

public class DairyViewSteps {
    TestActions testActions=new TestActions();
    @Given("I launch the browser")
    public void checkRun() {
        System.out.println("Launching chrome");
        try{
            testActions.enterUrl();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    @Then("I enter the url to the browser")
    public void stopBrowser() throws Exception {
        testActions.enterUrl();
        Thread.sleep(3000);
    }

    @Then("I validate page is loaded")
    public void validatePage() throws Exception {
        testActions.checkIfElemetIsDisplayed(By.cssSelector(Elements.calendarName));
    }

    @Given("I navigate {int} months {string} of current month and validate days of all month can be seen")
    public void moveToMonth(int i,String direction){
        if (direction.equalsIgnoreCase("ahead")){
            testActions.goToMonth(i,By.xpath(Elements.mainMonthRighttButton));
        }
        else if (direction.equalsIgnoreCase("behind")){
            testActions.goToMonth(i,By.xpath(Elements.mainMonthLeftButton));
        }
        else {
            throw new RuntimeException("Plz check the parameter passed");
        }
        System.out.println("Month after navigating is "+testActions.getMainMonthText());


    }

    @And("I validate that month has moved {string} by {int}")
    public void validateMonthHasMoved(String direction,int value) throws Exception {
        if (direction.equalsIgnoreCase("ahead")){
            Date dt = new Date();
            DateTime dtOrg = new DateTime(dt);
            int dtPlusOne = dtOrg.plusMonths(value).getMonthOfYear();
            System.out.println("New Lib month is "+dtPlusOne);
            System.out.println("Trying to get value "+testActions.getMainMonthText().split(" ")[0]);
            String timeFromProps=testActions.getValueFromProp(testActions.getMainMonthText().split(" ")[0].toUpperCase());
            Assert.assertEquals(dtPlusOne,Integer.parseInt(timeFromProps));
        }
        else {
            Date dt = new Date();
            DateTime dtOrg = new DateTime(dt);
            int dtPlusOne = dtOrg.minusMonths(value).getMonthOfYear();
            System.out.println("New Lib month is "+dtPlusOne);
            System.out.println("Trying to get value "+testActions.getMainMonthText().split(" ")[0]);
            String timeFromProps=testActions.getValueFromProp(testActions.getMainMonthText().split(" ")[0].toUpperCase());
            Assert.assertEquals(dtPlusOne,Integer.parseInt(timeFromProps));
        }
    }

    @Given("I refresh the page")
    public void refreshPage(){
        testActions.refreshPage();
    }

    @Then("I validate main calendar and mini calendar values are same")
    public void validateMainAndMiniCalendar(){
        Assert.assertEquals(testActions.getMainMonthText(),testActions.getMiniMonthText());
    }

    @And("I validate days of month are displayed on calendar")
    public void validateCalendarContent(){
        testActions.validateCalendarDaysOfmonth();
    }

    @Given("I validate that today's date is highlighted with blue circle")
    public void validateBlueCircle(){
        testActions.validateBlueCircle();
    }

}
