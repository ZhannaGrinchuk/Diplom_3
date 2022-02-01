package ru.yandexpraktikum.stellaburgers;


import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandexpraktikum.stellaburgers.model.User;
import ru.yandexpraktikum.stellaburgers.pageobjects.HomePage;
import ru.yandexpraktikum.stellaburgers.pageobjects.LoginPage;
import ru.yandexpraktikum.stellaburgers.pageobjects.PrivateOfficePage;
import ru.yandexpraktikum.stellaburgers.pageobjects.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
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

    @Test
    @Description("Проверь выход по кнопке «Выйти» в личном кабинете")
    public void checkUserLogOutClickButtonLogoutPrivateOffice() {

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
        assertTrue(registrationPage.isUserRegistrationSuccess(), "Logout failed");

    }
}
