package com.example.rngesus.models.enumerations;

public enum CastingComponent {

    VERBAL ("Verbal", "V", "This is a spoken incantation. To provide a verbal component, you must be able to speak in a strong voice. Spells with this component are uncastable if you cannot speak."),
    SOMATIC ("Somatic", "S", "Somatic components are measured and precise hand motions that can be interfered with by wearing armor."),
    MATERIAL ("Material", "M", "Material components are one or more physical substances or objects that are annihilated by the spell energies in the casting process.");

    private final String name;
    private final String abbreviation;
    private final String description;

    CastingComponent(String name, String abbreviation, String description) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getDescription() {
        return description;
    }
}
