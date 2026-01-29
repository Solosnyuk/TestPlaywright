package generate;

import com.microsoft.playwright.Page;

import java.util.concurrent.ThreadLocalRandom;

public class ColorGenerate {
    public static String selectRandomColor() {
        String[] colors = {"#ff0000", "#00ff00", "#0000ff", "#ffff00", "#ff00ff", "#00ffff"};
        return colors[ThreadLocalRandom.current().nextInt(colors.length)];
    }
}