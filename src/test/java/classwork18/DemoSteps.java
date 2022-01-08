package classwork18;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.booking.BookingHomePage;

public class DemoSteps {

    protected WebDriver driver = new ChromeDriver();
    protected BookingHomePage page = new BookingHomePage(); //added (driver)

    @Given("I open test site")
    public void iOpenTestSite() {
        driver.navigate().to("https://www.booking.com/");
    }

    @When("I feel the form")
    public void iFeelTheForm() {
        driver.findElement(By.xpath(page.SEARCH_PLACE_INPUT)).sendKeys("Москва");
        driver.findElement(By.xpath(page.SEARCH_BUTTON)).click();
    }

    @Then("I see greeting message")
    public void iSeeGreetingMessage() {
        Assert.assertTrue(true);
    }
}