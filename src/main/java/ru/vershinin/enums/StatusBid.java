package ru.vershinin.enums;

public enum StatusBid {
    NEW("новая заявка"),
    PROCESSED("обработано"),
    REJECTED("отклонено");

    private final String name;

    StatusBid(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
