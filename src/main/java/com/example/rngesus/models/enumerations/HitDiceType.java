package com.example.rngesus.models.enumerations;

public enum HitDiceType {

    D4 (4),
    D6 (6),
    D8 (8),
    D10 (10),
    D12 (12);

    private final Integer dieType;

    HitDiceType(Integer dieType) {
        this.dieType = dieType;
    }

    public Integer getDieType() {
        return dieType;
    }

}
