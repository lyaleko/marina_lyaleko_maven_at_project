package tests.booking;

import org.junit.Assert;
import org.junit.Test;
import steps.BookingBeforeAfter;

public class ColorTest extends BookingBeforeAfter {

    @Test
    public void titleColorTest(){

        bookingHomePage.goToBookingMain();
        bookingHomePage.searchCity("Москва");
        bookingResultPage.jsScrollToElement(bookingResultPage.getDefiniteCard(10));
        bookingResultPage.jsColorCard("green", bookingResultPage.getDefiniteCard(10));
        bookingResultPage.jsColorText("red", bookingResultPage.getDefiniteCard(10));

        Assert.assertEquals("Result isn't correct", "rgba(255, 0, 0, 1)", bookingResultPage.getDefiniteCard(10).getCssValue("color"));
    }
}