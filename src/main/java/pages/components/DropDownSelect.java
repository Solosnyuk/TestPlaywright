package pages.components;

import com.microsoft.playwright.Locator;

public class DropDownSelect {
    private final Locator dropdown;

    public DropDownSelect(Locator dropdown) {
        this.dropdown = dropdown;
    }

    public boolean isVisible() {
        return dropdown.isVisible();
    }

    public String getSelectedOptionText() {
        return (String) dropdown.evaluate("element => element.options[element.selectedIndex].text");
    }

    public boolean hasFirstOptionSelectedAttribute() {
        return (Boolean) dropdown.evaluate("""
            element => {
                return element.options[0].hasAttribute('selected');
            }
        """);
    }

    public int getOptionsCount() {
        return (Integer) dropdown.evaluate("""
            element => {
                return element.options.length;
            }
        """);
    }

    public java.util.List<String> getAllOptions() {
        return (java.util.List<String>) dropdown.evaluate("""
            element => {
                const options = [];
                for (let i = 0; i < element.options.length; i++) {
                    options.push(element.options[i].text);
                }
                return options;
            }
        """);
    }

}
