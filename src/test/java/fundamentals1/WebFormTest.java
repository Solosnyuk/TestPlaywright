package fundamentals1;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.WebFormPage;
import utils.TestDataGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebFormTest extends BaseTest {
    String testText = TestDataGenerator.generateTextUpTo(120);
    String testPassword = TestDataGenerator.generatePasswordUpTo(120);

    @Test
    public void testFormSubmissionWithTextAndPassword() {
        WebFormPage webFormPage = new WebFormPage(page);

        mainPage.clickWebForm();

        webFormPage.loc_TextInput().fill(testText);
        webFormPage.loc_Password().fill(testPassword);
        webFormPage.loc_Submit().click();

        assertTrue(page.locator("text=Form submitted").isVisible());
    }

}
