package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.Generic;

public class NavigationPage {
    private Generic generic = new Generic("");

    public NavigationPage(Page page) {
        this.generic = new Generic(page);
    }

    // Селекторы
    private String paginationContainer = "ul.pagination";
    private String previousButton = "li.page-item:has-text('Previous')";
    private String nextButton = "li.page-item:has-text('Next')";
    private String pageOneButton = "ul.pagination li.page-item:nth-child(2)";
    private String pageTwoButton = "ul.pagination li.page-item:nth-child(3)";
    private String pageThreeButton = "ul.pagination li.page-item:nth-child(4)";

    // Методы для получения локаторов (как в MainPage)
    public Locator loc_PaginationContainer() {
        return generic.getByLocator(paginationContainer);
    }

    public Locator loc_PreviousButton() {
        return generic.getByLocator(previousButton);
    }

    public Locator loc_NextButton() {
        return generic.getByLocator(nextButton);
    }

    public Locator loc_PageOneButton() {
        return generic.getByLocator(pageOneButton);
    }

    public Locator loc_PageTwoButton() {
        return generic.getByLocator(pageTwoButton);
    }

    public Locator loc_PageThreeButton() {
        return generic.getByLocator(pageThreeButton);
    }

    public Locator loc_AllPaginationButtons() {
        return generic.getByLocator("ul.pagination li.page-item");
    }
}