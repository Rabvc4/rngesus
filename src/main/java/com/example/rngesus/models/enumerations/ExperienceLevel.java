package com.example.rngesus.models.enumerations;

public enum ExperienceLevel {

    LEVEL1 (0, 1),
    LEVEL2 (300, 2),
    LEVEL3 (900, 3),
    LEVEL4 (2700, 4),
    LEVEL5 (6500, 5),
    LEVEL6 (14000, 6),
    LEVEL7 (23000, 7),
    LEVEL8 (34000, 8),
    LEVEL9 (48000, 9),
    LEVEL10 (64000, 10),
    LEVEL11 (85000, 11),
    LEVEL12 (100000, 12),
    LEVEL13 (120000, 13),
    LEVEL14 (140000, 14),
    LEVEL15 (165000, 15),
    LEVEL16 (195000, 16),
    LEVEL17 (225000, 17),
    LEVEL18 (265000, 18),
    LEVEL19 (305000, 19),
    LEVEL20 (355000, 20);

    private final Integer experience;
    private final Integer level;

    ExperienceLevel(Integer experience, Integer level) {
        this.experience = experience;
        this.level = level;
    }

    public Integer getExperience() {
        return experience;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getCurrentLevel(Integer experience) {
        int i = 0;
        for (ExperienceLevel experienceLevel : ExperienceLevel.values()) {
            while (experienceLevel.experience > experience) {
                i = experienceLevel.level;
            }
        }
        return  i;
    }
}
