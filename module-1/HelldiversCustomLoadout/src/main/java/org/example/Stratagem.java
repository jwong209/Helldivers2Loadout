package org.example;

public class Stratagem {

    private String name;
    private String callInTime;
    private String uses;
    private String cooldownTime;
    private String stratagemTraits;

    public Stratagem(String name, String callInTime, String uses, String cooldownTime, String stratagemTraits) {
        this.name = name;
        this.callInTime = callInTime;
        this.uses = uses;
        this.cooldownTime = cooldownTime;
        this.stratagemTraits = stratagemTraits;
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
}
