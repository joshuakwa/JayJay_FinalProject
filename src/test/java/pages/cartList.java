package pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class cartList {
    WebDriver driver;
    WebDriverWait wait;

    By tableProducts = By.xpath("//table");
    By pageTitle = By.xpath("//h2[.='Products']");
    By cartHeaderMenu = By.xpath("//a[.='Cart']");
    By productInTable = By.xpath("//tr[@class='success']");
    By deleteFirstProductButton = By.xpath("//a[.='Delete'][position()=1]");

    public cartList(WebDriver driver){
        this.driver = driver;
    }

    public void clickCartHeadermenu(){
        driver.findElement(cartHeaderMenu).click();
    }

    public void validateTableIsDisplayed(){
        driver.findElement(tableProducts).isDisplayed();
    }

    public void validatePageTitleIsDisplayed(){
        driver.findElement(pageTitle).isDisplayed();
    }

    public void validateProductInTableIsDisplayed(){
        driver.findElement(productInTable).isDisplayed();
    }

    public void deleteFirstProductInCart(){
        driver.findElement(deleteFirstProductButton).click();
    }
}
