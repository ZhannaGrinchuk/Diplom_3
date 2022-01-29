package com.example;

import example.HomePage;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

//Раздел «Конструктор»
public class ConstructorTest {


    //Проверь, что работают переходы к разделам: «Булки»
    @Test
    public void checkTransitionToBuns() {

        HomePage homePage = open("https://stellarburgers.nomoreparties.site/", HomePage.class);

        homePage.clickBuns();

        String expeсtedText = "Булки";
        String actualText = homePage.getTextBuns();
        Assert.assertEquals (expeсtedText, actualText);
        sleep(1000);
    }


    //Проверь, что работают переходы к разделам: «Соусы»
    @Test
    public void checkTransitionToSauce() {

        HomePage homePage = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        homePage.clickSauces();
        sleep(1000);

        String expeсtedText = "Соусы";
        String actualText = homePage.getTextSause();
        Assert.assertEquals (expeсtedText, actualText);

    }


    //Проверь, что работают переходы к разделам: «Начинки»
    @Test
    public void checkTransitionToToppings() {

        HomePage homePage = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        homePage.clickToppings();

        String expeсtedText = "Начинки";
        String actualText = homePage.getTextToppings();
        Assert.assertEquals (expeсtedText, actualText);
        sleep(1000);
    }


}
