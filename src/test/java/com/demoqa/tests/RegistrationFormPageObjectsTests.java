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
            title = "Thanks for submitting the form",
            day = "30",
            month = "September",
            year = "2008";
    //Expected data
    String expectedFullName = format("%s %s", firstName, lastName),
            expectedDate = format("%s %s,%s", day, month, year),
            expectedLocation = format("%s %s", country, city);

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
        registrationFormPage.checkResult("Student Name", expectedFullName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", expectedDate)
                .checkResult("Subjects", userSubject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", filePath)
                .checkResult("Address", currentAddresses)
                .checkResult("State and City", expectedLocation);
        registrationFormPage.checkFinal(title);
    }

}
