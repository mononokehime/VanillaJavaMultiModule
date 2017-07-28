package com.languagehelp.compare.pricing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Deals with weight functions
 */
public final class WeightUtilTest {
    @Test
    public void checkWeightEmptyNumber() throws Exception {
        double price = WeightUtil.getWeight("").doubleValue();
        assertEquals("Incorrect value returned", "0.0", price + "");
    }

    @Test
    public void checkPriceNullNumber() throws Exception {
        double price = WeightUtil.getWeight(null).doubleValue();
        assertEquals("Incorrect value returned", "0.0", price + "");
    }

    @Test
    public void checkPriceNotNumber() throws Exception {
        double price = WeightUtil.getWeight("someString").doubleValue();
        assertEquals("Incorrect value returned", "0.0", price + "");
    }

    @Test
    public void checkPrice() throws Exception {
        double price = WeightUtil.getWeight("52").doubleValue();
        assertEquals("Incorrect value returned", "52.0", price + "");
    }

    @Test
    public void checkPriceDecimal() throws Exception {
        double price = WeightUtil.getWeight("52.01").doubleValue();
        assertEquals("Incorrect value returned", "52.01", price + "");
    }
}
