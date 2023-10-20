package org.kostia.part2;

public enum Country {

    Romania("RO"),
    Spain("ES"),

    USA("US");

    private final String code;

    Country(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
