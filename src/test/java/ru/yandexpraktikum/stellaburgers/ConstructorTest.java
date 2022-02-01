package ru.yandexpraktikum.stellaburgers;

import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import ru.yandexpraktikum.stellaburgers.pageobjects.HomePage;

import static com.codeborne.selenide.Selenide.open;

//Раздел «Конструктор»
public class ConstructorTest {


    @Test
    @Description("Проверь, что работают переходы к разделам: «Булки»")
    public void checkTransitionToBuns() {

        HomePage homePage = open("https://stellarburgers.nomoreparties.site/", HomePage.class);

        homePage.clickBuns();

        String expeсtedText = "Булки";
        String actualText = homePage.getTextBuns();
        Assert.assertEquals ("Transition to buns is not made", expeсtedText, actualText);
    }


    @Test
    @Description("Проверь, что работают переходы к разделам: «Соусы»")
    public void checkTransitionToSauce() {

        HomePage homePage = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        homePage.clickSauces();

        String expeсtedText = "Соусы";
        String actualText = homePage.getTextSause();
        Assert.assertEquals ("Transition to sauce is not made", expeсtedText, actualText);

    }


    @Test
    @Description("Проверь, что работают переходы к разделам: «Начинки»")
    public void checkTransitionToToppings() {

        HomePage homePage = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        homePage.clickToppings();

        String expeсtedText = "Начинки";
        String actualText = homePage.getTextToppings();
        Assert.assertEquals ("Transition to toppings is not made", expeсtedText, actualText);
    }

}
