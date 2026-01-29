package generate;

import java.util.Random;

public class TextGenerator {
    static final Random random = new Random();

    public static String generateText(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 ";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }

        return result.toString();
    }

    public static String generateTextUpTo(int length) {
        return generateText(random.nextInt(length) + 1);
    }


}