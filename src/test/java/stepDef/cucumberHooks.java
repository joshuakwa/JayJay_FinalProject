package stepDef;

import Base.baseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.*;

import java.util.Objects;


public class cucumberHooks extends baseTest {

    String tagsRunning = null;

    @Before("@web")
    public void beforeTest(Scenario scenario) {
        getDriver();
    }

    @After("@web")
    public void afterTest(Scenario scenario) throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
