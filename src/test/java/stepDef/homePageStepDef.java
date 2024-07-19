package stepDef;

import Base.baseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.homePage;

public class homePageStepDef extends baseTest {

    homePage HomePage;

    @When("user click phones categories")
    public void userClickPhonesCategories() {
        HomePage = new homePage(driver);
        HomePage.clickPhoneCategories();
    }

    @Then("system will show all phones products")
    public void systemWillShowAllPhonesProducts() {
        HomePage.validatePhoneCategoriesIsDisplayed();
    }

    @When("user click laptops categories")
    public void userClickLaptopsCategories() {
        HomePage.clickLaptopCategories();
    }

    @Then("system will show all laptops products")
    public void systemWillShowAllLaptopsProducts() {
        HomePage.validateLaptopCategoriesIsDisplayed();
    }

    @When("user click monitor categories")
    public void userClickMonitorCategories() {
        HomePage.clickMonitorCategories();
    }

    @Then("system will show all monitor products")
    public void systemWillShowAllMonitorProducts() {
        HomePage.validateMonitorCategoriesIsDisplayed();
    }

    @When("user click next page button")
    public void userClickNextPageButton() {
        HomePage = new homePage(driver);
        HomePage.clickNextPageButton();
    }

    @Then("system will show next page products")
    public void systemWillShowNextPageProducts() {
        HomePage.validateNextPageFirstProduct();
    }

    @When("user click previous page button")
    public void userClickPreviousPageButton() {
        HomePage.clickPrevPageButton();
    }

    @Then("system will show previous page products")
    public void systemWillShowPreviousPageProducts() {
        HomePage.validatePrevPageFirstProduct();
    }
}
