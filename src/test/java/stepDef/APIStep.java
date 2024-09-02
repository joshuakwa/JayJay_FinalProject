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


    @When("hit api get list users")
    public void hitApiGetListUsers() {
        apiPage.getUsers();
    }

    @Then("validate status code is equal to {int}")
    public void validateStatusCodeIsEqualTo(int statusCode) {
    }

    @Given("prepare valid url")
    public void prepareValidUrl() {
        apiPage.prepareUrl();
    }

    @When("hit api get detail user with id {int}")
    public void hitApiGetDetailUserWithId(int id) {
        apiPage.getUserDetail(id);
    }

    @When("hit api create new user")
    public void hitApiCreateNewUser() {
        apiPage.createNewUser();
    }

    @When("hit api create new user with blank name")
    public void hitApiCreateNewUserWithBlankName() {
    }
}
