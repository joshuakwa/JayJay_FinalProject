package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.Alert;


public class signUp {
    WebDriver driver;
    WebDriverWait wait;

    By usernameInput = By.id("sign-username");
    By passwordInput = By.id("sign-password");
    By signUpHeaderBtn = By.id("signin2");
    By signUpBtn = By.cssSelector("button[onclick='register()']");

    public signUp(WebDriver driver){
        this.driver = driver;
    }

    public void goToDemoBlaze(){
        driver.get("https://www.demoblaze.com/");
    }

    public void inputUsername(String username){
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSignUpBtn(){
        driver.findElement(signUpBtn).click();
    }

    public void clickSignUpHeaderBtn(){
        driver.findElement(signUpHeaderBtn).click();
    }

    public void validateAlreadySignedUp(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        assert(alertText.equals("This user already exist."));
        alert.dismiss();
    }

    public void validateSignUpSuccess(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        assert(alertText.equals("Sign up successfull."));
        alert.dismiss();
    }
}
