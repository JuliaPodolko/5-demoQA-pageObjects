package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponents;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    CalendarComponents calendar = new CalendarComponents();
    //locators
    SelenideElement titleForm = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            eMailInput = $("#useEmail"),
            userNumberInput = $("#userNumber"),
            userSubjectInput = $("#subjectsInput"),
            genderInput = $("#genterWrapper"),
            hobbiesInput = $("#hobbiesWrapper"),
            addressInput = $("#currentAddress"),
            countryInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            filePathInput = $("#uploadPicture"),
            submitClick = $("#submit"),
            birthDateInput = $("#dateOfBirthInput"),
            tableTitle = $(".table-responsive"),
            finalMessage = $("#example-modal-sizes-title-lg");

    //actions
    public RegistrationFormPage openPage(String value) {
        open (value);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        titleForm.shouldHave(text("Student Registration Form")); // Заголовок формы
        return this;
    }
    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setEmail(String value) {
        eMailInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage setUserSubject(String value) {
        userSubjectInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationFormPage setHobby(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setCountry(String value) {
        countryInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationFormPage setCity(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationFormPage setFilePath(String value) {
        filePathInput.uploadFromClasspath(value);
        return this;
    }
    public RegistrationFormPage setSubmit () {
        submitClick.click();
        return this;
    }
    public RegistrationFormPage setBirthDate (String day, String month, String year) {
        birthDateInput.click();
        calendar.setDate(day, month, year);
        return this;
    }
    public RegistrationFormPage checkResult(String key, String value) {
        tableTitle.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
    public RegistrationFormPage checkFinal(String value) {
        finalMessage.shouldHave(text(value));
        return this;
    }
}
