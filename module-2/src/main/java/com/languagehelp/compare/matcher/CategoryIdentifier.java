package com.languagehelp.compare.matcher;

/**
 * Interface the defines the contract for determining a product category
 */
public interface CategoryIdentifier {

    /**
     * Determines the category an item belongs to based on the String provided by using
     * regex matching in the implementations
     *
     * @param text the text to parse
     * @return the category
     */
    Category getItemCategory(String text);
}
