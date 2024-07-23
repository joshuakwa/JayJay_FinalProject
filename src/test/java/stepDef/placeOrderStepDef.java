package stepDef;

import Base.baseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.placeOrder;

public class placeOrderStepDef extends baseTest {
    placeOrder PlaceOrder;

    @And("user click place order button")
    public void userClickPlaceOrderButton() {
        PlaceOrder = new placeOrder(driver);
        PlaceOrder.clickPlaceOrderButton();
    }

    @And("user fill name field with {string}")
    public void userFillNameFieldWith(String name) {
        PlaceOrder.fillNameField(name);
    }

    @And("user fill country field with {string}")
    public void userFillCountryFieldWith(String country) {
        PlaceOrder.fillCountryField(country);
    }

    @And("user fill city field with {string}")
    public void userFillCityFieldWith(String city) {
        PlaceOrder.fillCityField(city);
    }

    @And("user fill credit card field with {string}")
    public void userFillCreditCardFieldWith(String credit) {
        PlaceOrder.fillCreditCardField(credit);
    }

    @And("user fill month field with {string}")
    public void userFillMonthFieldWith(String month) {
        PlaceOrder.fillMonthField(month);
    }

    @And("user fill year field with {string}")
    public void userFillYearFieldWith(String year) {
        PlaceOrder.fillYearField(year);
    }

    @Then("system will show pop up of success placing order with detail information")
    public void systemWillShowPopUpOfSuccessPlacingOrderWithDetailInformation() {
        PlaceOrder.validatePopUpSuccessIsDisplayed();
    }

    @And("user click purchase button")
    public void userClickPurchaseButton() {
        PlaceOrder.clickPurchaseButton();
    }
}

