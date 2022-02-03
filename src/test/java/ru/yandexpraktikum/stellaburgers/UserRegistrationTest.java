package ru.yandexpraktikum.stellaburgers;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandexpraktikum.stellaburgers.model.User;
import ru.yandexpraktikum.stellaburgers.pageobjects.HomePage;
import ru.yandexpraktikum.stellaburgers.pageobjects.LoginPage;
import ru.yandexpraktikum.stellaburgers.pageobjects.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Регистрация
public class UserRegistrationTest {

    private UserOperations userOperations;
    User user;

    @Before
    public void setUp() {
        userOperations = new UserOperations();
        userOperations.register();
    }

    @After
    public void tearDown() {
        userOperations.delete();
    }


    @Test
    @Description("Успешная регистрация")
    public void checkUserSuccessRegistration() {

        HomePage userRegistration =
                open("https://stellarburgers.nomoreparties.site/", HomePage.class);

        userRegistration.clickButtonPersonalOffice();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickButtonRegister();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.clickRegisterButton();
        assertTrue(registrationPage.isUserRegistrationSuccess(), "User is not authorized");

    }

    @Test
    @Description("Ошибка для некорректного пароля. Минимальный пароль — шесть символов")
    public void checkErrorIfPasswordIsIncorrect() {

        HomePage userRegistration =
                open("https://stellarburgers.nomoreparties.site/", HomePage.class);

        userRegistration.clickButtonPersonalOffice();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickButtonRegister();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.providePassword("123");
        registrationPage.clickRegisterButton();

        String expeсtedText = "Некорректный пароль";
        String actualText = registrationPage.getErrorText();
        Assert.assertEquals ("Password is correct", expeсtedText, actualText);
    }
}

