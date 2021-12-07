package alltests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTipTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void toolTipTest() {

        driver.manage().window().maximize();
        driver.navigate().to("https://www.booking.com/");
        WebElement element = driver.findElement(By.xpath("//button[@data-modal-aria-label  = 'Выберите валюту']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

        Assert.assertEquals("Incorrect text Tooltip Currency ","Выберите валюту" , driver.findElement(By.xpath("//div[@class= 'bui-tooltip__content']")).getText());

        element = driver.findElement(By.xpath("//button[@data-modal-aria-label  = 'Выберите язык']"));

        actions.moveToElement(element);
        actions.perform();

        Assert.assertEquals("Incorrect text Tooltip Language ", "Выберите язык", driver.findElement(By.xpath("//div[@class= 'bui-tooltip__content']")).getText());
    }
}