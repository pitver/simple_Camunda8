package ru.vershinin.enums;

public enum StatusBid {
    NEW("NEW"),
    PROCESSED("PROCESSED"),
    REJECTED("REJECTED"),
    IN_WORK("IN_WORK");

    private final String name;

    StatusBid(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
