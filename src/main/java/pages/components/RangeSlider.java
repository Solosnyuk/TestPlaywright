package pages.components;
import com.microsoft.playwright.Locator;


public class RangeSlider {
    private final Locator sliderLocator;

    public RangeSlider(Locator sliderLocator) {
        this.sliderLocator = sliderLocator;
    }

    // Получить текущее значение
    public String getValue() {
        return sliderLocator.getAttribute("value");
    }

    public int getValueAsInt() {
        return Integer.parseInt(getValue());
    }

    // Установить значение через JavaScript
    public void setValue(int value) {
        sliderLocator.evaluate("(element, value) => { element.value = value; element.dispatchEvent(new Event('input')); element.dispatchEvent(new Event('change')); }", value);
    }

    // Установить значение через fill (если поддерживается)
    public void setValueViaFill(int value) {
        sliderLocator.fill(String.valueOf(value));
    }

    // Получить минимальное значение
    public String getMin() {
        return sliderLocator.getAttribute("min");
    }

    // Получить максимальное значение
    public String getMax() {
        return sliderLocator.getAttribute("max");
    }

    // Получить шаг
    public String getStep() {
        return sliderLocator.getAttribute("step");
    }

    // Проверить видимость
    public boolean isVisible() {
        return sliderLocator.isVisible();
    }

    // Проверить активность
    public boolean isEnabled() {
        return !sliderLocator.isDisabled();
    }

    // Получить тип инпута
    public String getType() {
        return sliderLocator.getAttribute("type");
    }
}
