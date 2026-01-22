package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class MainPage {
    Locator WEB_FORM_LINK = getByRole(
            AriaRole.LINK, new Page.GetByRoleOptions().setName("Web form"));


}
