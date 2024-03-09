package org.helldivers2.model;

public class Stratagem {

    private String name;
    private String callInTime;
    private String uses;
    private String cooldownTime;
    private String stratagemTraits;
    private String subType;

    public Stratagem(String name, String callInTime, String uses, String cooldownTime, String stratagemTraits, String subType) {
        this.name = name;
        this.callInTime = callInTime;
        this.uses = uses;
        this.cooldownTime = cooldownTime;
        this.stratagemTraits = stratagemTraits;
        this.subType = subType;
    }

    public String getName() {
        return name;
    }

    public String getCallInTime() {
        return callInTime;
    }

    public String getUses() {
        return uses;
    }

    public String getCooldownTime() {
        return cooldownTime;
    }

    public String getStratagemTraits() {
        return stratagemTraits;
    }

    public String getSubType() {
        return subType;
    }
}
