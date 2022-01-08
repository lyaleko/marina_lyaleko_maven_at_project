package classwork19.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    public static WebDriver getDriver(Config config){
        return switch (config != null ? config : Config.CHROME){
            case FF -> getFFDriver();
            case REMOTE -> getRemoteDriver();
            default -> getChromeDriver();
        };
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions caps = new ChromeOptions();
        caps.addArguments("start-maximized");
        return new ChromeDriver(caps);
    }

    private static WebDriver getRemoteDriver() {
        ChromeOptions caps = new ChromeOptions();
        caps.addArguments("start-maximized");

        try {
            return new RemoteWebDriver(new URL("https://localhost:4444/wd/hub"), caps);
        }catch(MalformedURLException e){
            e.printStackTrace();
        }
        return null;
    }

    private static WebDriver getFFDriver() {
        return new FirefoxDriver();
    }
}