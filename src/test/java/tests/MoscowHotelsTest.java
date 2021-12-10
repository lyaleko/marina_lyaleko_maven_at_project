package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BasicBookingSteps;

public class MoscowHotelsTest extends BasicBookingSteps {

    @Test
    public void isHotelsTest() {

        driver.findElement(By.xpath(page.searchPlaceInput)).sendKeys("Москва");
        driver.findElement(By.xpath(page.calendarRange)).click();
        driver.findElement(By.xpath(String.format("//td[@data-date='%s']", this.getDateString(0)) )).click();
        driver.findElement(By.xpath(String.format("//td[@data-date='%s']", this.getDateString(7)) )).click();
        driver.findElement(By.xpath(page.checkPricesButton)).click();

        WebElement webElement = new WebDriverWait(driver, 1000).until(
                ExpectedConditions.elementToBeClickable (By.xpath("//a[contains(text(), 'сначала самая низкая')]")));
                webElement.click();

        WebElement firstElement = driver.findElement(By.xpath("//div[@data-testid='property-card'][1]"));

        Assert.assertTrue(firstElement.isDisplayed());
    }
}