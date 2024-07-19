package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class productDetail {
    WebDriver driver;
    WebDriverWait wait;

    By productTitle = By.xpath("//h2");
    By productPrice = By.xpath("//h3");
    By productImage = By.xpath("//img[@width='400']");
    By addToCartButton = By.xpath("//a[.='Add to cart']");


    public productDetail(WebDriver driver){
        this.driver = driver;
    }

    public void productTitleIsDisplayed(){
        driver.findElement(productTitle).isDisplayed();
    }

    public void productPriceIsDisplayed(){
        driver.findElement(productPrice).isDisplayed();
    }

    public void productImageIsDisplayed(){
        driver.findElement(productImage).isDisplayed();
    }

    public void addToCartButtonIsDisplayed(){
        driver.findElement(addToCartButton).isDisplayed();
    }

    public void clickAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }

    public void validateAddToCartSuccess(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        assert(alertText.equals("Product added"));
        alert.dismiss();
    }
}
