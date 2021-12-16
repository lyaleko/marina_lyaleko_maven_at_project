package tests;

import org.junit.Assert;
import org.junit.Test;
import steps.BookingBeforeAfter;

public class MaxHotelRatingTest extends BookingBeforeAfter {

    @Test
    public void findMaxRating(){

        homePage.goToBookingMain();
        homePage.inputCity("Москва");
        homePage.setDatesCalendar(0,7);
        homePage.submitSearch();
        resultPage.openExtraMenu();
        resultPage.sortByScorePrice();
        wait.waitForElement(resultPage.SPINNER);

       Assert.assertTrue("The highest hotel rating is incorrect ", resultPage.getMaxPriceRating() >= 9);
   }
}