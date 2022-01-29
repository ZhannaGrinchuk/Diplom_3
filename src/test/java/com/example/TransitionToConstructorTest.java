package com.example;

import com.UserOperations;
import com.model.User;
import example.HomePage;
import example.LoginPage;
import example.PrivateOfficePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Переход из личного кабинета в конструктор
public class TransitionToConstructorTest {

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

    //переход по клику на «Конструктор»
    @Test
    public void checkTransitionToConstructor() {

        HomePage goToPersonalOffice = open("https://stellarburgers.nomoreparties.site/", HomePage.class);

        goToPersonalOffice.clickButtonPersonalOffice();
        goToPersonalOffice.clickButtonPersonalOffice();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickLoginButton();
        loginPage.clickButtonPersonalOffice();
        PrivateOfficePage privateOfficePage = page(PrivateOfficePage.class);
        privateOfficePage.clickButtonConstructor();

        assertTrue(privateOfficePage.isTransitionMade());

        sleep(3000);
    }

    //переход на логотип Stellar Burgers

    @Test
    public void checkTransitionToLogo() {

        HomePage goToPersonalOffice = open("https://stellarburgers.nomoreparties.site/", HomePage.class);

        goToPersonalOffice.clickButtonPersonalOffice();
        goToPersonalOffice.clickButtonPersonalOffice();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickLoginButton();
        loginPage.clickButtonPersonalOffice();
        PrivateOfficePage privateOfficePage = page(PrivateOfficePage.class);
        privateOfficePage.clickLogo();

        assertTrue(privateOfficePage.isTransitionMade());

        sleep(3000);
    }
}

