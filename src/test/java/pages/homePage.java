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

    By bannerHomePage = By.id("contcar");
    By passwordInput = By.id("loginpassword");
    By loginHeaderBtn = By.id("login2");
    By loginBtn = By.cssSelector("button[onclick='logIn()']");
    By nameOfUser = By.id("nameofuser");

    public homePage(WebDriver driver){
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
