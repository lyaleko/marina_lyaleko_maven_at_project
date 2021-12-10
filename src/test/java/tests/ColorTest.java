package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import steps.BasicBookingSteps;

public class ColorTest extends BasicBookingSteps {

    @Test
    public void titleColorTest(){

        driver.findElement(By.xpath(page.searchPlaceInput)).sendKeys("Москва");
        driver.findElement(By.xpath(page.checkPricesButton)).click();

        WebElement tenthElement = driver.findElement(By.xpath(page.boxTenthsResult));
        WebElement elementTitle = driver.findElement(By.xpath(page.titleTenthsResult));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", tenthElement);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor = 'green'", tenthElement);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.color = 'red'", elementTitle);

        WebElement actualRedElement = driver.findElement(By.xpath(page.titleTenthsResult));
        String redActualRedElement = actualRedElement.getCssValue("color");

        Assert.assertEquals("Result isn't correct", "rgba(255, 0, 0, 1)", redActualRedElement);
    }
}