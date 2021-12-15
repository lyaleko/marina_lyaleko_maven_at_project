package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.booking.BookingHomePage;
import pages.booking.BookingResultPage;
import steps.BookingBeforeAfter;

public class ToolTipTest extends BookingBeforeAfter {


    @Test
    public void toolTipTest() {

        WebElement element = driver.findElement(By.xpath(homePage.CURRENCY_BUTTON));

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

        Assert.assertEquals("Incorrect text Tooltip Currency ", "Выберите валюту", driver.findElement(By.xpath(homePage.TOOLTIP_TEXT)).getText());

        element = driver.findElement(By.xpath(homePage.LANGUAGE_BUTTON));

        actions.moveToElement(element);
        actions.perform();

        Assert.assertEquals("Incorrect text Tooltip Language ", "Выберите язык", driver.findElement(By.xpath(homePage.TOOLTIP_TEXT)).getText());
    }
}