package alltests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GoogleResultTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void searchResultTest(){
        driver.manage().window().maximize();
        driver.navigate().to("https://www.w3schools.com/java/");
        Actions make = new Actions(driver);

        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Tutorial')]"));

        make
                .doubleClick(element)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c")
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();

        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//input[@name = 'q']")).click();

        make
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        int countOfBlocks = driver.findElements(By.xpath("//div[@class = 'g']")).size();
        int countOfMatchesWords = driver.findElements(By.xpath("//div[@class = 'g' and contains(.,'tutorial')]")).size();
        Assert.assertEquals("Number of findings are incorrect",countOfBlocks,countOfMatchesWords);
    }
}