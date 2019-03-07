package ru.sbt.mipt.oop;

public class Light {
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
    public void printTurnOnLight(String objectName) {
        System.out.println("Light " + getId() + " in room " + objectName + " was turned on.");
    }

    public void printTurnOffLight(String objectName) {
        System.out.println("Light " + getId() + " in room " + objectName + " was turned off.");
    }
}
