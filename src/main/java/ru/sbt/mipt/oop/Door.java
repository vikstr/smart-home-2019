package ru.sbt.mipt.oop;

public class Door {
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
    public void printOpenedDoor(String objectName) {
        System.out.println("Door " + getId() + " in room " + objectName + " was opened.");
    }

    public void printClosedDoor(String objectName) {
        System.out.println("Door " + getId() + " in room " + objectName + " was closed.");
    }
}
