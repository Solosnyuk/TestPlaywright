package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.Generic;

public class MainPage {
    private Generic generic = new Generic("");
    private String webForm = "Web form";
    private String navigation = "Navigation";
    private String dropdownMenu = "Dropdown menu";
    private String mouseOver = "Mouse over";
    private String dragAndDrop = "Drag and drop";
    private String drawInCanvas = "Draw in canvas";

    public MainPage(Page page) {
        this.generic = new Generic(page);
    }

    public MainPage() {
    }

    public Locator loc_WebForm() {
        return generic.getByText(webForm);
    }

    public Locator loc_Navigation() {
        return generic.getByText(navigation);
    }

    public Locator loc_DropdownMenu() {
        return generic.getByText(dropdownMenu);
    }

    public Locator loc_MouseOver() {
        return generic.getByText(mouseOver);
    }

    public Locator loc_DragAndDrop() {
        return generic.getByText(dragAndDrop);
    }

    public Locator loc_DrawInCanvas() {
        return generic.getByText(drawInCanvas);
    }


    public void clickWebForm() {
        generic.click(loc_WebForm());
    }

    public void clickNavigation() {
        generic.click(loc_Navigation());
    }

    public void clickDropdownMenu() {
        generic.click(loc_DropdownMenu());
    }

    public void clickMouseOver() {
        generic.click(loc_MouseOver());
    }

    public void clickDragAndDrop() {
        generic.click(loc_DragAndDrop());
    }

    public void clickDrawInCanvas() {
        generic.click(loc_DrawInCanvas());
    }

}
