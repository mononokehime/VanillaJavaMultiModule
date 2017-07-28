package com.languagehelp.compare.matcher;

import java.util.HashMap;
import java.util.Map;

/**
 * The meat categories
 */
public enum MeatCategoryEnum implements Category {
    BEEF(1),
    PORK(2),
    LAMB(3),
    POULTRY(4),
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

    private final int value;

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
