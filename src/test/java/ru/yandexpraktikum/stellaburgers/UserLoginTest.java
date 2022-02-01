package ru.yandexpraktikum.stellaburgers;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandexpraktikum.stellaburgers.model.User;
import ru.yandexpraktikum.stellaburgers.pageobjects.ForgotPasswordPage;
import ru.yandexpraktikum.stellaburgers.pageobjects.HomePage;
import ru.yandexpraktikum.stellaburgers.pageobjects.LoginPage;
import ru.yandexpraktikum.stellaburgers.pageobjects.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
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
    }


    @Test
    @Description("Вход по кнопке «Войти в аккаунт» на главной")
    public void checkUserLoginHomePageButton() {

        HomePage userLogin = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        userLogin.clickButtonGoToAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickLoginButton();
        assertTrue(loginPage.isUserLoginSuccess(), "Login failed");

    }


    @Test
    @Description("Вход через кнопку «Личный кабинет»")
    public void checkUserLoginButtonPrivateOffice() {

        HomePage userloginButtonPrivateOffice = open("https://stellarburgers.nomoreparties.site/", HomePage.class);

        userloginButtonPrivateOffice.clickButtonPersonalOffice();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickLoginButton();
        assertTrue(loginPage.isUserLoginSuccess(), "Login failed");

    }

    @Test
    @Description("Вход через кнопку в форме регистрации")
    public void checkUserLoginButtonRegistrationForm() {

        RegistrationPage registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);

        registrationPage.clickButtonLoginRegistrationForm();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickLoginButton();
        assertTrue(loginPage.isUserLoginSuccess(), "Login failed");


    }

    @Test
    @Description("Вход через кнопку в форме восстановления пароля")
    public void checkUserLoginButtonForgotPassword() {

        ForgotPasswordPage forgotPasswordPage = open("https://stellarburgers.nomoreparties.site/forgot-password", ForgotPasswordPage.class);

        forgotPasswordPage.clickLoginButtonForgotPassword();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickLoginButton();
        assertTrue(loginPage.isUserLoginSuccess(), "Login failed");

    }
}
