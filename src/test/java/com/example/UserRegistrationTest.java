package com.example;

import com.UserOperations;
import com.model.User;
import example.HomePage;
import example.LoginPage;
import example.RegistrationPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
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


    //успешная регистрация ПЕРЕПИСАТЬ С РАНДОМНЫМИ ДАННЫМИ!
    @Test
    public void checkUserSuccessRegistration() {

        HomePage userRegistration =
                open("https://stellarburgers.nomoreparties.site/", HomePage.class);

        userRegistration.clickButtonPersonalOffice();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickButtonRegister();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.clickRegisterButton();
        assertTrue(registrationPage.isUserRegistrationSuccess());

        sleep(3000);
    }

    //Ошибка для некорректного пароля. Минимальный пароль — шесть символов
    @Test
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
        Assert.assertEquals (expeсtedText, actualText);

        sleep(3000);

    }
}

