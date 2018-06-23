package com.example.rngesus.models.enumerations;

public enum HitDiceType {

    D4 (4),
    D6 (6),
    D8 (8),
    D10 (10),
    D12 (12);

    private final int dieType;

    HitDiceType(int dieType) {
        this.dieType = dieType;
    }

    public int getDieType() {
        return dieType;
    }

}
