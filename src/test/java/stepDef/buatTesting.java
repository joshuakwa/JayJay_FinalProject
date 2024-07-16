package stepDef;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.login;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class buatTesting {
    WebDriver driver;
    login LoginPage;
    @Test
    public void test_login() throws InterruptedException {
        ChromeOptions options  = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

        By usernameInput = By.id("loginusername");
        By passwordInput = By.id("loginpassword");
        By loginHeaderBtn = By.id("login2");
        By loginBtn = By.cssSelector("button[onclick='logIn()']");
        By nameOfUser = By.id("nameofuser");

        driver.get("https://www.demoblaze.com/");
        driver.findElement(loginHeaderBtn).click();
        driver.findElement(usernameInput).sendKeys("joshuakwa");
        driver.findElement(passwordInput).sendKeys("joshuakwa");
        driver.findElement(loginBtn).click();
        Thread.sleep(3000);
        String name = driver.findElement(nameOfUser).getText();
        assertEquals(name, "Welcome joshuakwa");

        Thread.sleep(2000);
        driver.quit();
    }
}
