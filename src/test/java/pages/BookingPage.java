package pages;

public class BookingPage {

    /** HomePage **/

    public String searchPlaceXPath = "//*[@id='ss']";
    public String calendarRange = "//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']";
    public String selectGuests = "//label[@id='xp__guests__toggle']";
    public String checkPricesXPath = "//button[@data-sb-id='main']";
    public String selectCurrencyXPath = "//button[@data-modal-aria-label  = 'Выберите валюту']";
    public String selectLanguageXPath = "//button[@data-modal-aria-label  = 'Выберите язык']";
    public String textTooltip = "//div[@class= 'bui-tooltip__content']";

    /** ResultPage **/

    public String boxTenthsResultXPath = "//div[@data-testid='property-card'][10]";
    public String titleTenthsResultXPath = "//div[@data-testid='property-card'][10]//div[@data-testid='title']";
    public String menuExtraSorting = "//a[@data-type='dropdown']";
    public String sortingByScorePrice = "//ul[@role='menu' ]//a[@data-type='review_score_and_price']";
}