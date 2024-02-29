package org.example;

import java.util.List;
import java.util.Set;

public class Loadout {

    private String name;
    private Weapon primaryWeapon;
    private Weapon secondaryWeapon;
    private Grenade grenade;
    private Armor helmet;
    private Armor bodyArmor;
    private Armor cape;
    private Booster booster;
    private Set<Stratagem> stratagems;

    //Constructor

    public Loadout(String name, Weapon primaryWeapon, Weapon secondaryWeapon, Grenade grenade, Armor helmet, Armor armor, Armor cape, Booster booster, Set<Stratagem> stratagems) {
        this.name = name;
        this.primaryWeapon = primaryWeapon;
        this.secondaryWeapon = secondaryWeapon;
        this.grenade = grenade;
        this.helmet = helmet;
        this.bodyArmor = armor;
        this.cape = cape;
        this.booster = booster;
        this.stratagems = stratagems;
    }


    // Getters
    public String getName() {
        return name;
    }

    public Weapon getPrimaryWeapon() {
        return primaryWeapon;
    }

    public Weapon getSecondaryWeapon() {
        return secondaryWeapon;
    }

    public Grenade getGrenade() {
        return grenade;
    }

    public Armor getHelmet() {
        return helmet;
    }

    public Armor getBodyArmor() {
        return bodyArmor;
    }

    public Armor getCape() {
        return cape;
    }

    public Booster getBooster() {
        return booster;
    }

    public Set<Stratagem> getStratagems() {
        return stratagems;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
}
