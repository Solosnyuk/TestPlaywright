package pagination2;

import baseTest.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Test;
import pages.NavigationPage;
import pages.WebFormPage;


import static org.junit.jupiter.api.Assertions.*;

@Epic("PW-Pagination-2")
public class TestValidationStart extends BaseTest {

    @Test
    @Description("Тест проверяет, что контроллер виден, содержит нужные кнопки управления и на странице есть текст ")
    @AllureId("PW-PAG-2")
    public void testValidationStartState() {
        WebFormPage webFormPage = new WebFormPage(page);
        NavigationPage navigationPage = new NavigationPage(page);

        Allure.step("Переход в раздел Web Form");
        mainPage.clickNavigation();

        Allure.step("1. Убедиться, что контроллер виден на экране");
        boolean isContainerVisible = navigationPage.loc_PaginationContainer().isVisible();

        assertTrue(isContainerVisible,
                "Контроллер пагинации должен быть виден на экране");

        Allure.step("2. Убедиться, что контроллер содержит 5 кнопок управления");
        int buttonCount = navigationPage.loc_AllPaginationButtons().count();

        assertEquals(5, buttonCount, "Контроллер должен содержать ровно 5 кнопок управления");

        Allure.step("2.a. Previous – disabled, visible");
        boolean previousVisible = navigationPage.loc_PreviousButton().isVisible();
        String previousClass = navigationPage.loc_PreviousButton().getAttribute("class");

        assertTrue(previousVisible, "Кнопка Previous должна быть видимой");
        assertTrue(previousClass.contains("disabled"), "Кнопка Previous должна быть disabled");

        Allure.step("2.b. 1 – enabled, highlighted, visible");
        boolean pageOneVisible = navigationPage.loc_PageOneButton().isVisible();
        String pageOneClass = navigationPage.loc_PageOneButton().getAttribute("class");

        assertTrue(pageOneVisible, "Кнопка 1 должна быть видимой");
        assertFalse(pageOneClass.contains("disabled"), "Кнопка 1 должна быть enabled");
        assertTrue(pageOneClass.contains("active"), "Кнопка 1 должна быть highlighted");

        Allure.step("2.c. 2 – enabled, visible");
        boolean pageTwoVisible = navigationPage.loc_PageTwoButton().isVisible();
        String pageTwoClass = navigationPage.loc_PageTwoButton().getAttribute("class");

        assertTrue(pageTwoVisible, "Кнопка 2 должна быть видимой");
        assertFalse(pageTwoClass.contains("disabled"), "Кнопка 2 должна быть enabled");

        Allure.step("2.d. 3 – enabled, visible");
        boolean pageThreeVisible = navigationPage.loc_PageThreeButton().isVisible();
        String pageThreeClass = navigationPage.loc_PageThreeButton().getAttribute("class");

        assertTrue(pageThreeVisible, "Кнопка 3 должна быть видимой");
        assertFalse(pageThreeClass.contains("disabled"), "Кнопка 3 должна быть enabled");

        Allure.step("2.e. Next – enabled, visible");
        boolean nextVisible = navigationPage.loc_NextButton().isVisible();
        String nextClass = navigationPage.loc_NextButton().getAttribute("class");

        assertTrue(nextVisible, "Кнопка Next должна быть видимой");
        assertFalse(nextClass.contains("disabled"), "Кнопка Next должна быть enabled");

        Allure.step("3. Убедиться, что мы находимся на правильной странице");
        String currentUrl = page.url();
        boolean urlValid = currentUrl.contains("navigation") || currentUrl.contains("page=1") || currentUrl.contains("#");

        assertTrue(urlValid,
                "URL должен указывать на первую страницу пагинации. Текущий URL: " + currentUrl);
    }
}