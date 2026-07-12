package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.RegistrationPage;
import pages.components.FinalTableComponent;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    FinalTableComponent finalTableComponent = new FinalTableComponent();
    TestData testData  = new TestData();


    @BeforeAll
    static void beforeAll() {
        //Configuration.browser = "chrome";
        Configuration.browserVersion = "128.0";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = "https://user1:1234@ru.selenoid.autotests.cloud/wd/hub";
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }

}
