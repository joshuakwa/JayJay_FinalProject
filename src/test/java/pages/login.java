package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class login {
    WebDriver driver;
    WebDriverWait wait;

    By usernameInput = By.id("loginusername");
    By passwordInput = By.id("loginpassword");
    By loginHeaderBtn = By.id("login2");
    By loginBtn = By.cssSelector("button[onclick='logIn()']");
    By nameOfUser = By.id("nameofuser");

    public login(WebDriver driver){
        this.driver = driver;
    }

    public void goToLogin(){
        driver.get("https://www.demoblaze.com/");
    }

    public void inputUsername(String username){
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginBtn(){
        driver.findElement(loginBtn).click();
    }

    public void clickLoginHeaderBtn(){
        driver.findElement(loginHeaderBtn).click();
    }

    public void validateLoggedIn(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loggedInUser = wait.until(ExpectedConditions.visibilityOfElementLocated(nameOfUser));
        assert(loggedInUser.getText().contains("Welcome"));
    }
}
