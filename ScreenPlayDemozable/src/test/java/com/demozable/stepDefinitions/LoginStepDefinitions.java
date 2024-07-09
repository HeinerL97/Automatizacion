package com.demozable.stepDefinitions;

import com.demoblaze.tasks.LoginTasks;
import com.demoblaze.ui.LoginUI;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginStepDefinitions {

    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
    }

    @Given("the user opens the demo page and opens the login option")
    public void theUserOpensTheDemoPageAndOpensTheLoginOption() {
        theActorCalled("usuario").wasAbleTo(
                Open.url("https://www.demoblaze.com/index.html")
                // Add an action to open the login modal if necessary
        );
    }

    @When("the user enters the login data appropriately")
    public void theUserEntersTheLoginDataAppropriately() {
        theActorCalled("Usuario").wasAbleTo(
                LoginTasks.withCredentials("yourUsername", "yourPassword")
        );
    }

    @Then("you will be able to see the user's name")
    public void youWillBeAbleToSeeTheUsersName() {

    }
}
