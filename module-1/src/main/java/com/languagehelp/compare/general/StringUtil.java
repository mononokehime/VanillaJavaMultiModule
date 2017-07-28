package com.languagehelp.compare.general;

/**
 * Another String util class, as if the world didn't have enough
 */
public class StringUtil {
    private StringUtil() {
    }

    public static String stripNonAlphaLeaveSpace(String value) {
        value = tidyText(value);
        return value.replaceAll("[^A-Za-z ]", "").replace("lbs", "").trim();
    }

    public static String stripNonAlphaCharactersAndDefinedWords(String value, String... replace) {
        value = tidyText(value);
        value = value.replaceAll("[^A-Za-z ]", "");
        for (String word : replace) {
            value = value.replace(word, "");
        }
        return value.replace("  ", " ").trim();
    }

    public static String stripDefinedCharacters(String value, String... replace) {
        for (String word : replace) {
            value = value.replace(word, "");
        }
        return value.trim();
    }

    private static String tidyText(String value){
        return value != null ? value:"";
    }
}
