package com.venki.auto.steps;

import com.venki.auto.actions.TestActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EventCreationSteps {
    TestActions testActions=new TestActions();
    @Then("I login using {string} credentials")
    public void login(String type) throws Exception {
        testActions.login(type);
    }

    @When("I create event name with date and month")
    public void iCreateEventAsWithDateMentionedInMonth(DataTable dataTable) throws InterruptedException {
        testActions.createEvent(dataTable);
    }

    @Then("I validate that event has been created")
    public void validateEventCreation(){
        testActions.validateEventCreation();
    }

    @Then("I validate the event card is in {string} color")
    public void validateEventCardColor(String color){
        testActions.validateColorOfLabel(color);
    }
}
