package tests;

import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class PracticeFormTests extends TestBase {


    @Test
    void studentRegistrationForm() {
        step("Open form", () -> {
            registrationPage.openPage();
        });
        step("Fill form", () -> {
            registrationPage.typeFirstName(testData.firstName)
                    .typeLastName(testData.lastName)
                    .typeUserEmail(testData.userEmail)
                    .typeUserNumber(testData.userNumber)
                    .typeGenderWrapper(testData.genterWrapper)
                    .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                    .selectSubject(testData.subject)
                    .selectHobbies(testData.hobbiesReading)
                    .loadPicture(testData.nameOfFile)
                    .typeCurrentAddress(testData.currentAddress)
                    .setStateAndCity(testData.state, testData.city);
        });
        step("Submit form", () -> {
            registrationPage.submitForm();
        });

        step("Verify results", () -> {
            finalTableComponent.checkModalTitleWindowOpen()
                    .checkResult("Student Name", testData.userName)
                    .checkResult("Student Email", testData.userEmail)
                    .checkResult("Gender", testData.genterWrapper)
                    .checkResult("Mobile", testData.userNumber)
                    .checkResult("Date of Birth", testData.dateOfBirth)
                    .checkResult("Subjects", testData.subject)
                    .checkResult("Hobbies", testData.hobbiesReading)
                    .checkResult("Picture", testData.nameOfFile)
                    .checkResult("Address", testData.currentAddress)
                    .checkResult("State and City", testData.state + " " + testData.city);
        });

    }

    @Test
    void onlyRequiredFields() {
        step("Open form", () -> {
            registrationPage.openPage();
        });
        step("Fill form", () -> {
            registrationPage.typeFirstName(testData.firstName)
                    .typeLastName(testData.lastName)
                    .typeGenderWrapper(testData.genterWrapper)
                    .typeUserNumber(testData.userNumber)
                    .submitForm();
        });

        step("Verify results", () -> {
            finalTableComponent.checkModalTitleWindowOpen()
                    .checkResult("Student Name", testData.userName)
                    .checkResult("Gender", testData.genterWrapper)
                    .checkResult("Mobile", testData.userNumber);
        });
    }

    @Test
    void negativeNameFields() {
        step("Open form", () -> {
            registrationPage.openPage();
        });
        step("Fill form", () -> {
            registrationPage.typeLastName(testData.lastName)
                    .typeGenderWrapper(testData.genterWrapper)
                    .typeUserNumber(testData.userNumber)
                    .submitForm();
        });
        step("Verify results", () -> {
            finalTableComponent.checkNotTable();
        });

    }

    @Test
    void negativeLastNameFields() {
        step("Open form", () -> {
            registrationPage.openPage();
        });
        step("Fill form", () -> {
            registrationPage.typeFirstName(testData.firstName)
                    .typeGenderWrapper(testData.genterWrapper)
                    .typeUserNumber(testData.userNumber)
                    .submitForm();
        });
        step("Verify results", () -> {
            finalTableComponent.checkNotTable();
        });
    }

    @Test
    void negativeGenderFields() {
        step("Open form", () -> {
            registrationPage.openPage();
        });
        step("Fill form", () -> {
            registrationPage.typeFirstName(testData.firstName)
                    .typeLastName(testData.lastName)
                    .typeUserNumber(testData.userNumber)
                    .submitForm();
        });
        step("Verify results", () -> {
            finalTableComponent.checkNotTable();
        });
    }

}
