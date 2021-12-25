package tests.booking;

import classwork19.L4JLogging;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import steps.BookingBeforeAfter;
import static pages.trashmail.TrashMailHomePage.USER_LOGIN_TEXT;
import static pages.trashmail.TrashMailHomePage.USER_PASSWORD_TEXT;

public class CreateBookingAccountTest extends BookingBeforeAfter {

    private static final Logger LOGGER = Logger.getLogger(L4JLogging.class.getName());

    @Test
    public void createTrashEmail(){

        trashMailHomePage.goToTrashMailMain();
        trashMailHomePage.fillFormToLogin(USER_LOGIN_TEXT,USER_PASSWORD_TEXT);
        trashMailGridPage.createAddress();
        trashMailGridPage.getEmailText();
        System.out.println(trashMailGridPage.getEmailText());
        LOGGER.info("INFO");
    }

    @Test
    public void registerUserInBooking() {

        bookingSignInPage.emailText = trashMailGridPage.getEmailText();
        bookingHomePage.goToBookingMain();
        bookingHomePage.clickOnRegisterButton();
        bookingSignInPage.fillEmailInSignInForm(bookingSignInPage.emailText);
        bookingSignInPage.submitEmail();
        bookingSignInPage.fillPasswordInSignInForm(bookingSignInPage.passwordText);
        bookingSignInPage.confirmRegistrationNotBot(); // TODO GET BUTTON NO BOTS
        Assert.assertEquals("User is not login ", "Ваш аккаунт", bookingHomePage.getTextAccountTitle());
    }

    @Test
    public void confirmRegistration(){

    }
}