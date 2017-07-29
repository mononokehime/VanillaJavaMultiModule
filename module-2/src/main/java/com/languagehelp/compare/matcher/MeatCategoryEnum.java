package com.languagehelp.compare.matcher;

import java.util.HashMap;
import java.util.Map;

/**
 * The meat categories
 */
public enum MeatCategoryEnum implements Category {
    /**
     * Enum for named meat
     */
    BEEF(1),
    /**
     * Enum for named meat
     */
    PORK(2),
    /**
     * Enum for named meat
     */
    LAMB(3),
    /**
     * Enum for named meat
     */
    POULTRY(4),
    /**
     * Enum for named meat
     */
    UNCATEGORISED(5);
    /**
     * Map of items
     */
    private static final Map<Integer, MeatCategoryEnum> CODE_MAP = new HashMap<>();

    static {
        for (MeatCategoryEnum errorCode : MeatCategoryEnum.values()) {
            CODE_MAP.put(errorCode.getValue(), errorCode);
        }
    }

    /**
     * The enum value
     */
    private final int value;

    /**
     * Contructor
     * @param value the to construct
     */
    MeatCategoryEnum(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", getValue(), getName());
    }
}
