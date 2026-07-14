package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import utils.CloseAd;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();

    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName= $("#lastName");
    private final SelenideElement userEmail= $("#userEmail");
    private final SelenideElement genderContainer= $("#genterWrapper");
    private final SelenideElement userNumber= $("#userNumber");
    private final SelenideElement subjects= $("#subjectsInput");
    private final SelenideElement hobbies= $("#hobbiesWrapper");
    private final SelenideElement uploadPicture= $("#uploadPicture");
    private final SelenideElement currentAddress= $("#currentAddress");
    private final SelenideElement stateSelect = $("#react-select-3-input");
    private final SelenideElement citySelect = $("#react-select-4-input");
    private final SelenideElement submitButton = $("#submit");


    @Step("Open registration page /automation-practice-form")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        CloseAd.closeAd();
        return this;
    }

    @Step("Type first name \"{value}\"")
    public RegistrationPage typeFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    @Step("Type last name \"{value}\"")
    public RegistrationPage typeLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    @Step("Type user email \"{value}\"")
    public RegistrationPage typeUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    @Step("Type user number \"{value}\"")
    public RegistrationPage typeUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    @Step("Set gender \"{value}\"")
    public RegistrationPage typeGenderWrapper (String value) {
        genderContainer.$(byText(value)).click();
        return this;
    }


    @Step("Set date of birth \"{day}\" \"{month}\" \"{year}\"")
    public RegistrationPage setDateOfBirth (String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month,year);
        return this;
    }

    @Step("Set subject \"{value}\"")
    public RegistrationPage selectSubject(String value) {
        subjects.setValue(value).pressEnter();
        return this;
    }

    @Step("Set hobby \"{value}\"")
    public RegistrationPage selectHobbies(String value) {
        hobbies.$(byText(value)).click();
        return this;
    }

    @Step("Upload image \"{value}\"")
    public RegistrationPage loadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    @Step("Type user current address \"{value}\"")
    public RegistrationPage typeCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    @Step("Set state \"{value}\"")
    public RegistrationPage setState(String value) {
        stateSelect.setValue(value).pressEnter();
        return this;
    }

    @Step("Set City \"{value}\"")
    public RegistrationPage setCity(String value) {
        citySelect.setValue(value).pressEnter();
        return this;
    }

    @Step("Set state \"{state}\" and city \"{city}\"")
    public RegistrationPage setStateAndCity(String state, String city) {
        setState(state);
        setCity(city);
        return this;
    }

    @Step("Submit form")
    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }

//    public RegistrationPage checkModalTitleWindowOpen() {
//        titleSuccessfulReg.shouldHave(text("Thanks for submitting the form"));
//        return this;
//    }
//
//    public RegistrationPage checkResult(String key, String value) {
//        checkResultComponent
//                .$$( "tr")
//                .findBy(text(key))
//                .shouldHave(text(value));
//        return this;
//    }
//
//    public RegistrationPage checkNotTable () {
//        submitForm();
//        $("#modal-content").shouldNotBe(visible);
//        return this;
//    }

}
