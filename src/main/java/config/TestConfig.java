package config;

import com.microsoft.playwright.BrowserType;

public class TestConfig {
    public static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";
    public static final String WEB_FORM_URL = BASE_URL + "web-form.html";

    public static BrowserType.LaunchOptions getBrowserOptions() {
        return new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(100);
    }
}
