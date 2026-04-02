package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest extends TestBase {

    @Test
    void fullForm() {
        open("/text-box");
        $("#userName").setValue("Alex Black");
        $("#userEmail").setValue("alex@black.com");
        $("#submit").click();

        $("#output").shouldHave(text("Alex Black"));
        $("#output").shouldHave(text("alex@black.com"));
    }

    @Test
    void negativeEmailForm() {
        open("/text-box");
        $("#userName").setValue("Alex Black");
        $("#userEmail").setValue("hello");
        $("#submit").click();

        $("#output").shouldNotBe(visible);
    }
}
