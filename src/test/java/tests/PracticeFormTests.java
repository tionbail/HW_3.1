package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class PracticeFormTests extends TestBase {

    @Test
    void studentRegistrationForm() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").find(byText(genterWrapper)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--010").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").find(byText(hobbiesReading)).click();
        $("#uploadPicture").uploadFromClasspath(nameOfFile);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(country).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text(messageSubmit));
        $(".modal-body").shouldHave(text(userName));
        $(".modal-body").shouldHave(text(userEmail));
        $(".modal-body").shouldHave(text(genterWrapper));
        $(".modal-body").shouldHave(text(userNumber));
        $(".modal-body").shouldHave(text(dateOfBirth));
        $(".modal-body").shouldHave(text(subject));
        $(".modal-body").shouldHave(text("Hobbies")).shouldHave(text(hobbiesReading));
        $(".modal-body").shouldHave(text(nameOfFile));
        $(".modal-body").shouldHave(text(currentAddress));
        $(".modal-body").shouldHave(text(country +" "+ city));
    }

    @Test
    void onlyRequiredFields() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").find(byText(genterWrapper)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName));
        $(".table-responsive").shouldHave(text(genterWrapper));
        $(".table-responsive").shouldHave(text(userNumber));
    }

    @Test
    void negativeNameFields() {
        open("/automation-practice-form");
        $("#lastName").setValue(lastName);
        $("#genterWrapper").find(byText(genterWrapper)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void negativeLastNameFields() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#genterWrapper").find(byText(genterWrapper)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void negativeGenderFields() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $("[value=Male]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

}
