package stepDef;

import Base.baseTest;
import groovy.util.logging.Log;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.homePage;
import pages.login;
import pages.productDetail;

public class productDetailStepDef extends baseTest {
    homePage HomePage;
    productDetail ProductDetail;
    login Login;

    @And("user is already logged in")
    public void userIsAlreadyLoggedIn() {
        Login = new login(driver);
        HomePage = new homePage(driver);
        ProductDetail = new productDetail(driver);
        Login.clickLoginHeaderBtn();
        Login.inputUsername("joshuakwa");
        Login.inputPassword("joshuakwa");
        Login.clickLoginBtn();
        Login.validateLoggedIn();
    }

    @When("user click first product in phones page")
    public void userClickFirstProductInPhonesPage() {
        HomePage = new homePage(driver);
        ProductDetail = new productDetail(driver);
        HomePage.clickFirstPhonesProduct();
    }

    @Then("system will show product detail page")
    public void systemWillShowProductDetailPage() {
        ProductDetail.productImageIsDisplayed();
        ProductDetail.productTitleIsDisplayed();
        ProductDetail.productPriceIsDisplayed();
        ProductDetail.addToCartButtonIsDisplayed();
    }

    @When("user click add to cart button")
    public void userClickAddToCartButton() {
        ProductDetail.clickAddToCartButton();
    }

    @Then("system will show alert says product added")
    public void systemWillShowAlertSaysProductAdded() {
        ProductDetail.validateAddToCartSuccess();
    }
}
