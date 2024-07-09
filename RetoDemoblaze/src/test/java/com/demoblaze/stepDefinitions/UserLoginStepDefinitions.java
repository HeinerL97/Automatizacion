package com.demoblaze.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.HomeSteps;
import steps.LoginSteps;
import steps.ValidateEmailSteps;


public class UserLoginStepDefinitions {
    @Steps
    HomeSteps homeStep;
    @Steps
    LoginSteps loginStep;
    @Steps
    ValidateEmailSteps validateEmailSteps;

    @Given("the user navigates to the Demoblaze homepage")
    public void theUserNavigatesToTheDemoblazeHomepage() {
        homeStep.openbrowser();
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String button) {
        homeStep.clickLogin();
    }

    @When("the user enters the created credentials")
    public void theUserEntersTheCreatedCredentials() {
        loginStep.enterEmailAddress();
        loginStep.clickLogin();
    }

    @Then("the user should be logged in exclusively with the email address used to create the account")
    public void theUserShouldBeLoggedInExclusivelyWithTheEmailAddressUsedToCreateTheAccount() {
        validateEmailSteps.validateEmail();
    }
}
