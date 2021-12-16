package tests;

import org.junit.Assert;
import org.junit.Test;
import steps.BookingBeforeAfter;

public class ColorTest extends BookingBeforeAfter {

    @Test
    public void titleColorTest(){

        homePage.goToBookingMain();
        homePage.searchCity("Москва");
        resultPage.jsScrollToElement(resultPage.getDefiniteCard(10));
        resultPage.jsColorCard("green", resultPage.getDefiniteCard(10));
        resultPage.jsColorText("red", resultPage.getDefiniteCard(10));

        Assert.assertEquals("Result isn't correct", "rgba(255, 0, 0, 1)", resultPage.getDefiniteCard(10).getCssValue("color"));
    }
}