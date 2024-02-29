package org.example;

public class Armor {

    private String name;
    private String armorRating;
    private String speed;
    private String staminaRegen;
    private String armorPassive;

    public Armor(String name, String armorRating, String speed, String staminaRegen, String armorPassive) {
        this.name = name;
        this.armorRating = armorRating;
        this.speed = speed;
        this.staminaRegen = staminaRegen;
        this.armorPassive = armorPassive;
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

}
