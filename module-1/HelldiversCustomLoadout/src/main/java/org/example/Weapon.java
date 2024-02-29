package org.example;

public class Weapon{

    /*
    damage, capacity, recoil, fireRate all start with zero. In Java, integer literal with 0 beginning interpreted as base 8.
    octal ---> decimal
        01 ---> 1
        But: 010 ---> 8
    so maybe interpret these values as String instead of int
     */
    private String name;
    private String damage;
    private String capacity;
    private String recoil;
    private String fireRate;
    private String weaponTraits;

    public Weapon(String name, String damage, String capacity, String recoil, String fireRate, String weaponTraits) {
        this.name = name;
        this.damage = damage;
        this.capacity = capacity;
        this.recoil = recoil;
        this.fireRate = fireRate;
        this.weaponTraits = weaponTraits;
    }

    // ----- Getters -----

    public String getName() {
        return name;
    }

    public String getDamage() {
        return damage;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getRecoil() {
        return recoil;
    }

    public String getFireRate() {
        return fireRate;
    }

    public String getWeaponTraits() {
        return weaponTraits;
    }


}
