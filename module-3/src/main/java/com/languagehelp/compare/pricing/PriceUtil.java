package com.languagehelp.compare.pricing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * Figures out aspects related to price
 */
public final class PriceUtil {
    /**
     * The logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(PriceUtil.class);

    /**
     * Override public constructor
     */
    private PriceUtil() {

    }

    /**
     * Get the price
     * @param value value to fix
     * @return the Number version
     */
    public static Number getPrice(String value) {
        value = tidyPriceString(value);
        final DecimalFormat priceFormat = new DecimalFormat("###,###,###.00");
        try {
            return priceFormat.parse(value);

        } catch (ParseException e) {
            LOG.info("Unable to parse:" + value);
        }
        return 0;
    }

    /**
     * Tidies up
     * @param text text to tody
     * @return the tidied text
     */
    private static String tidyPriceString(String text) {
        text = text == null ? "" : text;
        return text.replaceAll("[A-Za-z ]", "").replace("$", "").trim();
    }
}
