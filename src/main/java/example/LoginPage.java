package example;

import com.codeborne.selenide.SelenideElement;
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

    //метод клика по кнопке Зарегистрироваться
    public void clickButtonRegister() {
        buttonRegister.click();
    }

    //метод клика по кнопке Войти
    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickButtonPersonalOffice() {
        buttonPersonalOffice.click();
    }

    //метод заполнения поля ввода Email
    public void fillEmail(String username) {
        email.sendKeys(username);
    }

    //метод заполнения поля ввода Пароль
    public void fillPassword(String username) {
        password.sendKeys(username);
    }

    //метод подтверждения открытия страницы
    public boolean isUserLoginSuccess(){
        urlContaining("https://stellarburgers.nomoreparties.site/");
        return true;
    }

}
