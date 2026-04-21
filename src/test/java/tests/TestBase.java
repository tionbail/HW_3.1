package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import pages.components.FinalTableComponent;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    FinalTableComponent finalTableComponent = new FinalTableComponent();
    TestData testData  = new TestData();

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        //Configuration.browserVersion = "146.0";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }

}
