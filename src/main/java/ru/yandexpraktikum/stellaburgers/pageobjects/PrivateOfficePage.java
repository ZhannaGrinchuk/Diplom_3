package ru.yandexpraktikum.stellaburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class PrivateOfficePage {

    //локатор кнопки Выход
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Выход')]")
    private SelenideElement logOutButton;


    //локатор кнопки Конструктор
    @FindBy(how = How.LINK_TEXT, using = "Конструктор")
    private SelenideElement buttonСonstructor;


    //локатор лого Stellar Burgers
    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']/a")
    private SelenideElement logo;

    @Step("Клик по кнопке Выход")
    public void clickLogOutButton() {
        logOutButton.click();
    }

    @Step("Клик по кнопке Конструктор")
    public void clickButtonConstructor() {
        buttonСonstructor.click();
    }

    @Step("Клик по лого")
    public void clickLogo() {
        logo.click();
    }

    @Step("Открытие страницы Личный кабинет")
    public boolean isUserLoginSuccess(){
        urlContaining("https://stellarburgers.nomoreparties.site/account/profile");
        return true;
    }

    @Step("Открытие страницы Конструктор")
    public boolean isTransitionMade(){
        urlContaining("https://stellarburgers.nomoreparties.site/");
        return true;
    }
}
