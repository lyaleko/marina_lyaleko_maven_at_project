package steps;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BookingPage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BasicBookingSteps {

    protected WebDriver driver = new ChromeDriver();
    protected BookingPage page = new BookingPage();

    @Before
    public void before(){
        setTimeouts(30);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.booking.com/");
    }

    public void setTimeouts(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(time, TimeUnit.SECONDS);
    }

    public String getDateString(int days){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, days);
        Date date = cal.getTime();
        return formatter.format(date);
    }
}