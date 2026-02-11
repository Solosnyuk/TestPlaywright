package fundamentals1;

import baseTest.BaseTest;
import generate.ColorGenerate;
import generate.DateGenerate;
import io.qameta.allure.*;
import jdk.jfr.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WebFormPage;

import static org.testng.AssertJUnit.assertTrue;
@Epic("PW-Fundamentals-1")
public class TestColorAndDateFormSubmission extends BaseTest {
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

            Allure.step("3. Отправка формы");
            webFormPage.loc_Submit().click();

            assertTrue(page.locator("text=Form submitted").isVisible());
    }
}
