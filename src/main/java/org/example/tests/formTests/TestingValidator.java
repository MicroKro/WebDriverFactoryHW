package org.example.tests.formTests;

import org.example.tests.driver.DriverFactory;
import org.example.tests.pages.AbsBasePages;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestingValidator extends AbsBasePages {

    public TestingValidator() throws IllegalAccessException {
        super(DriverFactory.getDriver("chrome"));
    }

    @BeforeEach
    public void setUp(){
        System.out.println("Запуск драйвера");
    }

    @AfterEach
    public void setDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Драйвер закрыт");
        }
    }

    @Test
    public void testValidator() {
        open("/form.html");
        getById("username").sendKeys(AbsBasePages.NAME);
        getById("email").sendKeys("myau@gmail.com");
        getById("password").sendKeys(AbsBasePages.PASSWORD);
        setTextValue(confirmPas, AbsBasePages.WRONGPASSWORD);
        setSelectValue(languageLevEl, "intermediate");
        getById("birthdate").sendKeys("12.05.1991");
        submitForm();
        passNoConf("Пароли не совпадают!");
    }
}
