package com.languagehelp.compare.matcher;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests to check the meat identification
 */
public class MeatCategoryIdentifierTest {

    CategoryIdentifier identifier = new MeatCategoryIdentifier();

    @Test
    public void getSirloinMatch() throws Exception {
        assertEquals("category is not expected", MeatCategoryEnum.BEEF, identifier.getItemCategory("sirloin"));
    }

    @Test
    public void getRibEyeMatch() throws Exception {

        assertEquals("category is not expected", MeatCategoryEnum.BEEF, identifier.getItemCategory("rib eye"));
    }

    @Test
    public void getAngusMatch() throws Exception {
        assertEquals("category is not expected", MeatCategoryEnum.BEEF, identifier.getItemCategory("angus"));
    }

    @Test
    public void getAberdeenAngusMatch() throws Exception {
        assertEquals("category is not expected", MeatCategoryEnum.BEEF, identifier.getItemCategory("aberdeen angus"));
    }

    @Test
    public void getBeefMatch() throws Exception {
        assertEquals("category is not expected", MeatCategoryEnum.BEEF, identifier.getItemCategory("beef"));
    }

    @Test
    public void getRibMatch() throws Exception {
        assertEquals("category is not expected", MeatCategoryEnum.BEEF, identifier.getItemCategory("rib"));
    }

    @Test
    public void getRumpMatch() throws Exception {
        assertEquals("category is not expected", MeatCategoryEnum.BEEF, identifier.getItemCategory("rump"));
    }

    @Test
    public void getBrisketMatch() throws Exception {
        assertEquals("category is not expected", MeatCategoryEnum.BEEF, identifier.getItemCategory("brisket"));
    }

    @Test
    public void getChuckMatch() throws Exception {
        assertEquals("category is not expected", MeatCategoryEnum.BEEF, identifier.getItemCategory("chuck"));
    }

    @Test
    public void getPorkMatch() throws Exception {
        assertEquals("category is not expected", MeatCategoryEnum.PORK, identifier.getItemCategory("pork"));
    }

    @Test
    public void getBaconMatch() throws Exception {
        assertEquals("category is not expected", MeatCategoryEnum.PORK, identifier.getItemCategory("bacon"));
    }

    @Test
    public void getLambMatch() throws Exception {
        assertEquals("category is not expected", MeatCategoryEnum.LAMB, identifier.getItemCategory("lamb"));
    }

    @Test
    public void getSheepMatch() throws Exception {
        assertEquals("category is not expected", MeatCategoryEnum.LAMB, identifier.getItemCategory("sheep"));
    }

    @Test
    public void getChickenMatch() throws Exception {
        assertEquals("category is not expected", MeatCategoryEnum.POULTRY, identifier.getItemCategory("chicken"));
    }

    @Test
    public void getQuailMatch() throws Exception {
        assertEquals("category is not expected", MeatCategoryEnum.POULTRY, identifier.getItemCategory("quail"));
    }

    @Test
    public void getTurkeyMatch() throws Exception {
        assertEquals("category is not expected", MeatCategoryEnum.POULTRY, identifier.getItemCategory("turkey"));
    }

    @Test
    public void getUncategorisedMatch() throws Exception {
        assertEquals("category is not expected", MeatCategoryEnum.UNCATEGORISED, identifier.getItemCategory("some other string"));
    }

    @Test
    public void getNullMatch() throws Exception {
        assertEquals("category is not expected", MeatCategoryEnum.UNCATEGORISED, identifier.getItemCategory(null));
    }
}


