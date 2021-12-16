package tests;

import org.junit.Assert;
import org.junit.Test;
import steps.BookingBeforeAfter;

public class MoscowHotelsTest extends BookingBeforeAfter {

    @Test
    public void isHotelExistTest() {

        homePage.goToBookingMain();
        homePage.inputCity("Москва");
        homePage.setDatesCalendar(0,7);
        homePage.submitSearch();

        Assert.assertTrue("There is no any hotel ",resultPage.getDefiniteCard(1).isDisplayed());
    }
}