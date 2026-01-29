package fundamentals1;

import baseTest.BaseTest;
import generate.ColorGenerate;
import generate.DateGenerate;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WebFormPage;
import generate.TextGenerator;
import generate.PasswordGenerate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("PW-Fundamentals-1")
public class WebFormTest extends BaseTest {
    String testText = TextGenerator.generateTextUpTo(120);
    String testPassword = PasswordGenerate.generatePasswordUpTo(120);

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

    @Test
    @DisplayName("Проверка отправки формы с цветом и датой")
    @Description("Тест проверяет, что данные из полей my-colors и my-date правильно передаются при отправке формы")
    @AllureId("PW-FUND-2")
    public void testColorAndDateFormSubmission() {
        WebFormPage webFormPage = new WebFormPage(page);

        Allure.step("Переход в раздел Web Form");
        mainPage.clickWebForm();

        Allure.step("1. Установка значения цвета через JavaScript");
        String selectedColor = ColorGenerate.selectRandomColor();

        Allure.step("2. Выбор случайной даты из текущего месяца");
        String selectedDate = DateGenerate.generateRandomDateFromCurrentMonth();
        webFormPage.setDate(selectedDate);

        Allure.step("Отправка формы");
        webFormPage.loc_Submit().click();

        assertTrue(page.locator("text=Form submitted").isVisible());
    }

    @Test
    @DisplayName("Проверка  невозможности редактирования элементов my-disabled и my-readonly")
    @Description("Тест проверяет, невозможность редактирования элементов my-disabled и my-readonly")
    @AllureId("PW-FUND-3")
    public void  testDisabledAndReadonlyElements() {
        WebFormPage webFormPage = new WebFormPage(page);

        Allure.step("Переход в раздел Web Form");
        mainPage.clickWebForm();

        Allure.step("1. Проверка элемента my-disabled на факт того, что элемент действительно в выключенном состоянии");
        assertFalse(webFormPage.loc_DisabledInput().isEnabled(),
                "Элемент my-disabled должен быть disabled");

        Allure.step("2. Проверка элемента my-readonly на факт того, что элемент readonly");
        assertTrue(webFormPage.loc_ReadonlyInput().getAttribute("readonly") != null,
                "Элемент my-readonly должен иметь атрибут 'readonly'");
    }
}