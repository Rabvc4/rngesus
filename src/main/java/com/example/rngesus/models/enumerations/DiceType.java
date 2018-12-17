package com.example.rngesus.models.enumerations;

public enum DiceType {

    D4 (4),
    D6 (6),
    D8 (8),
    D10 (10),
    D12 (12),
    D20 (20);

    private final Integer dieType;

    DiceType(Integer dieType) {
        this.dieType = dieType;
    }

    public Integer getDieType() {
        return dieType;
    }

}
