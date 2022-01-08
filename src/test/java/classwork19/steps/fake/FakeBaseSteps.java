package classwork19.steps.fake;

import classwork19.driver.Config;
import classwork19.driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FakeBaseSteps {

    private static final Logger LOGGER = LogManager.getLogger(FakeBaseSteps.class);

    @Before
    public void beforeTest(){
        LOGGER.info("Initializing WebDriver ..");
        Driver.setConfig(Config.CHROME);
    }
    @After
    public void afterTest (){
        LOGGER.info("Killing WebDriver ..");
        Driver.destroy();
    }
}