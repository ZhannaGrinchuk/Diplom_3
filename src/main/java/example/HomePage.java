package example;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

    //локатор кнопки Личный кабинет
    @FindBy(how = How.LINK_TEXT, using = "Личный Кабинет")
    private SelenideElement buttonPersonalOffice;


    //локатор кнопки Войти в аккаунт
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Войти в аккаунт')]")
    private SelenideElement buttonGoToAccount;

    //локатор Булки
    @FindBy(how = How.XPATH, using = ".//ul[@class='BurgerIngredients_ingredients__list__2A-mT'][1]")
    private SelenideElement buns;

    //локатор Соусы
    @FindBy(how = How.XPATH, using = ".//ul[@class='BurgerIngredients_ingredients__list__2A-mT'][2]")
    private SelenideElement sauces;

    //локатор Начинки
    @FindBy(how = How.XPATH, using = ".//ul[@class='BurgerIngredients_ingredients__list__2A-mT'][3]")
    private SelenideElement toppings;

    //локатор заголовка Булки
    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private SelenideElement bunsCard;

    //локатор заголовка Соусы
    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private SelenideElement saucesCard;

    //локатор заголовка Начинки
    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private SelenideElement toppingsCard;



    //метод клика по кнопке Личный кабинет
    public void clickButtonPersonalOffice() {
        buttonPersonalOffice.click();
    }

    //метод клика по кнопке Войти в аккаунт
    public void clickButtonGoToAccount() {
        buttonGoToAccount.click();
    }



     //метод клика по вкладке Булки
     public void clickBuns() {
            buns.click();
        }

     //метод клика по вкладке Соусы
     public void clickSauces() {
            sauces.click();
        }

        //метод клика по вкладке Начинки
        public void clickToppings() {
            toppings.click();
        }

    //получить текст с карточки Булки
    public String getTextBuns() {
        return bunsCard.getText();
    }

    //получить текст с карточки Соусы
    public String getTextSause() {
        return saucesCard.getText();
    }

    //получить текст с карточки Начинки
    public String getTextToppings() {
        return toppingsCard.getText();
    }


    }



