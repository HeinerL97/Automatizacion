package com.demozable.stepDefinitions;

import com.demoblaze.tasks.HomeTasks;
import com.demoblaze.tasks.RegisterTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class RegisterStepDefinitions {

    @Before
    public void setStage(){
        setTheStage(new OnlineCast());

    }

    @Given("that the user opens the demo page and opens the registration option")
    public void thatTheUserOpensTheDemoPageAndOpensTheRegistrationOption() {
        theActorCalled("usuario").wasAbleTo(
                Open.url("https://www.demoblaze.com/index.html")
        );
    }
    @When("the user enters the registration data appropriately")
    public void theUserEntersTheRegistrationDataAppropriately() {
        theActorCalled("Usuario").wasAbleTo(
                HomeTasks.on(),
                RegisterTask.on()
        );
    }
    @Then("you will be able to see a successful registration message")
    public void youWillBeAbleToSeeASuccessfulRegistrationMessage() {

    }

}
