package org.example.tests.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static WebDriver getDriver (String browserType) throws IllegalAccessException {
        WebDriver driver = null;

        switch (browserType.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                firefoxOptions.addArguments("--maximize");
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalAccessException( "Неподдерживаемый браузер" + browserType);
        }
        return driver;
    }
}
