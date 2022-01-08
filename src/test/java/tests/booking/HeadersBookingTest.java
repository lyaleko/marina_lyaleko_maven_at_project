package tests.booking;

import org.junit.Test;
import steps.BookingBeforeAfter;

public class HeadersBookingTest extends BookingBeforeAfter {

    @Test
    public void loginBooking(){

        bookingHomePage.goToBookingMain();
        bookingHomePage.clickOnRegisterButton();
        bookingSignInPage.fillEmailInSignInForm(bookingSignInPage.emailTextTestUser);
        bookingSignInPage.submitEmail();
        bookingSignInPage.fillPasswordLoginForm(bookingSignInPage.passwordText);
        bookingHomePage.closePopup();

    }
}