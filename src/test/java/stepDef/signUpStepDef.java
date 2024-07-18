package stepDef;

import Base.baseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.login;
import pages.signUp;

import java.util.Random;

public class signUpStepDef extends baseTest {

    signUp SignUp;

    @When("user click sign up button from header menu")
    public void userClickSignUpButtonFromHeaderMenu() {
        SignUp = new signUp(driver);
        SignUp.clickSignUpHeaderBtn();
    }

    @When("user click sign up button")
    public void userClickSignUpButton() {
        SignUp.clickSignUpBtn();
    }

    @Then("system will show alert says this user is already exist")
    public void systemWillShowAlertSaysThisUserIsAlreadyExist() {
        SignUp.validateAlreadySignedUp();
    }

    @And("user input sign up username text box with {string}")
    public void userInputSignUpUsernameTextBoxWith(String username) {
        SignUp.inputUsername(username);
    }

    @And("user input sign up password text box with {string}")
    public void userInputSignUpPasswordTextBoxWith(String password) {
        SignUp.inputPassword(password);
    }

    @And("user input sign up username")
    public void userInputSignUpUsername() {
        String randomUsername = "user" + new Random().nextInt(10000);
        SignUp.inputUsername(randomUsername);
    }

    @And("user input sign up password")
    public void userInputSignUpPassword() {
        String randomPssword = "pass" + new Random().nextInt(10000);
        SignUp.inputPassword(randomPssword);
    }

    @Then("system will show alert says sign up successful")
    public void systemWillShowAlertSaysSignUpSuccessful() {
        SignUp.validateSignUpSuccess();
    }
}
