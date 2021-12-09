package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import steps.BasicBookingSteps;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MaxPriceTest extends BasicBookingSteps {

    @Test
    public void highestPriceTest() {

        driver.findElement(By.xpath(page.searchPlaceXPath)).sendKeys("Париж");
        driver.findElement(By.xpath(page.calendarRange)).click();
        driver.findElement(By.xpath(String.format("//td[@data-date='%s']", this.getDateString(3)) )).click();
        driver.findElement(By.xpath(String.format("//td[@data-date='%s']", this.getDateString(10)) )).click();
        driver.findElement(By.xpath(page.selectGuests)).click();
        driver.findElement(By.xpath("//button[@aria-label='Взрослых: увеличить количество']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Взрослых: увеличить количество']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Номера: увеличить количество']")).click();
        driver.findElement(By.xpath(page.checkPricesXPath)).click();
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

        WebElement webElement2 = driver.findElement(
                By.xpath("//div[@id='search_results_table']//div[@data-testid='property-card'][1]//div[@data-testid='price-and-discounted-price']//span"));

        String actualMaxPriceText = Arrays.stream(webElement2.getText().split("BYN")).skip(1).findFirst().get().trim().replace(" ", "");

        int actualMaxPrice = Integer.parseInt(actualMaxPriceText.replaceAll("\\D+", ""));

        System.out.println("Expected price: " + expectedMaxPrice);
        System.out.println("Actual price: " + actualMaxPrice);

        Assert.assertTrue("Expected hotel price is lower than expected!", actualMaxPrice / 7 >= expectedMaxPrice);
    }
}