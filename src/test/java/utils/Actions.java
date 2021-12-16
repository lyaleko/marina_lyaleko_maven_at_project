package utils;

import driver.BasicDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Actions {

    public void moveToElement(WebElement element) {
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(BasicDriver.getWebDriver());
        actions.moveToElement(element);
        actions.perform();
    }
    public Actions(WebDriver webDriver) {

    }
}
