package stepDef;

import Base.baseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.login;
import io.cucumber.java.en.Given;

import java.time.Duration;

public class loginStepDef extends baseTest{

    login LoginPage;

    @Given("user is on demoblaze.com page")
    public void userIsOnDemoBlaze(){
        LoginPage = new login(driver);
        LoginPage.goToLogin();
    }

    @When("user click sign in button from header menu")
    public void userClickSignUpButtonFromHeaderMenu() {
        LoginPage.clickLoginHeaderBtn();
    }

    @And("user input username text box with {string}")
    public void userInputUsernameTextBoxWith(String username) {
        LoginPage.inputUsername(username);
    }

    @And("user input password text box with {string}")
    public void userInputPasswordTextBoxWith(String password) {
        LoginPage.inputPassword(password);
    }

    @When("user click login button")
    public void userClickLoginButton() {
        LoginPage.clickLoginBtn();
    }

    @Then("user will redirect to homepage with logged in state")
    public void userWillRedirectToHomepageWithLoggedInState() {
        LoginPage.validateLoggedIn();
    }
}
