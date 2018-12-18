package com.example.rngesus.models.enumerations;

public enum DieType {

    D4 (4),
    D6 (6),
    D8 (8),
    D10 (10),
    D12 (12),
    D20 (20);

    private final Integer sides;

    DieType(Integer sides) {
        this.sides = sides;
    }

    public Integer getSides() {
        return sides;
    }

}
