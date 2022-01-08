package tests.booking;

import org.junit.Assert;
import org.junit.Test;
import steps.BookingBeforeAfter;

public class ToolTipTest extends BookingBeforeAfter {

    @Test
    public void toolTipCurrencyTest() {
        bookingHomePage.goToBookingMain();
        actions.moveToElement(bookingHomePage.getCurrencyField());
        Assert.assertEquals("Incorrect text Tooltip Currency ", "Выберите валюту", bookingHomePage.getToolTipText());
    }

    @Test
    public void toolTipLanguageTest() {
        bookingHomePage.goToBookingMain();
        actions.moveToElement(bookingHomePage.getLanguageField());
        Assert.assertEquals("Incorrect text Tooltip Language ", "Выберите язык", bookingHomePage.getToolTipText());
    }
}