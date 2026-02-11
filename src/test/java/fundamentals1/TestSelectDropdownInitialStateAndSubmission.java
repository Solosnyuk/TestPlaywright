package fundamentals1;

import baseTest.BaseTest;
import com.microsoft.playwright.Locator;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import jdk.jfr.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WebFormPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

    @Epic("PW-Fundamentals-1")
    public class TestSelectDropdownInitialStateAndSubmission extends BaseTest {
        @Test
        @DisplayName("Проверка выпадающего списка my-select")
        @Description("Тест проверяет правильность выпадающего списка my-select, " +
                "его свойств и отправки его параметров в форме")
        @AllureId("PW-FUND-4")
        public void testSelectDropdownInitialStateAndSubmission() {
            WebFormPage webFormPage = new WebFormPage(page);

            Allure.step("Переход в раздел Web Form");
            mainPage.clickWebForm();

            Allure.step("1. Получение dropdown через Page Object метод");
            Locator dropdown = webFormPage.loc_Dropdown();

            Allure.step("2. Проверка атрибута name у dropdown");
            String dropdownName = dropdown.getAttribute("name");
            assertThat(dropdownName)
                    .isEqualTo("my-select");

            Allure.step("3. Проверка количества option элементов в dropdown");
            Locator dropdownOptions = dropdown.locator("option");
            int optionsCount = dropdownOptions.count();

            assertThat(optionsCount)
                    .isEqualTo(4);

            String firstOption = dropdownOptions.nth(0).textContent().trim();
            assertThat(firstOption)
                    .isEqualTo("Open this select menu");

            String secondOption = dropdownOptions.nth(1).textContent().trim();
            assertThat(secondOption)
                    .isEqualTo("One");

            String secondOptionValue = dropdownOptions.nth(1).getAttribute("value");
            assertThat(secondOptionValue)
                    .isEqualTo("1");

            Allure.step("4. Проверка выбранной по умолчанию опции");
            boolean isFirstOptionSelected = (Boolean) dropdownOptions.nth(0)
                    .evaluate("el => el.selected");
            assertThat(isFirstOptionSelected)
                    .isTrue();
        }
}
