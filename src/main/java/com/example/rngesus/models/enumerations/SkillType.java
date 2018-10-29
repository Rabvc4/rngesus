package com.example.rngesus.models.enumerations;

public enum SkillType {

    ACROBATICS ("Acrobatics", AbilityScoreType.DEX),
    ANIMAL_HANDLING ("Animal Handling", AbilityScoreType.WIS),
    ARCANA ("Arcana", AbilityScoreType.INT),
    ATHLETICS ("Athletics", AbilityScoreType.STR),
    DECEPTION ("Decpetion", AbilityScoreType.CHA),
    HISTORY ("History", AbilityScoreType.INT),
    INSIGHT ("Insight", AbilityScoreType.WIS),
    INTIMIDATION ("Intimidation", AbilityScoreType.CHA),
    INVESTIGATION ("Investigation", AbilityScoreType.INT),
    MEDICINE ("Medicine", AbilityScoreType.WIS),
    NATURE ("Nature", AbilityScoreType.INT),
    PERCEPTION ("Perception", AbilityScoreType.WIS),
    PERFORMANCE ("Performance", AbilityScoreType.CHA),
    PERSUASION ("Persuasion", AbilityScoreType.CHA),
    RELIGION ("Religion", AbilityScoreType.INT),
    SLIGHT_OF_HAND ("Sleight of Hand", AbilityScoreType.DEX),
    STEALTH ("Stealth", AbilityScoreType.DEX),
    SURVIVAL ("Survival", AbilityScoreType.WIS);

    private final String name;
    private final AbilityScoreType modifier;

    SkillType(String name, AbilityScoreType modifier) {
        this.name = name;
        this.modifier = modifier;
    }

    public String getName() {
        return name;
    }

    public AbilityScoreType getModifier() {
        return modifier;
    }

}
