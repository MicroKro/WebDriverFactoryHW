package org.example.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbsCommon {

    protected static final String URL = System.getProperty("base.url");

    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected Actions actions; //пока под вопросом

    public AbsCommon (WebDriver driver) {
        WebDriverManager.chromedriver().setup();
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void open(String path) {
        driver.get(URL + path);
    }

    private String poleIdTemplate = "[id = '%s']";

    protected WebElement getById(String id) {
        return driver.findElement(By.cssSelector(String.format(poleIdTemplate, id)));
    }

    protected WebElement getBySelector(String cssSector) {
        return driver.findElement(By.cssSelector(cssSector));
    }
}
