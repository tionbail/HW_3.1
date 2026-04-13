package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static tests.TestData.*;

public class TextBoxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fullForm() {


        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .submitForm();

        textBoxPage.checkField("name", userName)
                .checkField("email", userEmail);
    }

    @Test
    void negativeEmailForm() {
        textBoxPage.openPage();
        textBoxPage.typeUserName(userName);
        textBoxPage.typeUserEmail(inCorrectEmail);
        textBoxPage.submitForm();

        textBoxPage.invisibleResult();
    }
}
