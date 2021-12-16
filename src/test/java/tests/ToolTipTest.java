package tests;

import org.junit.Assert;
import org.junit.Test;
import steps.BookingBeforeAfter;

public class ToolTipTest extends BookingBeforeAfter {

    @Test
    public void toolTipCurrencyTest() {
        homePage.goToBookingMain();
        actions.moveToElement(homePage.getCurrencyField());
        Assert.assertEquals("Incorrect text Tooltip Currency ", "Выберите валюту", homePage.getToolTipText());
    }

    @Test
    public void toolTipLanguageTest() {
        homePage.goToBookingMain();
        actions.moveToElement(homePage.getLanguageField());
        Assert.assertEquals("Incorrect text Tooltip Language ", "Выберите язык", homePage.getToolTipText());
    }
}