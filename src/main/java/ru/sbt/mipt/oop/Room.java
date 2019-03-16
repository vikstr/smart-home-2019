package ru.sbt.mipt.oop;

import java.util.Collection;

public class Room implements Actionable{
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }
    public Light getLightById(String objectId) {
        Light light = new Light(objectId, true);
        return light;
    }

    @Override
    public void executeAction(Action action){
        action.execute(this);
        lights.forEach((c) -> c.executeAction(action));
        doors.forEach((c) -> c.executeAction(action));
    }
}
