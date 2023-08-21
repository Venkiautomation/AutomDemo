package com.venki.auto.steps;

import com.venki.auto.actions.TestActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class EventDeletionSteps {
    TestActions testActions=new TestActions();
    @And("I delete event card with event name {string}")
    public void iDeleteEventCardOf(String arg0) throws InterruptedException {
        testActions.deleteEvent(arg0);
    }

    @Given("I validate {string} is deleted and validate the event count should be {int}")
    public void validateEventDeletion(String name,int count){
        testActions.deleteEventValidation(name,count);
    }
}
