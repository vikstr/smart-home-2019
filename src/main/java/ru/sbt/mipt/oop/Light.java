package ru.sbt.mipt.oop;

public class Light implements Actionable{
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
    public void setStateOn(String objectId) {
        if (objectId.equals(id)){
            setOn(true);
            printTurnOnLight(" ");
        }
    }
    public void setStateOff(String objectId) {
        if (objectId.equals(id)){
            setOn(false);
            printTurnOffLight(" ");
        }
    }
    @Override
    public void executeAction(Action action){
        action.execute(this);
    }
}
