package org.example;

public class Grenade {

    private String name;
    private String damage;
    private String penetration;
    private String outerRadius;
    private String fuseTime;

    public Grenade(String name, String damage, String penetration, String outerRadius, String fuseTime) {
        this.name = name;
        this.damage = damage;
        this.penetration = penetration;
        this.outerRadius = outerRadius;
        this.fuseTime = fuseTime;
    }

    public String getName() {
        return name;
    }

    public String getDamage() {
        return damage;
    }

    public String getPenetration() {
        return penetration;
    }

    public String getOuterRadius() {
        return outerRadius;
    }

    public String getFuseTime() {
        return fuseTime;
    }
}
