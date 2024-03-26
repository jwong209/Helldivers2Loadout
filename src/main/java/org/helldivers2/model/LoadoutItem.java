package org.helldivers2.model;

public abstract class LoadoutItem {

    private String name;
    private String subType;

    // ----- Constructors -----
    public LoadoutItem(String name) {
        this.name = name;
    }
    public LoadoutItem(String name, String subType) {
        this.name = name;
        this.subType = subType;
    }

    // ----- Getters -----
    public String getName() {
        return name;
    }

    public String getSubType() {
        return subType;
    }



}
