package fundamentals1;

import baseTest.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WebFormPage;
import utils.TestDataGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("PW-Fundamentals-1")
public class WebFormTest extends BaseTest {
    String testText = TestDataGenerator.generateTextUpTo(120);
    String testPassword = TestDataGenerator.generatePasswordUpTo(120);

    @Test
    @DisplayName("Проверка отправки формы с текстом и паролем")
    @Description("Тест проверяет, что данные из полей my-text и my-password правильно передаются при отправке формы")
    @AllureId("PW-FUND-1")
    public void testFormSubmissionWithTextAndPassword() {
        WebFormPage webFormPage = new WebFormPage(page);

        Allure.step("Переход в раздел Web Form");
        mainPage.clickWebForm();

        Allure.step("Заполнение полей формы");
        webFormPage.loc_TextInput().fill(testText);
        webFormPage.loc_Password().fill(testPassword);

        Allure.step("Отправка формы");
        webFormPage.loc_Submit().click();

        assertTrue(page.locator("text=Form submitted").isVisible());
    }

}
