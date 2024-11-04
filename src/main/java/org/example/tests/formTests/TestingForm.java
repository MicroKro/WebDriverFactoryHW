package org.example.tests.formTests;

import org.example.tests.driver.DriverFactory;
import org.example.tests.pages.AbsBasePages;
import org.junit.jupiter.api.*;

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
    public void fillFields() {
        open("/form.html");
        getById("username").sendKeys(AbsBasePages.NAME);
        getById("email").sendKeys("myau@gmail.com");
        getById("password").sendKeys(AbsBasePages.PASSWORD);
        setTextValue(confirmPas, AbsBasePages.PASSWORD);
        setSelectValue(languageLevEl, "intermediate");
        getById("birthdate").sendKeys("12.05.1991");
        submitForm();
        String send = new String("Имя пользователя: " + AbsBasePages.NAME +
                                        "\nЭлектронная почта: myau@gmail.com\n" +
                                        "Дата рождения: 1991-05-12\n" +
                                        "Уровень языка: intermediate");
        textTheSame(send);
    }
}
