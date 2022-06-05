package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class RegistrationFormWithFakerTests {

    Faker faker = new Faker();
    Faker fakerRu = new Faker(new Locale("ru"));

    //Test's data
    String firstName = fakerRu.name().firstName(),
            lastName = fakerRu.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.number().digits(10),
            currentAddresses = fakerRu.address().fullAddress(),
            urlForm = "/automation-practice-form",
            userSubject = "Maths",
            country = "Rajasthan",
            city = "Jaipur",
            gender = "Female",
            hobby = "Sports",
            filePath = "1.jpg",
            title = "Student Registration Form",
            day = "30",
            month = "September",
            year = "2008";
    //Expected data
    String expectedFullName = format("%s %s", firstName, lastName);

    @BeforeAll
    static void setUP () {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest () {

        open (urlForm);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $(".practice-form-wrapper").shouldHave(text(title)); // Заголовок формы
        $("#firstName").setValue(firstName); // Name
        $("#lastName").setValue(lastName); // Фамилия
        $("#userEmail").setValue(userEmail); // Электронная почта
        $("#userNumber").setValue(userNumber); // Номер телефона
        $("#genterWrapper").$(byText(gender)).click(); // Пол
        $("#subjectsInput").setValue(userSubject).pressEnter(); // Предметы
        $("#hobbiesWrapper").$(byText(hobby)).click(); // Хобби
        $("#currentAddress").setValue(currentAddresses); // Адрес
        $("#react-select-3-input").setValue(country).pressEnter(); // Страна
        $("#react-select-4-input").setValue(city).pressEnter(); // Город
        $("#uploadPicture").uploadFromClasspath(filePath); //Загрузка картинки
        // Дата рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(react-datepicker__day--outside-month)").click();

        $("#submit").click();

        //asserts
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name"))
                .parent().shouldHave(text(expectedFullName));
        $(".table-responsive").shouldHave(
                text(firstName),
                text(lastName),
                text(userEmail),
                text(userNumber),
                text(userSubject),
                text(userSubject),
                text(currentAddresses),
                text(country),
                text(city),
                text("30 September,2008"),
                text(filePath));
    }

}
