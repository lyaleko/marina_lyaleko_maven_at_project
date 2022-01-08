package tests.demoqa;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.demoqa.DemoqaPage;

import java.util.concurrent.TimeUnit;

public class DemoqaTest {

    WebDriver driver = new ChromeDriver();
    DemoqaPage demoPage = new DemoqaPage();

    @Before
    public void before(){
        setTimeouts(30);
        driver.manage().window().maximize();
        driver.navigate().to(demoPage.DEMOQA_SITE);
    }

    @Test
    public void selectValueTest(){

        driver.findElement(By.xpath(demoPage.SELECT_VALUE_INPUT)).click();
        driver.findElement(By.xpath("//div[contains(text(),'Group 1, option 2')]")).click();
        driver.findElement(By.xpath(demoPage.SELECT_ONE_INPUT)).click();
        driver.findElement(By.xpath("//div[contains(text(),'Dr.')]")).click();

        WebElement element = driver.findElement(By.xpath(demoPage.OLD_STYLE_SELECT));

        Select select = new Select(element);
        select.selectByVisibleText("Aqua");

        ((JavascriptExecutor)driver).executeScript(("window.scrollBy(0,1000)"));

        driver.findElement(By.xpath(demoPage.MULTISELECT_INPUT)).click();

        driver.findElement(By.xpath("//div[contains(text(),'Green')]")).click();

        element = driver.findElement(By.xpath(demoPage.CARS_SELECT));
        select = new Select(element);
        select.selectByValue("saab");
    }

    public void setTimeouts(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(time, TimeUnit.SECONDS);
    }
}