package ru.yandexpraktikum.stellaburgers;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandexpraktikum.stellaburgers.model.User;
import ru.yandexpraktikum.stellaburgers.pageobjects.HomePage;
import ru.yandexpraktikum.stellaburgers.pageobjects.LoginPage;
import ru.yandexpraktikum.stellaburgers.pageobjects.PrivateOfficePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
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


    @Test
    @Description("Переход по клику на «Конструктор»")
    public void checkTransitionToConstructor() {

        HomePage goToPersonalOffice = open("https://stellarburgers.nomoreparties.site/", HomePage.class);

        goToPersonalOffice.clickButtonPersonalOffice();
        goToPersonalOffice.clickButtonPersonalOffice();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickLoginButton();
        loginPage.clickButtonPersonalOffice();
        PrivateOfficePage privateOfficePage = page(PrivateOfficePage.class);
        privateOfficePage.clickButtonConstructor();

        assertTrue(privateOfficePage.isTransitionMade(), "Transition to Constructor is not made");

    }


    @Test
    @Description("Переход на логотип Stellar Burgers")
    public void checkTransitionToLogo() {

        HomePage goToPersonalOffice = open("https://stellarburgers.nomoreparties.site/", HomePage.class);

        goToPersonalOffice.clickButtonPersonalOffice();
        goToPersonalOffice.clickButtonPersonalOffice();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickLoginButton();
        loginPage.clickButtonPersonalOffice();
        PrivateOfficePage privateOfficePage = page(PrivateOfficePage.class);
        privateOfficePage.clickLogo();

        assertTrue(privateOfficePage.isTransitionMade(), "Transition to logo is not made");

    }
}

