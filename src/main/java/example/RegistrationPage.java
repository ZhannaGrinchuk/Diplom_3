package example;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class RegistrationPage {

    // локатор поля ввода Имя по XPATH, поиск по плейсхолдеру
    @FindBy(how = How.XPATH, using = ".//form//div[label[text()='Имя']]/input")
    public SelenideElement fieldName;

    // локатор поля ввода Email по XPATH, поиск по плейсхолдеру
    @FindBy(how = How.XPATH, using = ".//form//div[label[text()='Email']]/input")
    public SelenideElement fieldEmail;


    // локатор поля ввода Пароль по XPATH, поиск по плейсхолдеру
    @FindBy(how = How.XPATH, using = ".//form//div[label[text()='Пароль']]/input")
    public SelenideElement fieldPassword;

    //локатор кнопки Зарегистрироваться
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registerButton;

    //локатор ошибки некорректного пароля
    @FindBy(how = How.CLASS_NAME, using = "input__error")
    private SelenideElement error;

    //локатор кнопки Войти под формой заполнения
    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement loginButtonRegistrationForm;

    //метод заполнения поля ввода Имя
    public void provideName(String username) {
        fieldName.sendKeys(username);
    }

    //метод заполнения поля ввода Email
    public void provideEmail(String username) {
    fieldEmail.sendKeys(username);
        }

    //метод заполнения поля ввода Пароль
    public void providePassword(String username) {
    fieldPassword.sendKeys(username);
            }


    //метод клика по кнопке Зарегистрироваться
    public void clickRegisterButton () {
    registerButton.click();
                }

    //получить текст ошибки при некорректном пароле
    public String getErrorText() {
        return error.getText();
    }

    //метод клика по кнопке Войти под формой регистрации
    public void clickButtonLoginRegistrationForm() {
        loginButtonRegistrationForm.click();
    }

    //метод подтверждения открытия страницы
    public boolean isUserRegistrationSuccess(){
        urlContaining("https://stellarburgers.nomoreparties.site/login");
        return true;
    }
}

