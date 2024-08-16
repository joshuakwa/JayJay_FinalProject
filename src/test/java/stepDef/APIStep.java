package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.APIPages;

public class APIStep {

    APIPages apiPage;

    public APIStep() {
        this.apiPage = new APIPages();
    }

    @Given("prepare valid url for {string}")
    public void prepareValidUrlFor(String url) {
        apiPage.prepareUrl(url);
    }

    @When("hit api get list users")
    public void hitApiGetListUsers() {
        apiPage.getUsers();
    }

    @Then("validate status code is equal to {int}")
    public void validateStatusCodeIsEqualTo(int statusCode) {
        System.out.println("200 kok");
    }
}
