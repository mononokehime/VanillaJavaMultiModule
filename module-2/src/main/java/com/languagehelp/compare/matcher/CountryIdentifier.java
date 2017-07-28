package com.languagehelp.compare.matcher;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Determines a country from the supplied String. Currently supports the following regex
 * <code>
 * usaMatch = "(us|u.s.|usa|u.s.a|u.s.a.|american)"
 * australiaMatch = "(australia|aus|oz|aussie|aust)"
 * nzMatch = "(nz|new zealand)"
 * <p/>
 * </code>
 */
public final class CountryIdentifier {

    /**
     * ensure no public constructor
     */
    private CountryIdentifier() {

    }

    private final static String usaMatch = "(^us$|u.s.|usa|u.s.a|u.s.a.|american)";
    private final static Pattern usaMatchPattern =
            Pattern.compile(usaMatch);
    private final static String australiaMatch = "(australia|aus|oz|aussie|aust)";
    private final static Pattern australiaMatchPattern =
            Pattern.compile(australiaMatch);
    private final static String nzMatch = "(nz|new zealand|kiwi)";
    private final static Pattern nzMatchPattern =
            Pattern.compile(nzMatch);
    private final static String dutchMatch = "(dutch)";
    private final static Pattern dutchMatchPattern =
            Pattern.compile(dutchMatch);
    private final static String argentinaMatch = "(argentine|argentina)";
    private final static Pattern argentinaMatchPattern =
            Pattern.compile(argentinaMatch);
    private final static String germanyMatch = "(germany)";
    private final static Pattern germanyMatchPattern =
            Pattern.compile(germanyMatch);
    private final static String brazilMatch = "(brazil)";
    private final static Pattern brazilMatchPattern =
            Pattern.compile(brazilMatch);
    private static final Map<Pattern, Locale> patterns = new HashMap<>();

    static {
        patterns.put(usaMatchPattern, Locale.US);
        patterns.put(australiaMatchPattern, new Locale.Builder().setLanguage("en").setRegion("AU").build());
        patterns.put(nzMatchPattern, new Locale.Builder().setLanguage("en").setRegion("NZ").build());
        patterns.put(dutchMatchPattern, new Locale.Builder().setLanguage("en").setRegion("NL").build());
        patterns.put(argentinaMatchPattern, new Locale.Builder().setLanguage("es").setRegion("AR").build());
        patterns.put(germanyMatchPattern, new Locale.Builder().setLanguage("en").setRegion("DE").build());
        patterns.put(brazilMatchPattern, new Locale.Builder().setLanguage("pt").setRegion("BR").build());
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
        for (final Pattern pattern : patterns.keySet()) {
            //final Matcher match = pattern.matcher(tidyText).m;
            if (pattern.matcher(tidyText).matches()) {
                return patterns.get(pattern);
            }
        }
        // if there is no match, return null
        return null;
    }

}
