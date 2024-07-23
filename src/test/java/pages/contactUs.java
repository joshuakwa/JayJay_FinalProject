package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class contactUs {
    WebDriver driver;
    WebDriverWait wait;

    By contactHeaderMenu = By.xpath("//a[.='Contact']");
    By contactEmail = By.id("recipient-email");
    By contactName = By.id("recipient-name");
    By messageText = By.id("message-text");
    By sendMessageButton = By.xpath("//button[.='Send message']");

    public contactUs(WebDriver driver){
        this.driver = driver;
    }

    public void clickContactHeadermenu(){
        driver.findElement(contactHeaderMenu).click();
    }

    public void fillContactEmail(String email){
        driver.findElement(contactEmail).sendKeys(email);
    }

    public void fillContactName(String name){
        driver.findElement(contactName).sendKeys(name);
    }

    public void fillMessageText(String message){
        driver.findElement(messageText).sendKeys(message);
    }

    public void clickSendMessageButton(){
        driver.findElement(sendMessageButton).click();
    }

    public void validateSuccessContact(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        assert(alertText.equals("Thanks for the message!!"));
        alert.dismiss();
    }
}
