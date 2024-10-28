package org.example.tests.formTests;


import org.example.tests.driver.DriverFactory;
import org.example.tests.pages.AbsBasePages;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class TestingForm extends AbsBasePages {

    public TestingForm() throws IllegalAccessException {
        super(DriverFactory.getDriver("chrome"));
    }

    @BeforeEach
    public void setUp() {
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
    public void fillFilds() {
        open("/form.html");
        getById("username").sendKeys(AbsBasePages.NAME);
        getById("email").sendKeys("myau@gmail.com");
        getById("password").sendKeys(AbsBasePages.PASSWORD);
        getById("confirm_password").sendKeys(AbsBasePages.PASSWORD);
        WebElement select = languageLevEl;
        Select solutions = new Select(select);
        solutions.selectByValue("intermediate");
        driver.findElement(By.cssSelector("#registrationForm input[type=date]")).sendKeys("12.05.1991");
        driver.findElement(By.cssSelector("#registrationForm input[type=submit]")).click();
        String send = new String("Имя пользователя: " + AbsBasePages.NAME +
                                        "\nЭлектронная почта: myau@gmail.com\n" +
                                        "Дата рождения: 1991-05-12\n" +
                                        "Уровень языка: intermediate");
        textTheSame(send);
    }
}
