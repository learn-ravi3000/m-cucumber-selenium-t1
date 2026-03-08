package com.example.steps;

import com.example.pages.ExampleDomainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ExampleDomainSteps {

    private final ExampleDomainPage exampleDomainPage = new ExampleDomainPage();

    @Given("I open the example domain home page")
    public void openExampleDomainHomePage() {
        exampleDomainPage.open();
    }

    @Then("I should see the page heading as {string}")
    public void verifyPageHeading(String expectedHeading) {
        Assert.assertEquals(exampleDomainPage.getHeadingText(), expectedHeading,
                "Heading text did not match expected value.");
    }
}
