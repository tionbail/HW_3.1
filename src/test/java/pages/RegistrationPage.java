package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.TestData.*;
import static tests.TestData.currentAddress;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();

    private SelenideElement firstName = $("#firstName");
    private SelenideElement lastName= $("#lastName");
    private SelenideElement userEmail= $("#userEmail");
    private SelenideElement genderContainer= $("#genterWrapper");
    private SelenideElement userNumber= $("#userNumber");
    private SelenideElement subjects= $("#subjectsInput");
    private SelenideElement hobbies= $("#hobbiesWrapper");
    private SelenideElement uploadPicture= $("#uploadPicture");
    private SelenideElement currentAddress= $("#currentAddress");
    private SelenideElement stateSelect = $("#react-select-3-input");
    private SelenideElement citySelect = $("#react-select-4-input");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement titleSuccessfulReg = $("#example-modal-sizes-title-lg");
    private SelenideElement checkResultComponent = $(".modal-body");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public RegistrationPage typeUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public RegistrationPage typeUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationPage typeGenderWrapper (String value) {
        genderContainer.$(byText(value)).click();
        return this;
    }


    public RegistrationPage setDateOfBirth (String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month,year);
        return this;
    }

    public RegistrationPage selectSubject(String value) {
        subjects.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage selectHobbies(String value) {
        hobbies.find(byText(value)).click();
        return this;
    }

    public RegistrationPage loadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage typeCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateSelect.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String value) {
        citySelect.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        setState(state);
        setCity(city);
        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkModalTitleWindowOpen() {
        titleSuccessfulReg.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        checkResultComponent
                .$$( "tr")
                .findBy(text(key))
                .shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkNotTable () {
        submitForm();
        $("#modal-content").shouldNotBe(visible);
        return this;
    }

}
