package Base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class baseTest {
    protected static WebDriver driver;

    protected void getDriver(){
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
    }

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";

        RequestSpecification requestSpec = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer fc4dbd86085d7695b329e7227885ac295f3295987db617a14aad7403be6b073b");

        RestAssured.requestSpecification = requestSpec;
    }
}
