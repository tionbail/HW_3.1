package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;

public class PracticeFormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void studentRegistrationForm() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .typeUserNumber(userNumber)
                .typeGenderWrapper(genterWrapper)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .selectSubject(subject)
                .selectHobbies(hobbiesReading)
                .loadPicture(nameOfFile)
                .typeCurrentAddress(currentAddress)
                .setStateAndCity(country, city)
                .submitForm()

                .checkModalTitleWindowOpen()
                .checkResult("Student Name", userName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", genterWrapper)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dateOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbiesReading)
                .checkResult("Picture", nameOfFile)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", country + " " + city);

    }

    @Test
    void onlyRequiredFields() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeGenderWrapper(genterWrapper)
                .typeUserNumber(userNumber)
                .submitForm()

                .checkModalTitleWindowOpen()
                .checkResult("Student Name", userName)
                .checkResult("Gender", genterWrapper)
                .checkResult("Mobile", userNumber);
    }

    @Test
    void negativeNameFields() {
        registrationPage.openPage()
                .typeLastName(lastName)
                .typeGenderWrapper(genterWrapper)
                .typeUserNumber(userNumber)
                .submitForm()

                .checkNotTable();

    }

    @Test
    void negativeLastNameFields() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeGenderWrapper(genterWrapper)
                .typeUserNumber(userNumber)
                .submitForm()

                .checkNotTable();
    }

    @Test
    void negativeGenderFields() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserNumber(userNumber)
                .submitForm()

                .checkNotTable();
    }

}
