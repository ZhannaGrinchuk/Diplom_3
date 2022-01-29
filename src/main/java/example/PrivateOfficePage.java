package example;

import com.codeborne.selenide.SelenideElement;
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

    //метод клика по кнопке Выход
    public void clickLogOutButton() {
        logOutButton.click();
    }

    //метод клика по кнопку Конструктор
    public void clickButtonConstructor() {
        buttonСonstructor.click();
    }

    //метод клика по лого
    public void clickLogo() {
        logo.click();
    }

    //метод подтверждения открытия страницы Личный кабинет
    public boolean isUserLoginSuccess(){
        urlContaining("https://stellarburgers.nomoreparties.site/account/profile");
        return true;
    }

    //метод подтверждения открытия страницы Конструктор
    public boolean isTransitionMade(){
        urlContaining("https://stellarburgers.nomoreparties.site/");
        return true;
    }




}
