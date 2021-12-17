package tests.booking;

import org.junit.Assert;
import org.junit.Test;
import steps.BookingBeforeAfter;

public class MaxHotelRatingTest extends BookingBeforeAfter {

    @Test
    public void findMaxRating(){

        bookingHomePage.goToBookingMain();
        bookingHomePage.inputCity("Москва");
        bookingHomePage.setDatesCalendar(0,7);
        bookingHomePage.submitSearch();
        bookingResultPage.openExtraMenu();
        bookingResultPage.sortByScorePrice();
        wait.waitForElement(bookingResultPage.SPINNER);

       Assert.assertTrue("The highest hotel rating is incorrect ", bookingResultPage.getMaxPriceRating() >= 9);
   }
}