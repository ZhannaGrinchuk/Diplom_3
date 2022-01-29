package com.example;

import com.UserOperations;
import example.HomePage;
import example.LoginPage;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Переход в личный кабинет
public class GoToPersonalOfficeTest {

    private UserOperations userOperations;
    private String email;
    private String password;

    @Before
    public void setUp() {
        userOperations = new UserOperations();
        userOperations.register();
    }


    //Проверь переход по клику на «Личный кабинет»
    @Test
    public void checkGoToPersonalOffice() {

        HomePage goToPersonalOffice = open("https://stellarburgers.nomoreparties.site/", HomePage.class);

        goToPersonalOffice.clickButtonPersonalOffice();
        goToPersonalOffice.clickButtonPersonalOffice();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickLoginButton();
        loginPage.clickButtonPersonalOffice();

        assertTrue(loginPage.isUserLoginSuccess());

        sleep(3000);


    }

}
