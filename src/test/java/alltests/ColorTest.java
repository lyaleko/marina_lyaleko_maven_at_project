package alltests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ColorTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void titleColorTest(){

        driver.manage().window().maximize();

        driver.navigate().to("https://www.booking.com/");
        driver.findElement(By.xpath("//*[@id='ss']")).sendKeys("Москва");
        driver.findElement(By.xpath("//button[@data-sb-id='main']")).click(); // click on search

        WebElement tenthElement = driver.findElement(By.xpath("//div[@data-testid='property-card'][10]"));
        WebElement elementTitle = driver.findElement(By.xpath("//div[@data-testid='property-card'][10]//div[@data-testid='title']"));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", tenthElement);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor = 'green'", tenthElement);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.color = 'red'", elementTitle);

        WebElement actualRedElement = driver.findElement(By.xpath("//div[@data-testid='property-card'][10]//div[@data-testid='title']"));
        String redActualRedElement = actualRedElement.getCssValue("color");

        Assert.assertEquals("Result isn't correct", "rgba(255, 0, 0, 1)", redActualRedElement);
    }
}