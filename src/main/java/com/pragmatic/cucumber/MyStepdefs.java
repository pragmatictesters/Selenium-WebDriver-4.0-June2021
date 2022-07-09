package com.pragmatic.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("Use has logged into the system")
    public void useHasLoggedIntoTheSystem() {
        System.out.println("com.pragmatic.cucumber.MyStepdefs.useHasLoggedIntoTheSystem");
    }

    @When("User provide valid credentials")
    public void userProvideValidCredentials() {
    }

    @And("Click login button")
    public void clickLoginButton() {
    }

    @Then("User should see welcome message in landing page")
    public void userShouldSeeWelcomeMessageInLandingPage() {
    }
}
