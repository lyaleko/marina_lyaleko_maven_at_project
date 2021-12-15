package utils;

import driver.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

    public void waitForElement(String element){
        new WebDriverWait(BasicDriver.getWebDriver(), 1000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
    }
}
