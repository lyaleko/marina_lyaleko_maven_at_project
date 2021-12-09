package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import steps.BasicBookingSteps;

public class ToolTipTest extends BasicBookingSteps {

    @Test
    public void toolTipTest() {

        WebElement element = driver.findElement(By.xpath(page.selectCurrencyXPath));

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

        Assert.assertEquals("Incorrect text Tooltip Currency ","Выберите валюту" , driver.findElement(By.xpath(page.textTooltip)).getText());

        element = driver.findElement(By.xpath(page.selectLanguageXPath));

        actions.moveToElement(element);
        actions.perform();

        Assert.assertEquals("Incorrect text Tooltip Language ", "Выберите язык", driver.findElement(By.xpath(page.textTooltip)).getText());
    }
}