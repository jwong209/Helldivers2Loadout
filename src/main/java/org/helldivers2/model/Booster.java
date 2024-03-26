package org.helldivers2.model;

public class Booster {

    private String name;
    private String benefit;

    public Booster(String name, String benefit) {
        this.name = name;
        this.benefit = benefit;
    }

    public String getName() {
        return name;
    }

    public String getBenefit() {
        return benefit;
    }
}
