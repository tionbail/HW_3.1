package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.TestData.*;

public class TextBoxTest extends TestBase {

    @Test
    void fullForm() {
        open("/text-box");
        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#submit").click();

        $("#output").shouldHave(text(userName));
        $("#output").shouldHave(text(userEmail));
    }

    @Test
    void negativeEmailForm() {
        open("/text-box");
        $("#userName").setValue(userName);
        $("#userEmail").setValue("hello");
        $("#submit").click();

        $("#output").shouldNotBe(visible);
    }
}
