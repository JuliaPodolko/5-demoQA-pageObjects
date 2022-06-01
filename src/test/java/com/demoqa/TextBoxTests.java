package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void setUP () {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browserVersion = "98.0.4758.48";
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

        $("#firstName").setValue(firstName); // Name
        $("#lastName").setValue(lastName); // Фамилия
        $("#userEmail").setValue(userEmail); // Электронная почта
        $("#userNumber").setValue(userNumber); // Номер телефона
        $("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(2) > label").click(); // Пол
        $x("//input[@id='subjectsInput']").setValue(userSubject).pressEnter(); // Предметы
        $("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label").click(); // Хобби
        $("#currentAddress").setValue(currentAddresses); // Адрес
        $("#react-select-3-input").setValue(country).pressEnter(); // Страна
        $("#react-select-4-input").setValue(city).pressEnter(); // Город

      //  $("#uploadPicture").uploadFromClasspath("rsc/123.jpg");
       // $("#uploadPicture").uploadFromClasspath("rsc/123.jpg");
      //  $("#uploadPicture").uploadFromClasspath("src/test/resources/11.txt");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--008").click();

        $("#submit").click();

        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(userEmail), text(userNumber), text(userSubject), text(userSubject), text(currentAddresses), text(country), text(city), text("08 September,2008"));
    }
}
