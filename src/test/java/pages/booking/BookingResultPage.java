package pages.booking;

import driver.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingResultPage {

    WebDriver driver = BasicDriver.getWebDriver();

    public static final String RESULT_TITLE = "//div[@data-testid='property-card'][10]//div[@data-testid='title']";
    public static final String EXTRA_MENU_BUTTON = "//a[@data-type='dropdown']";
    public static final String SORTING_BY_SCORE_PRICE = "//ul[@role='menu' ]//a[@data-type='review_score_and_price']";
    public static final String MAX_SCORE = "//div[@data-testid='property-card'][1]//div[@aria-label='Оценка 10']";
    public static final String SPINNER = ".bui-spinner.bui-spinner--size-large";
    public static final String MAX_PRICE_FILTER = "//div[@id='searchboxInc']//div[@data-filters-group='pri']//div[contains(text(), '+')]";
    public static final String MIN_PRICE_MENU = "//a[contains(text(), 'сначала самая низкая')]";
    public static final String PROPERTY_CARD = "//div[@data-testid='property-card'][%d]";
    public static final String FIRST_PRICE = "//div[@id='search_results_table']//div[@data-testid='property-card'][1]//div[@data-testid='price-and-discounted-price']//span";
    public static final String HOTEL_RATING = "//div[@data-testid = 'review-score-right-component']/div[contains(@aria-label,' ')]";

    public BookingResultPage(WebDriver driver) {
    }

    public void openExtraMenu(){
        driver.findElement(By.xpath(EXTRA_MENU_BUTTON)).click();
    }
    public void sortByScorePrice(){
        driver.findElement(By.xpath(SORTING_BY_SCORE_PRICE)).click();
    }

    public WebElement filterByMaxPrice(){
        return driver.findElement(By.xpath(MAX_PRICE_FILTER));
    }

    public WebElement getDefiniteCard(int cardNumber) {
        return driver.findElement(By.xpath(String.format(PROPERTY_CARD, cardNumber)));
    }

    public int getMaxFilterPrice(){
        int value = Integer.parseInt(driver.findElement(By.xpath(MAX_PRICE_FILTER))
                .getText()
                .replaceAll("\\D", ""));
        return value;
    }

    public int getMaxPriceRating() {
        return Integer.parseInt(driver.findElement(By.xpath(MAX_SCORE))
                .getText()
                .replaceAll("\\D", ""));
    }

    public void jsScrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public void jsColorCard(String color, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(String.format("arguments[0].style.backgroundColor = '%s'", color), element);
    }

    public void jsColorText(String color, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(String.format("arguments[0].style.color = '%s'", color), element);
    }
    public double getHotelRating(){
        return Double.parseDouble((driver.findElement(By.xpath(HOTEL_RATING)).getText()));
    }
}