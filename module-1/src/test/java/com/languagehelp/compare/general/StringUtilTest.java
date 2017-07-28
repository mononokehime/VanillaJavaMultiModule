package com.languagehelp.compare.general;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import com.languagehelp.compare.general.StringUtilTest;

/**
 * Test cases for StringUtil
 */
public class StringUtilTest {

    @Test
    public void stripNonAlphaNumericLeaveSpace() throws Exception {
        final String text = "friday11";
        final String result = StringUtil.stripNonAlphaLeaveSpace(text);
        assertEquals("text is not expected", "friday", result);
    }

    @Test
    public void stripNonAlphaNumericLeaveSpaceEmpty() throws Exception {
        final String text = "";
        final String result = StringUtil.stripNonAlphaLeaveSpace(text);
        assertEquals("text is not expected", "", result);
    }

    @Test
    public void stripNonAlphaNumericLeaveSpaceNull() throws Exception {
        final String text = null;
        final String result = StringUtil.stripNonAlphaLeaveSpace(text);
        assertEquals("text is not expected", "", result);
    }

    @Test
    public void stripNonAlphaNumericLeaveSpaceWithSpace() throws Exception {
        final String text = "friday11 ";
        final String result = StringUtil.stripNonAlphaLeaveSpace(text);
        assertEquals("text is not expected", "friday", result);
    }

    @Test
    public void stripNonAlphaNumericLeaveSpaceMultipleCharacters() throws Exception {
        final String text = "friday11 saturday lbs";
        final String result = StringUtil.stripNonAlphaLeaveSpace(text);
        assertEquals("text is not expected", "friday saturday", result);
    }
}