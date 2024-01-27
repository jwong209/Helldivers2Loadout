package com.techelevator;

public class Television {

    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;


    // ----------------------------- Getter -----------------------------
    public boolean isOn() {    // how to write boolean? this works but same name as instance variable
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }
    // -----------------------------
    public void turnOff() {
        isOn = false;
    }

    public void turnOn() {
        isOn = true;
        currentChannel = 3;
        currentVolume = 2;
    }

    public void changeChannel(int newChannel) {
        if (isOn == true && newChannel >= 3 && newChannel <= 18) {
            currentChannel = newChannel;
        }
    }

    public void channelUp() {
        if (isOn == true) {
            currentChannel++;
            if (currentChannel > 18) currentChannel = 3;
        }
    }

    public void channelDown() {
        if (isOn == true) {
            currentChannel--;
            if (currentChannel < 3) currentChannel = 18;
        }
    }

    public void raiseVolume() {
        if (isOn == true) {
            currentVolume++;
            if (currentVolume > 10) currentVolume = 10;
        }
    }

    public void lowerVolume() {
        if (isOn == true) {
            currentVolume--;
            if (currentVolume < 0) currentVolume = 0;
        }
    }

}
