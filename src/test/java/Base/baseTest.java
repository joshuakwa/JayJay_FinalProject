package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class baseTest {
    protected static WebDriver driver;

    protected void getDriver(){
        ChromeOptions options  = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
    }
}
