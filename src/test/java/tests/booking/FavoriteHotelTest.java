package tests.booking;

import org.junit.Test;
import steps.BookingBeforeAfter;

public class FavoriteHotelTest extends BookingBeforeAfter {

    @Test
    public void loginBooking(){

        bookingHomePage.goToBookingMain();
        bookingHomePage.clickOnRegisterButton();
        bookingSignInPage.fillEmailInSignInForm(bookingSignInPage.emailTextTestUser);
        bookingSignInPage.submitEmail();
        bookingSignInPage.fillPasswordLoginForm(bookingSignInPage.passwordText);
        bookingHomePage.closePopup();
    }

    @Test
    public void markFavoriteHotel(){
        bookingHomePage.inputCity("Мадрид");
        bookingHomePage.setDatesCalendar(31,5);
        bookingHomePage.submitSearch();
        bookingResultPage.getDefiniteHeart(1).click();
        wait.waitForElement(bookingResultPage.SPINNER);
        bookingResultPage.jsScrollToElement(bookingResultPage.getDefiniteHeart(10));
    }
}