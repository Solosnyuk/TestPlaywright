package pages;

import com.microsoft.playwright.Page;

public class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    protected void navigateTo(String url) {
        page.navigate(url);
        page.waitForLoadState();
    }

    public String getPageTitle() {
        return page.title();
    }

    public String getCurrentUrl() {
        return page.url();
    }
}
