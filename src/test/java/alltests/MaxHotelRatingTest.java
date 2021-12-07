package alltests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MaxHotelRatingTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void findMaxRaiting(){
        driver.manage().window().maximize();
        driver.navigate().to("https://www.booking.com/");
        driver.findElement(By.xpath("//*[@id='ss']")).sendKeys("Москва");
        driver.findElement(By.xpath("//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']")).click();
        driver.findElement(By.xpath("//span[@aria-label='7 Декабрь 2021']")).click();
        driver.findElement(By.xpath("//span[@aria-label='14 Декабрь 2021']")).click();
        driver.findElement(By.xpath("//button[@data-sb-id='main']")).click(); // click on search
        driver.findElement(By.xpath("//a[@data-type='dropdown']")).click();
        driver.findElement(By.xpath("//ul[@role='menu' ]//a[@data-type='review_score_and_price']")).click();

        WebElement webElement = new WebDriverWait(driver, 1000).until(
                ExpectedConditions.elementToBeClickable (By.xpath("//div[@data-testid='property-card'][1]//div[@aria-label='Оценка 10']")));

        String maxPriceTextRating = webElement.getText();
        int maxPriceNumberRating = Integer.parseInt(maxPriceTextRating.replaceAll("\\D+", ""));

        Assert.assertTrue("The highest hotel rating is incorrect ", maxPriceNumberRating >= 9);
    }
}