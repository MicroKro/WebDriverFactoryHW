package org.example.tests.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbsBasePages  extends AbsCommon {

    public AbsBasePages(WebDriver driver) {
        super(driver);
    }

    protected static final String PASSWORD = System.getProperty("testpass");
    protected static final String NAME = System.getProperty("testname");
    protected static final String WRONGPASSWORD = System.getProperty("teswrongtpass");

    @FindBy(id = "language_level")
    protected WebElement languageLevEl;

    @FindBy(id = "confirm_password")
    protected WebElement confirmPas;

    @FindBy(id = "output")
    protected WebElement outputEl;

    protected void setTextValue(WebElement input, String value) {
        input.sendKeys(value);
    }

    protected void setSelectValue(WebElement select, String value) {
        Select solutions = new Select(select);
        solutions.selectByValue(value);
    }

    public AbsBasePages textTheSame(String actual) {
        Assertions.assertEquals(
                actual,
                outputEl.getText()
        );
        return this;
    }

    protected void submitForm() {
        getBySelector("#registrationForm input[type=submit]").click();
    }

    public AbsBasePages passNoConf(String targetText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String actual = alert.getText();
        alert.accept();
        Assertions.assertEquals(targetText, actual);
        return this;
    }
}
