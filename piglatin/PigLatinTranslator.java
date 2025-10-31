package piglatin;

import java.util.Scanner;

public class PigLatinTranslator {

    public static Book translate(Book input) {
        Book translatedBook = new Book();
        translatedBook.setTitle(input.getTitle() + " (Pig Latin)");

        for (int i = 0; i < input.getLineCount(); i++) {
            String line = input.getLine(i);
            translatedBook.appendLine(translate(line));
        }

        return translatedBook;
    }

    public static String translate(String input) {
        Scanner scan = new Scanner(input);
        StringBuilder result = new StringBuilder();

        while (scan.hasNext()) {
            String word = scan.next();
            if (result.length() > 0) result.append(" ");
            result.append(translateWord(word));
        }

        scan.close();
        return result.toString();
    }

    private static String translateWord(String input) {
        if (input == null || input.isEmpty()) return input;

        // Handle punctuation at the end
        String punct = "";
        char lastChar = input.charAt(input.length() - 1);
        if (!Character.isLetter(lastChar)) {
            punct = Character.toString(lastChar);
            input = input.substring(0, input.length() - 1);
        }
        if (input.isEmpty()) return punct;

        // Detect if the first letter was capitalized
        boolean isCapitalized = Character.isUpperCase(input.charAt(0));
        String vowels = "aeiouAEIOU";

        // Find first vowel
        int vowelPos = -1;
        for (int i = 0; i < input.length(); i++) {
            if (vowels.indexOf(input.charAt(i)) != -1) {
                vowelPos = i;
                break;
            }
        }

        String translated;
        if (vowelPos == 0) {
            // Word starts with vowel
            translated = input + "ay";
        } else if (vowelPos == -1) {
            // No vowel
            translated = input + "ay";
        } else {
            // Move consonant cluster to end
            String start = input.substring(0, vowelPos);
            String rest = input.substring(vowelPos);

            // Lowercase first letter of consonant cluster
            start = start.substring(0, 1).toLowerCase() + start.substring(1);

            // Capitalize first letter of rest if original word was capitalized
            if (isCapitalized && rest.length() > 0) {
                rest = rest.substring(0, 1).toUpperCase() + rest.substring(1);
            }

            translated = rest + start + "ay";
        }

        // Add punctuation back
        return translated + punct;
    }
}
