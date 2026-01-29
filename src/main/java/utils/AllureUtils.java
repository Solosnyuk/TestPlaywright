package utils;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AllureUtils {
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Step("{stepName}")
    public static void step(String stepName) {
        System.out.println("[STEP] " + LocalDateTime.now().format(formatter) + " - " + stepName);
    }

    @Attachment(value = "Скриншот", type = "image/png")
    public static byte[] takeScreenshot(Page page) {
        return page.screenshot(new Page.ScreenshotOptions()
                .setFullPage(true)
                .setPath(Paths.get("target/screenshots/screenshot-" + System.currentTimeMillis() + ".png")));
    }

}
