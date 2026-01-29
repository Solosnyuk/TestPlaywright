package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.Generic;

public class WebFormPage {
    private Page page;

    public WebFormPage(Page page) {
        this.page = page;
    }

    private Generic generic = new Generic("");

    private String textInput = "my-text-id";
    private String password = "input[name='my-password']";

    private String dropdownSelect = "class=\"form-select\"";
    private String dropdownValueOne = "1";  // Только значение
    private String dropdownValueTwo = "2";
    private String dropdownValueThree = "3";

    private String dropDownDataList = "name=\"my-datalist\"";
    private String dropdownDatalistValueSF = "San Francisco";
    private String dropdownDatalistValueNY = "New York";
    private String dropdownDatalistValueS = "Seattle";
    private String dropdownDatalistValueLA = "Los Angeles";
    private String dropdownDatalistValueC = "Chicago";

    private String fileInput = "name=\"my-file\"";

    private String disabledInput = "input[name='my-disabled']";
    private String readonlyInput = "input[name='my-readonly']";

    private String colorInput = "input[name='my-colors']";
    private String dateInput = "input[name='my-date']";

    private String checkedCheckbox = "id=\"my-check-1\"";
    private String defaultCheckbox = "id=\"my-check-2\"";

    private String checkedRadio = "id=\"my-radio-1\"";
    private String defaultRadio = "id=\"my-radio-2\"";

    private String submit = "Submit";


    public Locator loc_TextInput() {
        return generic.getById(textInput);
    }

    public Locator loc_Password() {
        return page.locator(password);
    }

    public Locator loc_Dropdown() {
        return generic.getByLocator(dropdownSelect);
    }

    public void selectDropdownOptionOne() {
        generic.selectByValue(loc_Dropdown(), dropdownValueOne);
    }

    public void selectDropdownOptionTwo() {
        generic.selectByValue(loc_Dropdown(), dropdownValueTwo);
    }

    public void selectDropdownOptionThree() {
        generic.selectByValue(loc_Dropdown(), dropdownValueThree);
    }

    public Locator loc_DataListInput() {
        return generic.getByLocator(dropDownDataList);
    }

    public Locator loc_FileInput() {
        return generic.getByLocator(fileInput);
    }

    public Locator loc_CheckedCheckbox() {
        return generic.getByLocator(checkedCheckbox);
    }

    public Locator loc_DefaultCheckbox() {
        return generic.getByLocator(defaultCheckbox);
    }

    public Locator loc_CheckedRadio() {
        return generic.getByLocator(checkedRadio);
    }

    public Locator loc_DefaultRadio() {
        return generic.getByLocator(defaultRadio);
    }

    public Locator loc_Submit() {
        return generic.getByText(submit);
    }

    public Locator loc_ColorInput() {
        return generic.getByLocator(colorInput);
    }

    public void setColorWithJavaScript(String hexColor) {
        loc_ColorInput().evaluate("(element, color) => { element.value = color; }", hexColor);
    }

    public Locator loc_DateInput() {
        return generic.getByLocator(dateInput);
    }

    public void setDate(String date) {
        generic.fill(loc_DateInput(), date);
    }


    public void fillDataList(String value) {
        generic.fill(loc_DataListInput(), value);
    }

    public Locator loc_DisabledInput() {
        return generic.getByLocator(disabledInput);
    }

    public Locator loc_ReadonlyInput() {
        return generic.getByLocator(readonlyInput);
    }

    public void selectDataListSF() {
        fillDataList(dropdownDatalistValueSF);
    }

    public void selectDataListNY() {
        fillDataList(dropdownDatalistValueNY);
    }

    public void selectDataListSeattle() {
        fillDataList(dropdownDatalistValueS);
    }

    public void selectDataListLA() {
        fillDataList(dropdownDatalistValueLA);
    }

    public void selectDataListChicago() {
        fillDataList(dropdownDatalistValueC);
    }

    public String getDataListValue() {
        return loc_DataListInput().inputValue();
    }
}
