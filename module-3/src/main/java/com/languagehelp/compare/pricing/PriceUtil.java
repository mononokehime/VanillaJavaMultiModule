package com.languagehelp.compare.pricing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * Figures out aspects related to price
 */
public final class PriceUtil {
    private static final Logger LOG = LoggerFactory.getLogger(PriceUtil.class);

    private PriceUtil() {

    }

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

    private static String tidyPriceString(String text) {
        text = text == null ? "" : text;
        return text.replaceAll("[A-Za-z ]", "").replace("$", "").trim();
    }
}
