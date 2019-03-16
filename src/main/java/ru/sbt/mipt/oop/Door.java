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
    public void setState(String objectId, boolean open) {
        if (objectId.equals(id)) {
            setOpen(open);
            if (open) {
                printOpenedDoor(" ");
            } else {
                printClosedDoor(" ");
            }
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
