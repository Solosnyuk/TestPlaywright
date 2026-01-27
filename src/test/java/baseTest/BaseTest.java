package baseTest;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import pages.MainPage;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected MainPage mainPage;

    @BeforeAll
    public static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeEach
    public void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        mainPage = new MainPage(page);

        navigateToMainPage();
    }

    protected void navigateToMainPage() {
        page.navigate("https://bonigarcia.dev/selenium-webdriver-java/");
    }

    @AfterEach
    public void closeContext() {
        if (context != null) {
            context.close();
        }
    }

    @AfterAll
    public static void closeBrowser() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

}
