package alltests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoqaTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void selectValueTest(){

        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/select-menu");
        driver.findElement(By.xpath("//div[@id = 'withOptGroup']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Group 1, option 2')]")).click();
        driver.findElement(By.xpath("//div[@id = 'selectOne']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Dr.')]")).click();

        WebElement element = driver.findElement(By.xpath("//select[@id = 'oldSelectMenu']"));

        Select select = new Select(element);
        select.selectByVisibleText("Aqua");

/*        driver.findElement(By.cssSelector(".css-1wy0on6")).click();

        driver.findElement(By.xpath("//div[contains(text(),'Green')]")).click();*/

        element = driver.findElement(By.xpath("//select[@id = 'cars']"));
        select = new Select(element);
        select.selectByValue("saab");
    }
}
