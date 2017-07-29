package com.languagehelp.compare.matcher;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Determines a meat category from the supplied String. Currently supports the following regex
 * <code>
 * STEAK_MATCH = "(sirloin|rib eye|angus|beef|rib|rump|brisket|steak|chuck|veal)"
 * PORK_MATCH = "(pork|bacon)"
 * LAMB_MATCH = "(lamb|sheep)"
 * CHICKEN_MATCH = "(chicken|turkey|quail)"
 * <p/>
 * </code>
 */
public final class MeatCategoryIdentifier implements CategoryIdentifier {
    /**
     * Matching pattern for named meat
     */
    private static final String STEAK_MATCH = "(sirloin|rib eye|angus|beef|rib|rump|brisket|steak|chuck|veal)";
    /**
     * Matching pattern for named meat
     */
    private static final String PORK_MATCH = "(pork|bacon)";
    /**
     * Matching pattern for named meat
     */
    private static final String LAMB_MATCH = "(lamb|sheep)";
    /**
     * Matching pattern for named meat
     */
    private static final String CHICKEN_MATCH = "(chicken|turkey|quail)";
    /**
     * Compiled pattern
     */
    private static final Pattern STEAK_MATCH_PATTERN =
            Pattern.compile(STEAK_MATCH, Pattern.CASE_INSENSITIVE);
    /**
     * Compiled pattern
     */
    private static final Pattern PORK_MATCH_PATTERN =
            Pattern.compile(PORK_MATCH, Pattern.CASE_INSENSITIVE);
    /**
     * Compiled pattern
     */
    private static final Pattern LAMB_MATCH_PATTERN =
            Pattern.compile(LAMB_MATCH, Pattern.CASE_INSENSITIVE);
    /**
     * Compiled pattern
     */
    private static final Pattern CHICKEN_MATCH_PATTERN =
            Pattern.compile(CHICKEN_MATCH, Pattern.CASE_INSENSITIVE);
    /**
     * Map comtaining all patters
      */
    private static final Map<Pattern, MeatCategoryEnum> PATTERNS = new HashMap<>();

    static {
        PATTERNS.put(STEAK_MATCH_PATTERN, MeatCategoryEnum.BEEF);
        PATTERNS.put(PORK_MATCH_PATTERN, MeatCategoryEnum.PORK);
        PATTERNS.put(LAMB_MATCH_PATTERN, MeatCategoryEnum.LAMB);
        PATTERNS.put(CHICKEN_MATCH_PATTERN, MeatCategoryEnum.POULTRY);
    }

    @Override
    public Category getItemCategory(final String text) {
        String tidyText = text != null ? text : "";
        for (final Pattern pattern : PATTERNS.keySet()) {
            final Matcher match = pattern.matcher(tidyText);
            if (match.find()) {
                return PATTERNS.get(pattern);
            }
        }
        return MeatCategoryEnum.UNCATEGORISED;
    }

}
