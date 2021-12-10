package pages;

public class BookingPage {

    /** HomePage **/

    public String searchPlaceInput = "//*[@id='ss']";
    public String calendarRange = "//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']";
    public String selectGuests = "//label[@id='xp__guests__toggle']";
    public String checkPricesButton = "//button[@data-sb-id='main']";
    public String selectCurrency = "//button[@data-modal-aria-label  = 'Выберите валюту']";
    public String selectLanguage = "//button[@data-modal-aria-label  = 'Выберите язык']";
    public String textTooltipCurrency = "//button[@data-tooltip-text='Выберите валюту']";
    public String textTooltipLanguage = "//button[@data-tooltip-text='Выберите язык']";
    //   "//div[@class= 'bui-tooltip__content']"


    /** ResultPage **/

    public String boxTenthsResult = "//div[@data-testid='property-card'][10]";
    public String titleTenthsResult = "//div[@data-testid='property-card'][10]//div[@data-testid='title']";
    public String menuExtraSorting = "//a[@data-type='dropdown']";
    public String sortingByScorePrice = "//ul[@role='menu' ]//a[@data-type='review_score_and_price']";

}