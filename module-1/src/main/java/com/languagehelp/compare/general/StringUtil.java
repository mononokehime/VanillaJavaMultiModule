package com.languagehelp.compare.general;

/**
 * Another String util class, as if the world didn't have enough.
 */
public final class StringUtil {

    /**
     * Private constructor
     */
    private StringUtil() {
    }

    /**
     * Strips off spaces
     * @param value the value
     * @return the value stripped off
     */
    public static String stripNonAlphaLeaveSpace(String value) {
        value = tidyText(value);
        return value.replaceAll("[^A-Za-z ]", "").
                replace("lbs", "").trim();
    }

    /**
     * Strips off things
     * @param value the value
     * @param replace replace with
     * @return stripped off
     */
    public static String stripNonAlphaCharactersAndDefinedWords(String value,
                                                                final String... replace) {
        value = tidyText(value);
        value = value.replaceAll("[^A-Za-z ]", "");
        for (String word : replace) {
            value = value.replace(word, "");
        }
        return value.replace("  ", " ").trim();
    }

    /**
     * Strip off
     * @param value the value
     * @param replace what to replace with
     * @return value to return with
     */
    public static String stripDefinedCharacters(String value, final String... replace) {
        for (String word : replace) {
            value = value.replace(word, "");
        }
        return value.trim();
    }

    /**
     * DOme javadoc
     * @param value the value to tidy
     * @return tidied value
     */
    private static String tidyText(String value) {
        return value != null ? value : "";
    }
}
