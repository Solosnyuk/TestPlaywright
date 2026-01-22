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

    public Locator getByTitle(String selector) {
        return page.get().getByTitle(selector, new Page.GetByTitleOptions().setExact(true));
    }

    public Locator getByLabel(String selector) {
        return page.get().getByLabel(selector, new Page.GetByLabelOptions().setExact(true));
    }

    public Locator getByPlaceholder(String selector) {
        return page.get().getByPlaceholder(selector, new Page.GetByPlaceholderOptions().setExact(true));
    }

    public Locator getByTestDataId(String id) {
        return page.get().getByTestId(id);
    }

    public void hardWait(int millis) {
        page.get().waitForTimeout(millis);
    }

    public void fillAndEnter(Locator locator, String text) {
        locator.fill(text);
        locator.press("Enter");
    }

    public void fill(Locator locator, String text) {
        locator.fill(text);
    }

    public void click(Locator locator) {
        locator.click();
    }

    public String getInnerText(Locator locator) {
        return locator.innerText();
    }
}