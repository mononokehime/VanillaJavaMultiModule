package com.languagehelp.compare.pricing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * Deals with weight functions
 */
public final class WeightUtil {
    private static final Logger LOG = LoggerFactory.getLogger(WeightUtil.class);

    private WeightUtil() {
    }

    public static Number getWeight(String value) {
        value = value == null ? "" : value;
        final DecimalFormat weightFormat = new DecimalFormat("###,###,###");
        try {
            return weightFormat.parse(value);

        } catch (ParseException e) {
            LOG.info("Unable to parse:" + value);
        }
        return 0;
    }

    public static String determineMeasurementProfile(String value) {
        return (value.contains("gram") || value.contains("gr")) ? "gram" : "kg";
    }
}
