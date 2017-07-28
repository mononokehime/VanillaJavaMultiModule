package com.languagehelp.compare.matcher;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Determines a meat category from the supplied String. Currently supports the following regex
 * <code>
 * steakMatch = "(sirloin|rib eye|angus|beef|rib|rump|brisket|steak|chuck|veal)"
 * porkMatch = "(pork|bacon)"
 * lambMatch = "(lamb|sheep)"
 * chickenMatch = "(chicken|turkey|quail)"
 * <p/>
 * </code>
 */
public final class MeatCategoryIdentifier implements CategoryIdentifier {
    private static final String steakMatch = "(sirloin|rib eye|angus|beef|rib|rump|brisket|steak|chuck|veal)";

    private static final String porkMatch = "(pork|bacon)";
    private static final String lambMatch = "(lamb|sheep)";
    private static final String chickenMatch = "(chicken|turkey|quail)";
    private static final Pattern steakMatchPattern =
            Pattern.compile(steakMatch, Pattern.CASE_INSENSITIVE);

    private static final Pattern porkMatchPattern =
            Pattern.compile(porkMatch, Pattern.CASE_INSENSITIVE);

    private static final Pattern lambMatchPattern =
            Pattern.compile(lambMatch, Pattern.CASE_INSENSITIVE);

    private static final Pattern chickenMatchPattern =
            Pattern.compile(chickenMatch, Pattern.CASE_INSENSITIVE);
    private static final Map<Pattern, MeatCategoryEnum> patterns = new HashMap<>();

    static {
        patterns.put(steakMatchPattern, MeatCategoryEnum.BEEF);
        patterns.put(porkMatchPattern, MeatCategoryEnum.PORK);
        patterns.put(lambMatchPattern, MeatCategoryEnum.LAMB);
        patterns.put(chickenMatchPattern, MeatCategoryEnum.POULTRY);
    }

    @Override
    public Category getItemCategory(final String text) {
        String tidyText = text != null ? text : "";
        for (final Pattern pattern : patterns.keySet()) {
            final Matcher match = pattern.matcher(tidyText);
            if (match.find()) {
                return patterns.get(pattern);
            }
        }
        return MeatCategoryEnum.UNCATEGORISED;
    }

}
