package pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DateParser;

public class BookingHomePage {

    WebDriver driver;
    DateParser date = new DateParser();

    public static final String BOOKING_SITE = "https://booking.com";
    public static final String SEARCH_PLACE_INPUT = "//*[@id='ss']";
    public static final String CALENDAR_RANGE = "//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']";
    public static final String EXTRA_PARAM_INPUT = "//label[@id='xp__guests__toggle']";
    public static final String PLUS_MINUS = "//button[@aria-label = '%s: %s количество']";
    public static final String CLOSE_ALL_POPUPS = "//span[contains(.,'другие варианты')]";
    public static final String SEARCH_BUTTON = "//button[@data-sb-id='main']";
    public static final String CURRENCY_BUTTON = "//button[@data-modal-aria-label  = 'Выберите валюту']";
    public static final String LANGUAGE_BUTTON = "//button[@data-modal-aria-label  = 'Выберите язык']";
    public static final String TOOLTIP_TEXT = "//div[@class= 'bui-tooltip__content']";
    public static final String DATE_CALENDAR_SELECT = "//td[@data-date='%s']";
    public static final String REGISTER_BUTTON = "//a[@class='bui-button bui-button--secondary js-header-login-link']";
    public static final String AVATAR_BUTTON = "//div[@class='bui-avatar-block']";
    public static final String ACCOUNT_TITLE = "//span[@id = 'profile-menu-trigger--title']";
    public static final String CLOSE_POPUP_BUTTON = "//button[@class='modal-mask-closeBtn']";
    public static final String CONTACT_BUTTON = "//a[@data-bui-component='Tooltip']//span[@class='bui-button__icon']";
    public static final String NOTIFICATION_BUTTON = "//nav[1]/div[2]/div[4]/button/span/div/span[1]";
    public static final String REGISTER_PROPERTY = "//a[@class='bui-button bui-button--light bui-traveller-header__product-action']";

    public void goToBookingMain() {
        driver.navigate().to(BOOKING_SITE);
    }

    public void searchCity (String cityName){
        driver.findElement(By.xpath(SEARCH_PLACE_INPUT)).sendKeys(cityName);
        driver.findElement(By.xpath(SEARCH_BUTTON)).click();
    }
    public void inputCity (String cityName){
        driver.findElement(By.xpath(SEARCH_PLACE_INPUT)).sendKeys(cityName);
    }

    public void submitSearch(){
        driver.findElement(By.xpath(SEARCH_BUTTON)).click();
    }

    public void setDatesCalendar(int dayFrom, int dayTo){
        driver.findElement(By.xpath(CALENDAR_RANGE)).click();
        driver.findElement(By.xpath(String.format(DATE_CALENDAR_SELECT, date.getDateString(dayFrom)) )).click();
        driver.findElement(By.xpath(String.format(DATE_CALENDAR_SELECT, date.getDateString(dayTo)) )).click();
    }

    public void setNumberOfAdults(int number) {

        if (number == 1) {
            performPlusMinusInput("Взрослых", "уменьшить", number);

        } else if (number > 2 && number < 31) {
            performPlusMinusInput("Взрослых", "увеличить", number - 2);
        }
    }
    private void performPlusMinusInput(String type, String direction, int times) {
        driver.findElement(By.xpath(EXTRA_PARAM_INPUT)).click();
        for (int i = 0; i < times; i++) {
            driver.findElement(By.xpath(String.format(PLUS_MINUS, direction, type))).click();
        }
        driver.findElement(By.xpath(CLOSE_ALL_POPUPS)).click();
    }

    public void setNumberOfRooms(int number) {
        if (number > 1 && number < 31) {
            performPlusMinusInput("Номера", "увеличить", number - 1);
        }
    }

    public void clickOnRegisterButton(){
        driver.findElement(By.xpath(REGISTER_BUTTON)).click();
    }

    public WebElement getCurrencyField() {
        return driver.findElement(By.xpath(CURRENCY_BUTTON));
    }

    public String getToolTipText() {
        return driver.findElement(By.xpath(TOOLTIP_TEXT)).getText();
    }

    public WebElement getLanguageField() {
        return driver.findElement(By.xpath(LANGUAGE_BUTTON));
    }

    public String getTextAccountTitle() {
        return String.format(driver.findElement(By.xpath(ACCOUNT_TITLE)).getText());
    }

    public void closePopup(){
        driver.findElement(By.xpath(CLOSE_POPUP_BUTTON)).click();
    }

    public BookingHomePage(WebDriver driver) {
        this.driver = driver;
    }
}