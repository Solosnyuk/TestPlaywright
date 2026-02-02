package fundamentals1;

import baseTest.BaseTest;
import io.qameta.allure.Allure;
import com.microsoft.playwright.Locator;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WebFormPage;
import pages.components.RangeSlider;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Epic("PW-Fundamentals-1")
public class TestRangeSliderInitialStateAndSubmission extends BaseTest {
    @Test
    @DisplayName("Проверка ползунка my-range")
    @Description("Тест проверяет правильность начального состояния ползунка my-range, " +
            "его свойств и отправки его параметров в форме")
    @AllureId("PW-FUND-5")
    public void testRangeSliderInitialStateAndSubmission() {
        WebFormPage webFormPage = new WebFormPage(page);

        Allure.step("Переход в раздел Web Form");
        mainPage.clickWebForm();

        Allure.step("1. Обнаружить ползунок my-range на странице и убедиться, что он является видимым");
        RangeSlider rangeSlider = webFormPage.getRangeSlider();
        Locator sliderLocator = webFormPage.loc_RangeSlider();

        assertThat(rangeSlider.isVisible())
                .isTrue();

        Allure.step("2. Проверить минимальное значение, максимальное значение и шаг");

        String minValue = rangeSlider.getMin();
        assertThat(minValue)
                .isEqualTo("0");

        String maxValue = rangeSlider.getMax();
        assertThat(maxValue)
                .isEqualTo("10");

        String stepValue = rangeSlider.getStep();
        assertThat(stepValue)
                .isEqualTo("1");

        String initialValue = rangeSlider.getValue();

        Allure.step("3. С помощью javascript evaluate выставить value = 25");
        rangeSlider.setValue(25);

        Allure.step("4. Подготовка к перехвату запроса");
        java.util.List<String> interceptedRequests = new java.util.ArrayList<>();

        page.onRequest(request -> {
            if (request.url().contains("/submit") || request.url().contains("/api")) {
                String postData = request.postData();
                interceptedRequests.add(postData);
            }
        });

        page.route("**/*", route -> {
            if (route.request().method().equals("POST")) {
                String postData = route.request().postData();
                interceptedRequests.add(postData);
            }
            route.resume();
        });

        Allure.step("5. Отправить форму кнопкой Submit");
        webFormPage.loc_Submit().click();

        Allure.step("6. Проверка перехваченного запроса");
        boolean foundRangeValue = false;
        String rangeValueInRequest = null;

        for (String requestData : interceptedRequests) {
            if (requestData != null && requestData.contains("my-range")) {
                foundRangeValue = true;

                String[] pairs = requestData.split("&");
                for (String pair : pairs) {
                    if (pair.startsWith("my-range=")) {
                        rangeValueInRequest = pair.substring("my-range=".length());
                        break;
                    }
                }
                break;
            }
        }

        assertThat(foundRangeValue)
                .isTrue();

        Allure.step("7. Проверка что значение поля my-range = 10");
        assertThat(rangeValueInRequest)
                .isEqualTo("10");

        Allure.step("8. Проверка статус кода ответа 200");
        page.onResponse(response -> {
            if (response.url().contains("/submit") || response.url().contains("/api")) {
                assertThat(response.status())
                        .as("Статус код ответа должен быть 200")
                        .isEqualTo(200);
            }
        });
    }
}
