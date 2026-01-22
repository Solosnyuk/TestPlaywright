package baseTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import pages.MainPage;

public class WebFormBaseTest extends BaseTest{
    protected MainPage mainPage;

    @BeforeEach
    public void navigateToWebForm() {
        super.createContextAndPage();

        mainPage = new MainPage(page);

        navigateToMainPage();
        mainPage.clickWebForm();

        Assertions.assertTrue(
                page.url().contains("web-form"),
                "Не перешли в раздел Web Form"
        );
    }
}
