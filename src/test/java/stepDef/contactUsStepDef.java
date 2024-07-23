package stepDef;

import Base.baseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.contactUs;

public class contactUsStepDef extends baseTest {
    contactUs ContactUs;
    @When("user click contact on header menu")
    public void userClickContactOnHeaderMenu() {
        ContactUs = new contactUs(driver);
        ContactUs.clickContactHeadermenu();
    }

    @And("user fill contact email with {string}")
    public void userFillContactEmailWith(String email) {
        ContactUs.fillContactEmail(email);
    }

    @And("user fill contact name with {string}")
    public void userFillContactNameWith(String name) {
        ContactUs.fillContactName(name);
    }

    @And("user fill message text with {string}")
    public void userFillMessageTextWith(String message) {
        ContactUs.fillMessageText(message);
    }

    @Then("system will show alert says send message success")
    public void systemWillShowAlertSaysSendMessageSuccess() {
        ContactUs.validateSuccessContact();
    }

    @And("user click send message button")
    public void userClickSendMessageButton() {
        ContactUs.clickSendMessageButton();
    }
}
