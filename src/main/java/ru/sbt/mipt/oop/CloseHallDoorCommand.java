package ru.sbt.mipt.oop;

import java.io.IOException;

public class CloseHallDoorCommand implements Command {
    SmartHome smartHome;
    CloseHallDoorCommand(SmartHome home){
        this.smartHome=home;
    }
    @Override
    public void execute() throws IOException {
        for (Room homeRoom : smartHome.getRooms()) {
            for (Light light : homeRoom.getLights()) {
                light.setOn(false);
            }
            for (Door door : homeRoom.getDoors()) {
                if (door.getId().equals("hall")) {
                    door.setStateClose("hall");
                }
            }
        }
    }
}
