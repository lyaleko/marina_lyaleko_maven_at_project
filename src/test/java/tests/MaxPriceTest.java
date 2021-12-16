package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import steps.BookingBeforeAfter;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MaxPriceTest extends BookingBeforeAfter {

    @Test
    public void highestPriceTest() {

        homePage.goToBookingMain();
        homePage.inputCity("Париж");
        homePage.setDatesCalendar(3,10);
/*        driver.findElement(By.xpath(homePage.EXTRA_PARAM_INPUT)).click();
        driver.findElement(By.xpath("//button[@aria-label='Взрослых: увеличить количество']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Взрослых: увеличить количество']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Номера: увеличить количество']")).click();*/ // TODO

        homePage.setNumberOfAdults(4);
        homePage.setNumberOfRooms(2);
        homePage.submitSearch();
        driver.findElement(By.xpath(resultPage.MAX_PRICE_FILTER));
        int expectedMaxPrice = resultPage.getMaxFilterPrice();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // turn off implicitlyWait

        new FluentWait<>(driver)                                          // turn on FluentWait
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(resultPage.SPINNER)));// expect spinner, then continue

        driver.findElement(By.xpath(resultPage.MIN_PRICE_MENU)).click();

        new FluentWait<>(driver)                                          // turn on FluentWait
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(resultPage.SPINNER)));// expect spinner, then continue

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // turn on implicitlyWait

        WebElement webElement2 = driver.findElement(
                By.xpath(resultPage.FIRST_PRICE));

        String actualMaxPriceText = Arrays.stream(webElement2.getText().split("BYN")).skip(1).findFirst().get().trim().replace(" ", "");

        int actualMaxPrice = Integer.parseInt(actualMaxPriceText.replaceAll("\\D+", ""));

        System.out.println("Expected price: " + expectedMaxPrice);
        System.out.println("Actual price: " + actualMaxPrice);

        Assert.assertTrue("Expected hotel price is lower than expected!", actualMaxPrice / 7 >= expectedMaxPrice);
    }
}