package ru.sbt.mipt.oop;

public class Door implements Actionable {
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
    public boolean isOpen() {
        return isOpen;
    }
    public void setStateOpen(String objectId) {
        if (objectId.equals(id)) {
            setOpen(true);
            printOpenedDoor(" ");
        }
    }
    public void setStateClose(String objectId) {
        if (objectId.equals(id)) {
            setOpen(false);
            printClosedDoor(" ");
        }
    }
    public void printOpenedDoor(String objectName) {
        System.out.println("Door " + getId() + " in room " + objectName + " was opened.");
    }

    public void printClosedDoor(String objectName) {
        System.out.println("Door " + getId() + " in room " + objectName + " was closed.");
    }
    @Override
    public void executeAction(Action action){
        action.execute(this);
    }
}
