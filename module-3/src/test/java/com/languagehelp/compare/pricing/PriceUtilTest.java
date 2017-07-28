package com.languagehelp.compare.pricing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Price util tests
 */
public final class PriceUtilTest {
    @Test
    public void checkPriceEmptyNumber() throws Exception {
        double price = PriceUtil.getPrice("").doubleValue();
        assertEquals("Incorrect value returned", "0.0", price + "");
    }

    @Test
    public void checkPriceNullNumber() throws Exception {
        double price = PriceUtil.getPrice(null).doubleValue();
        assertEquals("Incorrect value returned", "0.0", price + "");
    }

    @Test
    public void checkPriceNotNumber() throws Exception {
        double price = PriceUtil.getPrice("someString").doubleValue();
        assertEquals("Incorrect value returned", "0.0", price + "");
    }

    @Test
    public void checkPrice() throws Exception {
        double price = PriceUtil.getPrice("52").doubleValue();
        assertEquals("Incorrect value returned", "52.0", price + "");
    }

    @Test
    public void checkPriceDecimal() throws Exception {
        double price = PriceUtil.getPrice("52.01").doubleValue();
        assertEquals("Incorrect value returned", "52.01", price + "");
    }
    @Test
    public void checkPriceDollarSign() throws Exception {
        double price = PriceUtil.getPrice("$52.01").doubleValue();
        assertEquals("Incorrect value returned", "52.01", price + "");
    }

}
