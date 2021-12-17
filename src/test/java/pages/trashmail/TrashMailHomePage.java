package pages.trashmail;

import driver.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrashMailHomePage {

    WebDriver driver = BasicDriver.getWebDriver();

    public static final String TRASH_MAIL_SITE = "https://trashmail.com/";
    public static final String LOGIN_INPUT = "//input[@placeholder='Username']";
    public static final String PASSWORD_INPUT = "//input[@placeholder='Password']";
    public static final String LOGIN_BUTTON = "//input[@type = 'submit']";
    public static final String USER_LOGIN_TEXT = "MarinaL";
    public static final String USER_PASSWORD_TEXT = "5059874";

    public void goToTrashMailMain() {
        driver.navigate().to(TRASH_MAIL_SITE);
    }

    public void fillFormToLogin(String email, String password){
        driver.findElement(By.xpath(LOGIN_INPUT)).sendKeys(email);
        driver.findElement(By.xpath(PASSWORD_INPUT)).sendKeys(password);
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }

    public TrashMailHomePage(WebDriver webDriver) {
    }
}