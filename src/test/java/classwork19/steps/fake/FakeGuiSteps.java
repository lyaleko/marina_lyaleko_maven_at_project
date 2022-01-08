package classwork19.steps.fake;

import classwork19.driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FakeGuiSteps {

    @Given(value = "I go to google.com")
    public void checkHeaderTest(){
        Driver.getWebdriver().get("https://google.com");
    }

    @When("I start waiting")
    public void checkFooterTest(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I just passed")
    public void verify(){
        Assert.assertTrue(true);
    }
}
