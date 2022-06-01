package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void setUP () {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest () {
        String firstName = "Julia";
        String lastName = "Podolko";
        String userEmail = "Julia@yandex.ru";
        String userNumber = "9123456789";
        String userSubject = "Maths";
        String currentAddresses = "1st Street, 25";
        String country = "Rajasthan";
        String city = "Jaipur";


        open ("/automation-practice-form");

        $("#firstName").setValue(firstName); // &#x418;&#x43C;&#x44F;
        $("#lastName").setValue(lastName); // Фамилия
        $("#userEmail").setValue(userEmail); // Электронная почта
        $("#userNumber").setValue(userNumber); // Номер телефона
        $("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(2) > label").click(); // Пол
        $x("//input[@id='subjectsInput']").setValue(userSubject).pressEnter(); // Предметы
        $("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label").click(); // Хобби
        $("#currentAddress").setValue(currentAddresses); // Адрес
        $("#react-select-3-input").setValue(country).pressEnter(); // Страна
        $("#react-select-4-input").setValue(city).pressEnter(); // Город
        $("#uploadPicture").uploadFromClasspath("src/test/resources/123.jpg");



        $("#submit").click();

        $("#").shouldHave(text(firstName), text(lastName), text(userEmail));
    }
}
