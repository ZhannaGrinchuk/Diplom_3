package com.example;

import com.UserOperations;
import com.model.User;
import example.ForgotPasswordPage;
import example.HomePage;
import example.LoginPage;
import example.RegistrationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Вход
public class UserLoginTest {

    private UserOperations userOperations;
    private User user;


    @Before
    public void setUp() {
        user = new User();
        userOperations = new UserOperations();
        userOperations.register();
    }

    @After
    public void tearDown() {
        userOperations.delete();
        closeWebDriver();
    }


    //вход по кнопке «Войти в аккаунт» на главной
    @Test
    public void checkUserLoginHomePageButton() {


        HomePage userLogin = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        userLogin.clickButtonGoToAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickLoginButton();
        assertTrue(loginPage.isUserLoginSuccess());


        sleep(3000);
    }

    //вход через кнопку «Личный кабинет»
    @Test
    public void checkUserLoginButtonPrivateOffice() {

        HomePage userloginButtonPrivateOffice = open("https://stellarburgers.nomoreparties.site/", HomePage.class);

        userloginButtonPrivateOffice.clickButtonPersonalOffice();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickLoginButton();
        assertTrue(loginPage.isUserLoginSuccess());

        sleep(3000);

    }

    //вход через кнопку в форме регистрации
    @Test
    public void checkUserLoginButtonRegistrationForm() {

        RegistrationPage registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);

        registrationPage.clickButtonLoginRegistrationForm();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickLoginButton();
        assertTrue(loginPage.isUserLoginSuccess());

        sleep(3000);

    }

    //вход через кнопку в форме восстановления пароля
    @Test
    public void checkUserLoginButtonForgotPassword() {

        ForgotPasswordPage forgotPasswordPage = open("https://stellarburgers.nomoreparties.site/forgot-password", ForgotPasswordPage.class);

        forgotPasswordPage.clickLoginButtonForgotPassword();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickLoginButton();
        assertTrue(loginPage.isUserLoginSuccess());

        sleep(3000);

    }
}
