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
        String subjectsInput = "Тема";
        String userNumber = "9123456789";
        String userSubject = "Maths";


        open ("/automation-practice-form");

        $("#firstName").setValue(firstName); // Имя
        $("#lastName").setValue(lastName); // Фамилия
        $("#userEmail").setValue(userEmail); // Электронная почта
      //  $("#subjectsInput").setValue(subjectsInput); // Предметы
        $("#userNumber").setValue(userNumber); // Номер телефона
        $("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(2) > label").click(); // Пол
        $x("//input[@id='subjectsInput']").setValue(userSubject).pressEnter(); // Предметы
        $("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label").click(); // Хобби


        $("#submit").click();

        $("#").shouldHave(text(firstName), text(lastName), text(userEmail));
    }
}
