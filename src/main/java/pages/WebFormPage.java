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

    private String dropdownDatalistSF = "value=\"San Francisco\"";
    private String dropdownDatalistNY = "value=\"New York\"";
    private String dropdownDatalistS = "value=\"Seattle\"";
    private String dropdownDatalistLA = "value=\"Los Angeles\"";
    private String dropdownDatalistC = "value=\"Chicago\"";

    private String fileInput = "name=\"my-file\"";

    private String checkedCheckbox = "id=\"my-check-1\"";
    private String defoultCheckbox = "id=\"my-check-2\"";

    private String checkedRadio = "id=\"my-radio-1\"";
    private String defoultRadio = "id=\"my-radio-2\"";

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

}
