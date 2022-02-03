package ru.yandexpraktikum.stellaburgers;

import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;
import ru.yandexpraktikum.stellaburgers.pageobjects.HomePage;
import ru.yandexpraktikum.stellaburgers.pageobjects.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Переход в личный кабинет
public class GoToPersonalOfficeTest {

    private UserOperations userOperations;

    @Before
    public void setUp() {
        userOperations = new UserOperations();
        userOperations.register();
    }


    @Test
    @Description("Проверь переход по клику на «Личный кабинет»")
    public void checkGoToPersonalOffice() {

        HomePage goToPersonalOffice = open("https://stellarburgers.nomoreparties.site/", HomePage.class);

        goToPersonalOffice.clickButtonPersonalOffice();
        goToPersonalOffice.clickButtonPersonalOffice();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickLoginButton();
        loginPage.clickButtonPersonalOffice();

        assertTrue(loginPage.isUserLoginSuccess(), "Transition to personal account is not made");

    }
}
