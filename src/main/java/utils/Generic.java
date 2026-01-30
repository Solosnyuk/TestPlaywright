package utils;

import com.microsoft.playwright.*;

public class Generic {

    protected static ThreadLocal<Page> page = new ThreadLocal<>();

    public Generic(Page pageInstance) {
        page.set(pageInstance);
    }

    public Generic(String set) {
    }

    public static Page getPage() {
        return page.get();
    }

    public Locator getById(String selector) {
        return page.get().locator("#" + selector);
    }

    public Locator getByLocator(String selector) {
        return page.get().locator(selector);
    }

    public Locator getByText(String selector) {
        return page.get().getByText(selector, new Page.GetByTextOptions().setExact(true));
    }

    public void fill(Locator locator, String text) {
        locator.fill(text);
    }

    public void click(Locator locator) {
        locator.click();
    }

    public void selectByValue(Locator selectLocator, String value) {
        selectLocator.selectOption(value);
    }

    public void check(Locator checkboxLocator) {
        checkboxLocator.check();
    }

    public void uncheck(Locator checkboxLocator) {
        checkboxLocator.uncheck();
    }

    public void selectRadio(Locator radioLocator) {
        radioLocator.check();
    }



}