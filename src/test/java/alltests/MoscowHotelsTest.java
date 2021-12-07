package alltests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MoscowHotelsTest {

    WebDriver driver = new ChromeDriver();
    @Test
    public void isHotelsTest() {

        driver.manage().window().maximize();
        driver.navigate().to("https://www.booking.com/");
        driver.findElement(By.xpath("//*[@id='ss']")).sendKeys("Москва");
        driver.findElement(By.xpath("//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']")).click();
        driver.findElement(By.xpath("//span[@aria-label='7 Декабрь 2021']")).click();
        driver.findElement(By.xpath("//span[@aria-label='14 Декабрь 2021']")).click();
        driver.findElement(By.xpath("//button[@data-sb-id='main']")).click(); // click on search
        driver.findElement(By.xpath("//a[contains(text(), 'сначала самая низкая')]")).click();

        WebElement firstElement = driver.findElement(By.xpath("//div[@data-testid='property-card'][1]"));

        Assert.assertTrue(firstElement.isDisplayed());
    }
}