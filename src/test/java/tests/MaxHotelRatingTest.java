package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BasicBookingSteps;

public class MaxHotelRatingTest extends BasicBookingSteps {

    @Test
    public void findMaxRaiting(){

        driver.findElement(By.xpath(page.searchPlaceInput)).sendKeys("Москва");
        driver.findElement(By.xpath(page.calendarRange)).click();
        driver.findElement(By.xpath(String.format("//td[@data-date='%s']", this.getDateString(0)) )).click();
        driver.findElement(By.xpath(String.format("//td[@data-date='%s']", this.getDateString(7)) )).click();
        driver.findElement(By.xpath(page.checkPricesButton)).click();
        driver.findElement(By.xpath(page.menuExtraSorting)).click();
        driver.findElement(By.xpath(page.sortingByScorePrice)).click();

        WebElement webElement = new WebDriverWait(driver, 2000).until(
                ExpectedConditions.elementToBeClickable (By.xpath("//div[@data-testid='property-card'][1]//div[@aria-label='Оценка 10']")));

        String maxPriceTextRating = webElement.getText();
        int maxPriceNumberRating = Integer.parseInt(maxPriceTextRating.replaceAll("\\D+", ""));

        Assert.assertTrue("The highest hotel rating is incorrect ", maxPriceNumberRating >= 9);
    }
}