package ru.vershinin.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusBid {
    NEW("новая заявка"),
    PROCESS("обработано"),
    REJECTED("отклонено");

    private final String name;
}
