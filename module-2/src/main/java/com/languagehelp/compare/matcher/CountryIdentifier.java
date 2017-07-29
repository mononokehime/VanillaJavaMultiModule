package com.languagehelp.compare.matcher;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Determines a country from the supplied String. Currently supports the following regex
 * <code>
 * usaMatch = "(us|u.s.|usa|u.s.a|u.s.a.|american)"
 * AUSTRALIA_MATCH = "(australia|aus|oz|aussie|aust)"
 * NZ_MATCH = "(nz|new zealand)"
 * <p/>
 * </code>
 */
public final class CountryIdentifier {

    /**
     * ensure no public constructor
     */
    private CountryIdentifier() {

    }

    /**
     * Match US
     */
    private static final String USA_MATCH = "(^us$|u.s.|usa|u.s.a|u.s.a.|american)";
    /**
     * US pattern
     */
    private static final Pattern USA_MATCH_PATTERN =
            Pattern.compile(USA_MATCH);
    /**
     * Matching pattern for named country
     */
    private static final String AUSTRALIA_MATCH = "(australia|aus|oz|aussie|aust)";
    /**
     * Compiled pattern
     */
    private static final Pattern AUSTRALIA_MATCH_PATTERN =
            Pattern.compile(AUSTRALIA_MATCH);
    /**
     * Matching pattern for named country
     */
    private static final String NZ_MATCH = "(nz|new zealand|kiwi)";
    /**
     * Compiled pattern
     */
    private static final Pattern NZ_MATCH_PATTERN =
            Pattern.compile(NZ_MATCH);
    /**
     * Matching pattern for named country
     */
    private static final String DUTCH_MATCH = "(dutch)";
    /**
     * Compiled pattern
     */
    private static final Pattern DUTCH_MATCH_PATTERN =
            Pattern.compile(DUTCH_MATCH);
    /**
     * Matching pattern for named country
     */
    private static final String ARGENTINA_MATCH = "(argentine|argentina)";
    /**
     * Compiled pattern
     */
    private static final Pattern ARGENTINA_MATCH_PATTERN =
            Pattern.compile(ARGENTINA_MATCH);
    /**
     * Matching pattern for named country
     */
    private static final String GERMANY_MATCH = "(germany)";
    /**
     * Compiled pattern
     */
    private static final Pattern GERMANY_MATCH_PATTERN =
            Pattern.compile(GERMANY_MATCH);
    /**
     * Matching pattern for named country
     */
    private static final String BRAZIL_MATCH = "(brazil)";
    /**
     * Compiled pattern
     */
    private static final Pattern BRAZIL_MATCH_PATTERN =
            Pattern.compile(BRAZIL_MATCH);
    /**
     * Map containing all matchers
     */
    private static final Map<Pattern, Locale> PATTERNS = new HashMap<>();

    static {
        PATTERNS.put(USA_MATCH_PATTERN, Locale.US);
        PATTERNS.put(AUSTRALIA_MATCH_PATTERN, new Locale.Builder().setLanguage("en").setRegion("AU").build());
        PATTERNS.put(NZ_MATCH_PATTERN, new Locale.Builder().setLanguage("en").setRegion("NZ").build());
        PATTERNS.put(DUTCH_MATCH_PATTERN, new Locale.Builder().setLanguage("en").setRegion("NL").build());
        PATTERNS.put(ARGENTINA_MATCH_PATTERN, new Locale.Builder().setLanguage("es").setRegion("AR").build());
        PATTERNS.put(GERMANY_MATCH_PATTERN, new Locale.Builder().setLanguage("en").setRegion("DE").build());
        PATTERNS.put(BRAZIL_MATCH_PATTERN, new Locale.Builder().setLanguage("pt").setRegion("BR").build());
    }

    /**
     * Determines the country based on the input
     *
     * @param text the input, can be null or mixed case
     * @return the locale, defaults to null
     */
    public static Locale getCountry(String text) {
        // lowercase and set to "" if null
        final String tidyText = (text != null) ? text.toLowerCase().trim() : "";
        for (final Pattern pattern : PATTERNS.keySet()) {
            //final Matcher match = pattern.matcher(tidyText).m;
            if (pattern.matcher(tidyText).matches()) {
                return PATTERNS.get(pattern);
            }
        }
        // if there is no match, return null
        return null;
    }

}
