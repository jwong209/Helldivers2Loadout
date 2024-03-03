package org.example;

public class Armor {

    private String name;
    private String armorRating;
    private String speed;
    private String staminaRegen;
    private String armorPassive;
    private String subType;

    // Constructor Cape
    public Armor(String name, String armorRating, String speed, String staminaRegen, String armorPassive) {
        this.name = name;
        this.armorRating = armorRating;
        this.speed = speed;
        this.staminaRegen = staminaRegen;
        this.armorPassive = armorPassive;
    }
    // Constructor Body Armor & Helmet
    public Armor(String name, String armorRating, String speed, String staminaRegen, String armorPassive, String subType) {
        this.name = name;
        this.armorRating = armorRating;
        this.speed = speed;
        this.staminaRegen = staminaRegen;
        this.armorPassive = armorPassive;
        this.subType = subType;
    }

    // ----- Getters -----
    public String getName() {
        return name;
    }

    public String getArmorRating() {
        return armorRating;
    }

    public String getSpeed() {
        return speed;
    }

    public String getStaminaRegen() {
        return staminaRegen;
    }

    public String getArmorPassive() {
        return armorPassive;
    }

    public String getSubType() {
        return subType;
    }
}
