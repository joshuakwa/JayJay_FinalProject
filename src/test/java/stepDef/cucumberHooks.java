package stepDef;

import Base.baseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class cucumberHooks extends baseTest {

    @Before
    public void beforeTest(){
        getDriver();
    }

    @After
    public void afterTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}