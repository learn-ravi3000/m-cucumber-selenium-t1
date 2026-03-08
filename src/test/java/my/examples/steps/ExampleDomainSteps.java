package my.examples.steps;

import my.examples.pages.ExampleDomainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ExampleDomainSteps {

    private final ExampleDomainPage exampleDomainPage = new ExampleDomainPage();

    @Given("I open the Home Depot home page")
    public void openHomeDepotHomePage() {
        exampleDomainPage.openHomeDepotHomePage();
    }

    @When("I search for {string} from the search bar")
    public void searchFromTheSearchBar(String searchTerm) {
        exampleDomainPage.searchFor(searchTerm);
    }

    @Then("I should be navigated to search results for {string}")
    public void verifySearchResults(String searchTerm) {
        Assert.assertTrue(
                exampleDomainPage.isSearchTermReflected(searchTerm),
                "Expected search results to reflect term: " + searchTerm
        );
    }
}
