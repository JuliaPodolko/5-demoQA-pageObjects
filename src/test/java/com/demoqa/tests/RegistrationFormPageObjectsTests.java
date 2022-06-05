package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class RegistrationFormPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
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
        registrationFormPage.openPage(urlForm)
                .setFirstName(firstName) // Name
                .setLastName(lastName) // Фамилия
                .setEmail(userEmail) // Электронная почта
                .setGender(gender) // Пол
                .setUserNumber(userNumber) // Номер телефона
                .setUserSubject(userSubject) // Предметы
                .setHobby(hobby) // Хобби
                .setAddress(currentAddresses) // Адрес
                .setCountry(country) // Страна
                .setCity(city) // Город
                .setFilePath(filePath) //Загрузка картинки
                .setSubmit() // Клик по кнопке
                .setBirthDate(day, month, year); // Дата рождения



        //asserts
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
      //  $(".table-responsive").$(byText("Student Name"))
       //         .parent().shouldHave(text(expectedFullName));

        registrationFormPage.checkResult("Student Name", expectedFullName);
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
