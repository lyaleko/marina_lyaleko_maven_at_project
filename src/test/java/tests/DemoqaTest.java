package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.DemoqaPage;

import java.util.concurrent.TimeUnit;

public class DemoqaTest {

    WebDriver driver = new ChromeDriver();
    DemoqaPage page = new DemoqaPage();

    @Before
    public void before(){
        setTimeouts(30);
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/select-menu");
    }

    @Test
    public void selectValueTest(){

        driver.findElement(By.xpath(page.inputSelectValue)).click();
        driver.findElement(By.xpath("//div[contains(text(),'Group 1, option 2')]")).click();
        driver.findElement(By.xpath(page.inputSelectOne)).click();
        driver.findElement(By.xpath("//div[contains(text(),'Dr.')]")).click();

        WebElement element = driver.findElement(By.xpath(page.selectOldStyle));

        Select select = new Select(element);
        select.selectByVisibleText("Aqua");

        ((JavascriptExecutor)driver).executeScript(("window.scrollBy(0,1000)"));

        driver.findElement(By.xpath(page.inputMultiselect)).click();

        driver.findElement(By.xpath("//div[contains(text(),'Green')]")).click();

        element = driver.findElement(By.xpath(page.selectCars));
        select = new Select(element);
        select.selectByValue("saab");
    }

    public void setTimeouts(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(time, TimeUnit.SECONDS);
    }
}