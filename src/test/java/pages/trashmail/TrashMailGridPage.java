package pages.trashmail;

import driver.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrashMailGridPage{

    WebDriver driver = BasicDriver.getWebDriver();

    public static final String ADD_BUTTON = "//span[text()  = 'Add']";
    public static final String SAVE_BUTTON = "//span[@id = 'fe-save-btnEl']";
    public static final String EMAIL_NAME_INPUT = "//table[1]//td[5]/div[@class='x-grid-cell-inner ']";
    private String domainInput = "@trashmail.se";

    public void createAddress(){
        driver.findElement(By.xpath(ADD_BUTTON)).click();
        driver.findElement(By.xpath(SAVE_BUTTON)).click();
    }

    private String getName() {
        return driver.findElement(By.xpath(EMAIL_NAME_INPUT)).getText();
    }

    public String getEmailText() {
        String name = getName();
        return getName() + domainInput;
    }

    public TrashMailGridPage(WebDriver webDriver) {
    }
}