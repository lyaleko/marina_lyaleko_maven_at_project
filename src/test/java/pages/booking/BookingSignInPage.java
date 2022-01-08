package pages.booking;

import driver.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingSignInPage {

    WebDriver driver = BasicDriver.getWebDriver();

    private String EMAIL_INPUT = "//input[@type='email']";
    private String PASSWORD_FIRST_INPUT = "//div[@class='password-input-container bui-spacer--large'][1]//input[@type='password']";
    private String PASSWORD_CONFIRMED_INPUT = "//div[@class='password-input-container bui-spacer--large'][2]//input[@type='password']";
    public String emailText;
    public String emailTextTestUser = "marina.tester@trashmail.se";
    public String passwordText = "555666777888Mm"; //TODO SHOULD KNOW IS PUBLIC REQUIRED
    public static final String SUBMIT_BUTTON = "//button[@type='submit']";
    private static final String BUTTON_AGAINST_ROBOT = "//*[@id='px-captcha']/iframe[9]";// TODO FIND CORRECT PATH

    public void fillEmailInSignInForm(String email) {
        driver.findElement(By.xpath(EMAIL_INPUT)).sendKeys(email);
    }

    public void submitEmail(){
        driver.findElement(By.xpath(SUBMIT_BUTTON)).click();
    }

    public void fillPasswordInSignInForm(String passwordText){
        driver.findElement(By.xpath(PASSWORD_FIRST_INPUT)).sendKeys(passwordText);
        driver.findElement(By.xpath(PASSWORD_CONFIRMED_INPUT)).sendKeys(passwordText);
        driver.findElement(By.xpath(SUBMIT_BUTTON)).click();
    }

    public void fillPasswordLoginForm(String passwordText){
        driver.findElement(By.xpath(PASSWORD_FIRST_INPUT)).sendKeys(passwordText);
        driver.findElement(By.xpath(SUBMIT_BUTTON)).click();
    }

    public void confirmRegistrationNotBot(){
        driver.findElement(By.xpath(BUTTON_AGAINST_ROBOT)).click();
    }

    public BookingSignInPage(WebDriver webDriver) {
    }
}