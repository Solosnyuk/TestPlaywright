package pages;

import com.microsoft.playwright.Locator;
import utils.Generic;

public class WebFormPage {
    private Generic generic = new Generic("");

    private String textInput = "id=\"my-text-id\"";
    private String password = "name=\"my-password\"";

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

    private String checkedCheckbox = "id=\"my-check-1\"";
    private String defaultCheckbox = "id=\"my-check-2\"";

    private String checkedRadio = "id=\"my-radio-1\"";
    private String defaultRadio = "id=\"my-radio-2\"";

    public Locator loc_TextUnput() {
        return generic.getById(textInput);
    }

    public Locator loc_Password() {
        return generic.getByLocator(password);
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

    public void fillDataList(String value) {
        generic.fill(loc_DataListInput(), value);
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
