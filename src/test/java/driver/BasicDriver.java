package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicDriver {

    public static WebDriver webDriver;

    public static WebDriver getWebDriver(){
        if(webDriver == null){
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }
}