package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static driver.BasicDriver.webDriver;

public class Waiter {

    public static void waitForElement(String element) {
        new WebDriverWait(webDriver, 1000).until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath(element))
        );
    }
}