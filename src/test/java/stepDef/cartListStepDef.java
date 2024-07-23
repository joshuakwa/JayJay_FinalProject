package stepDef;

import Base.baseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.cartList;

public class cartListStepDef extends baseTest {
    cartList CartList;
    @When("user click cart icon from header menu")
    public void userClickCartIconFromHeaderMenu() {
        CartList = new cartList(driver);
        CartList.clickCartHeadermenu();
    }

    @Then("system will show page of cart list")
    public void systemWillShowPageOfCartList() {
        CartList.validateTableIsDisplayed();
        CartList.validateProductInTableIsDisplayed();
        CartList.validatePageTitleIsDisplayed();
    }

    @And("user click delete button on the first item")
    public void userClickDeleteButtonOnTheFirstItem() {
        CartList.deleteFirstProductInCart();
    }
}
