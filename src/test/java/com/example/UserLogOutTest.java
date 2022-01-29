package com.example;


import com.UserOperations;
import com.model.User;
import example.HomePage;
import example.LoginPage;
import example.PrivateOfficePage;
import example.RegistrationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Выход из аккаунта
public class UserLogOutTest {

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

    //Проверь выход по кнопке «Выйти» в личном кабинете
    @Test
    public void checkUserLoginHomePageButton() {

        HomePage userLogOut = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        userLogOut.clickButtonPersonalOffice();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillEmail("test@tesкнкннкнкнкt.ru");
        loginPage.fillPassword("12345ккккк678");
        loginPage.clickLoginButton();
        loginPage.clickButtonPersonalOffice();
        PrivateOfficePage privateOfficePage = page(PrivateOfficePage.class);
        privateOfficePage.clickLogOutButton();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        assertTrue(registrationPage.isUserRegistrationSuccess());

        sleep(3000);

    }
}
