package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends TestBase {

    @Test
    void studentRegistrationForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ptichka@mail.ru");
        $("#genterWrapper").find(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--010").click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("#hobbiesWrapper").find(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("screen.jpg");
        $("#currentAddress").setValue("Moscow, Red square");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Ivan Ivanov"));
        $(".modal-body").shouldHave(text("ptichka@mail.ru"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("1234567890"));
        $(".modal-body").shouldHave(text("10 April,2000"));
        $(".modal-body").shouldHave(text("History"));
        $(".modal-body").shouldHave(text("Hobbies")).shouldHave(text("R"));
        $(".modal-body").shouldHave(text("screen.jpg"));
        $(".modal-body").shouldHave(text("Moscow, Red square"));
        $(".modal-body").shouldHave(text("Haryana Karnal"));
    }

    @Test
    void onlyRequiredFields() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#genterWrapper").find(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Ivan Ivanov"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567890"));
    }

    @Test
    void negativeNameFields() {
        open("/automation-practice-form");
        $("#lastName").setValue("Ivanov");
        $("#genterWrapper").find(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#submit").click();

        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void negativeLastNameFields() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#genterWrapper").find(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#submit").click();

        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void negativeGenderFields() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userNumber").setValue("1234567890");
        $("#submit").click();

        $("[value=Male]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

}
