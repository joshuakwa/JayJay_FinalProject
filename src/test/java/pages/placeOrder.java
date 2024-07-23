package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class placeOrder {
    WebDriver driver;
    WebDriverWait wait;

    By placeOrderButton = By.xpath("//button[.='Place Order']");
    By nameField = By.id("name");
    By countryField = By.id("country");
    By cityField = By.id("city");
    By creditCardField = By.id("card");
    By monthField = By.id("month");
    By yearField = By.id("year");
    By purchaseButton = By.xpath("//button[.='Purchase']");
    By popUpSuccessPurchase = By.xpath("//div[@class='sweet-alert  showSweetAlert visible']");

    public placeOrder(WebDriver driver){
        this.driver = driver;
    }

    public void clickPlaceOrderButton(){
        driver.findElement(placeOrderButton).click();
    }

    public void fillNameField(String name){
        driver.findElement(nameField).sendKeys(name);
    }

    public void fillCountryField(String country){
        driver.findElement(countryField).sendKeys(country);
    }

    public void fillCityField(String city){
        driver.findElement(cityField).sendKeys(city);
    }

    public void fillCreditCardField(String credit){
        driver.findElement(creditCardField).sendKeys(credit);
    }

    public void fillMonthField(String month){
        driver.findElement(monthField).sendKeys(month);
    }
    public void fillYearField(String year){
        driver.findElement(yearField).sendKeys(year);
    }

    public void clickPurchaseButton(){
        driver.findElement(purchaseButton).click();
    }

    public void validatePopUpSuccessIsDisplayed(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUpSuccessPurchase));
        driver.findElement(popUpSuccessPurchase).isDisplayed();
    }
}
