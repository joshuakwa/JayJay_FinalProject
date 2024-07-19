package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class homePage {
    WebDriver driver;
    WebDriverWait wait;

    By phonesCategories = By.xpath("//a[text()='Phones']");
    By laptopsCategories = By.xpath("//a[text()='Laptops']");
    By monitorsCategories = By.xpath("//a[text()='Monitors']");
    By phoneFirstProducts = By.xpath("//a[.='Samsung galaxy s6']");
    By laptopFirstProducts = By.xpath("//a[.='Sony vaio i5']");
    By monitorFirstProducts = By.xpath("//a[.='Apple monitor 24']");
    By nextButton = By.id("next2");
    By prevButton = By.id("prev2");
    By nextPageFirstProduct = By.xpath("//a[.='MacBook air']");
    By prevPageFirstProduct = By.xpath("//a[.='Nokia lumia 1520']");


    public homePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickNextPageButton(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneFirstProducts));
        driver.findElement(nextButton).click();
    }

    public void clickPrevPageButton(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextPageFirstProduct));
        driver.findElement(prevButton).click();
    }

    public void validateNextPageFirstProduct(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextPageFirstProduct));
        driver.findElement(nextPageFirstProduct).isDisplayed();
    }

    public void validatePrevPageFirstProduct(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(prevPageFirstProduct));
        driver.findElement(prevPageFirstProduct).isDisplayed();
    }

    public void clickPhoneCategories(){
        driver.findElement(phonesCategories).click();
    }

    public void clickLaptopCategories(){
        driver.findElement(laptopsCategories).click();
    }

    public void clickMonitorCategories(){
        driver.findElement(monitorsCategories).click();
    }

    public void clickFirstPhonesProduct(){
        driver.findElement(phoneFirstProducts).click();
    }

    public void validatePhoneCategoriesIsDisplayed(){
        driver.findElement(phoneFirstProducts).isDisplayed();
    }

    public void validateLaptopCategoriesIsDisplayed(){
        driver.findElement(laptopFirstProducts).isDisplayed();
    }

    public void validateMonitorCategoriesIsDisplayed(){
        driver.findElement(monitorFirstProducts).isDisplayed();
    }
}
