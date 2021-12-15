package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.google.GooglePage;

import java.util.concurrent.TimeUnit;

public class GoogleResultTest{

    WebDriver driver = new ChromeDriver();
    GooglePage page = new GooglePage();
    Actions make = new Actions(driver);

    @Before
    public void before(){
        setTimeouts(30);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.w3schools.com/java/");
    }

    @Test
    public void searchResultTest(){

        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Tutorial')]"));

        make
                .doubleClick(element)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c")
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();

        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath(page.GOOGLE_SEARCH)).click();

        make
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        int countOfBlocks = driver.findElements(By.xpath(page.RESULT_BOX)).size();
        int countOfMatchesWords = driver.findElements(By.xpath("//div[@class = 'g' and contains(.,'tutorial')]")).size();
        Assert.assertEquals("Number of findings are incorrect",countOfBlocks,countOfMatchesWords);
    }

    public void setTimeouts(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(time, TimeUnit.SECONDS);
    }
}