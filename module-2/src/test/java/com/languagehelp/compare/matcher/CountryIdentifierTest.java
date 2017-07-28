package com.languagehelp.compare.matcher;

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Tests to identify a country
 */
public class CountryIdentifierTest {


    @Test
    public void getUSAUpperCase() throws Exception {
        Locale locale = CountryIdentifier.getCountry("USA");
        assertEquals("locale is not expected", "US", locale.getCountry());
        ///^us$/|u.s.|usa|u.s.a|u.s.a.|american
    }

    @Test
    public void getUSUpperCase() throws Exception {
        Locale locale = CountryIdentifier.getCountry("US");
        assertEquals("locale is not expected", "US", locale.getCountry());
    }

    @Test
    public void getUSLowerCase() throws Exception {
        Locale locale = CountryIdentifier.getCountry("US");
        assertEquals("locale is not expected", "US", locale.getCountry());
    }

    @Test
    public void getUSFullStopsCase() throws Exception {
        Locale locale = CountryIdentifier.getCountry("U.S.");
        assertEquals("locale is not expected", "US", locale.getCountry());
    }

    @Test
    public void getUSAFullStopsCase() throws Exception {
        Locale locale = CountryIdentifier.getCountry("U.S.A");
        assertEquals("locale is not expected", "US", locale.getCountry());
    }

    @Test
    public void getNewZealandLocale() throws Exception {
        Locale locale = CountryIdentifier.getCountry("New zealand");
        assertEquals("locale is not expected", "NZ", locale.getCountry());
    }

    @Test
    public void getnzLocale() throws Exception {
        Locale locale = CountryIdentifier.getCountry("nz");
        assertEquals("locale is not expected", "NZ", locale.getCountry());
    }

    @Test
    public void getNZLocale() throws Exception {
        Locale locale = CountryIdentifier.getCountry("NZ");
        assertEquals("locale is not expected", "NZ", locale.getCountry());
    }

    @Test
    public void getKiwiLocale() throws Exception {
        Locale locale = CountryIdentifier.getCountry("kiwi");
        assertEquals("locale is not expected", "NZ", locale.getCountry());
    }

    @Test
    public void getAustraliaLocale() throws Exception {
        assertEquals("locale is not expected", "AU", CountryIdentifier.getCountry("Australia").getCountry());
    }

    @Test
    public void getOzLocale() throws Exception {
        assertEquals("locale is not expected", "AU", CountryIdentifier.getCountry("Oz ").getCountry());
    }

    @Test
    public void getDefaultLocale() throws Exception {
        Locale locale = CountryIdentifier.getCountry("GB");
        assertNull("locale is not expected", locale);
    }
}
