package fundamentals1;

import baseTest.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import jdk.jfr.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WebFormPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("PW-Fundamentals-1")
public class TestDisabledAndReadonlyElements extends BaseTest {
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
