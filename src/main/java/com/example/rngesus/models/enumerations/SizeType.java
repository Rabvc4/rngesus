package com.example.rngesus.models.enumerations;

public enum SizeType {

    FINE	("Fine",	8,	-16,	16,	0,	0.0,	0.5,	0.0,	0.0,	0.125,	0.250),
    DIMINUTIVE	("Diminutive",	4,	-12,	12,	6,	0.125,	1.0,	0.0,	0.0,	0.250,	0.500),
    TINY	("Tiny",	2,	-8,	8,	1,	1.0,	2.500,	0.0,	0.0,	0.500,	0.750),
    SMALL	("Small",	1,	-4,	4,	2,	8.0,	5.0,	5.0,	5.0,	0.750,	1.0),
    MEDIUM	("Medium",	0,	0,	0,	4,	60.0,	5.0,	5.0,	5.0,	1.0,	1.500),
    LARGE	("Large",	-1,	4,	-4,	8,	500.0,	10.0,	10.0,	5.0,	2.0,	3.0),
    HUGE	("Huge",	-2,	8,	-8,	16,	4000.0,	15.0,	15.0,	10.0,	4.0,	6.0),
    GARGANTUAN	("Gargantuan",	-4,	12,	-12,	32,	32000.0,	20.0,	20.0,	15.0,	8.0,	12.0),
    COLOSSAL	("Colossal",	-8,	16,	-16,	64,	250000.0,	30.0,	30.0,	20.0,	16.0,	24.0);

    private final String name;
    private final Integer attackAndACModifier;
    private final Integer specialAttackModifier;
    private final Integer hideModifier;
    private final Integer heightOrLength;
    private final Double weight;
    private final Double space;
    private final Double reachVertical;
    private final Double reachHorizontal;
    private final Double carryWeightBiped;
    private final Double carryWeightQuadruped;

    

    SizeType(String name, Integer attackAndACModifier, Integer specialAttackModifier, Integer hideModifier, Integer heightOrLength, Double weight, Double space, Double reachVertical, Double reachHorizontal, Double carryWeightBiped, Double carryWeightQuadruped) {
        this.name = name;
        this.attackAndACModifier = attackAndACModifier;
        this.specialAttackModifier = specialAttackModifier;
        this.hideModifier = hideModifier;
        this.heightOrLength = heightOrLength;
        this.weight = weight;
        this.space = space;
        this.reachVertical = reachVertical;
        this.reachHorizontal = reachHorizontal;
        this.carryWeightBiped = carryWeightBiped;
        this.carryWeightQuadruped = carryWeightQuadruped;
    }



    public String getName() {
        return name;
    }

    public Integer getAttackAndACModifier() {
        return attackAndACModifier;
    }

    public Integer getSpecialAttackModifier() {
        return specialAttackModifier;
    }

    public Integer getHideModifier() {
        return hideModifier;
    }

    public Integer getHeightOrLength() {
        return heightOrLength;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getSpace() {
        return space;
    }

    public Double getReachVertical() {
        return reachVertical;
    }

    public Double getReachHorizontal() {
        return reachHorizontal;
    }

    public Double getCarryWeightBiped() {
        return carryWeightBiped;
    }

    public Double getCarryWeightQuadruped() {
        return carryWeightQuadruped;
    }
}
