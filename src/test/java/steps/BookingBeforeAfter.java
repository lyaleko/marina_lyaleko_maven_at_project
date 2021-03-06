package steps;

import driver.BasicDriver;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.booking.BookingHomePage;
import pages.booking.BookingResultPage;
import pages.booking.BookingSignInPage;
import pages.trashmail.TrashMailGridPage;
import pages.trashmail.TrashMailHomePage;
import utils.Actions;
import utils.ExplicitWait;
import java.util.concurrent.TimeUnit;

public abstract class BookingBeforeAfter {

    protected WebDriver driver = BasicDriver.getWebDriver();
    protected BookingHomePage bookingHomePage = new BookingHomePage();
    protected BookingResultPage bookingResultPage = new BookingResultPage(BasicDriver.getWebDriver());
    protected ExplicitWait wait = new ExplicitWait();
    protected BookingSignInPage bookingSignInPage = new BookingSignInPage(BasicDriver.getWebDriver());
    protected Actions actions = new Actions(BasicDriver.getWebDriver());
    protected TrashMailHomePage trashMailHomePage = new TrashMailHomePage(BasicDriver.getWebDriver());
    protected TrashMailGridPage trashMailGridPage = new TrashMailGridPage(BasicDriver.getWebDriver());

    @Before
    public void before(){
        setTimeouts(30);
        driver.manage().window().maximize();
    }

    public void setTimeouts(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(time, TimeUnit.SECONDS);
    }
}