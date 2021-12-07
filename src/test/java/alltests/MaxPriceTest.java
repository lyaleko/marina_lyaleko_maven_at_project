package alltests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MaxPriceTest {

    WebDriver driver;

    @Before
    public void before(){
        driver = new ChromeDriver();
        setTimeouts(30);
    }

    @Test
    public void highestPriceTest() {

        driver.manage().window().maximize();
        driver.navigate().to("https://www.booking.com/");
        driver.findElement(By.xpath("//*[@id='ss']")).sendKeys("Париж");
        driver.findElement(By.xpath("//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']")).click();
        driver.findElement(By.xpath("//span[@aria-label='7 Декабрь 2021']")).click();
        driver.findElement(By.xpath("//span[@aria-label='14 Декабрь 2021']")).click();
        driver.findElement(By.xpath("//label[@id='xp__guests__toggle']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Взрослых: увеличить количество']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Взрослых: увеличить количество']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Номера: увеличить количество']")).click();
        driver.findElement(By.xpath("//button[@data-sb-id='main']")).click(); // click on search
        driver.findElement(By.xpath("//a[contains(text(), 'сначала самая низкая')]")).click();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // turn off implicitlyWait
        new FluentWait<>(driver)                                          // turn on FluentWait
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".bui-spinner.bui-spinner--size-large")));// expect spinner, then continue

        WebElement filterPrice = driver.findElement(By.xpath("//div[@id='searchboxInc']//div[@data-filters-group='pri']//div[contains(text(), '+')]")); // find filter price
        int expectedMaxPrice = Integer.parseInt(filterPrice.getText().replaceAll("\\D+", "")); //parse to int
        filterPrice.click(); // apply filterprice

        new FluentWait<>(driver)                                          // turn on FluentWait
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".bui-spinner.bui-spinner--size-large")));// expect spinner, then continue

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // turn on implicitlyWait

        WebElement webElement = driver.findElement(
                By.xpath("//div[@id='search_results_table']//div[@data-testid='property-card'][1]//div[@data-testid='price-and-discounted-price']//span[1]"));

        String actualMaxPriceText = Arrays.stream(webElement.getText().split("BYN")).skip(1).findFirst().get().trim().replace(" ", "");

        int actualMaxPrice = Integer.parseInt(actualMaxPriceText.replaceAll("\\D+", ""));

        System.out.println("Expected price: " + expectedMaxPrice);
        System.out.println("Actual price: " + actualMaxPrice / 7);

        Assert.assertTrue("Expected hotel price is lower than expected!", actualMaxPrice / 7 >= expectedMaxPrice);
    }

    private void setTimeouts(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(time, TimeUnit.SECONDS);
    }
}
