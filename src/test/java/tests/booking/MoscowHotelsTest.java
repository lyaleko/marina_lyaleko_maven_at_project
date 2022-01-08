package tests.booking;

import org.junit.Assert;
import org.junit.Test;
import steps.BookingBeforeAfter;

public class MoscowHotelsTest extends BookingBeforeAfter {

    @Test
    public void isHotelExistTest() {

        bookingHomePage.goToBookingMain();
        bookingHomePage.inputCity("Москва");
        bookingHomePage.setDatesCalendar(0,7);
        bookingHomePage.submitSearch();

        Assert.assertTrue("There is no any hotel ", bookingResultPage.getDefiniteCard(1).isDisplayed());
    }
}