package ru.yandexpraktikum.stellaburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class LoginPage {


    //поле Email
    @FindBy(how = How.NAME, using = "name")
    public SelenideElement email;

    //поле Пароль
    @FindBy(how = How.NAME, using = "Пароль")
    public SelenideElement password;


    //локатор кнопки Зарегистрироваться
    @FindBy(how = How.LINK_TEXT, using = "Зарегистрироваться")
    private SelenideElement buttonRegister;

    //локатор кнопки Войти
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Войти')]")
    private SelenideElement loginButton;

    //локатор кнопки Личный кабинет
    @FindBy(how = How.LINK_TEXT, using = "Личный Кабинет")
    private SelenideElement buttonPersonalOffice;

    @Step("Клик по кнопке Зарегистрироваться")
    public void clickButtonRegister() {
        buttonRegister.click();
    }

    @Step("Клик по кнопке Войти")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Клик по кнопке Личный кабинет")
    public void clickButtonPersonalOffice() {
        buttonPersonalOffice.click();
    }

    @Step("Заполнение поля ввода Email")
    public void fillEmail(String username) {
        email.sendKeys(username);
    }

    @Step("Заполнение поля ввода Пароль")
    public void fillPassword(String username) {
        password.sendKeys(username);
    }

    @Step("Открытие главной страницы")
    public boolean isUserLoginSuccess(){
        urlContaining("https://stellarburgers.nomoreparties.site/");
        return true;
    }

}
