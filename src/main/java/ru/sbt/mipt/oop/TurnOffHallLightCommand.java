package ru.sbt.mipt.oop;

import java.io.IOException;

public class TurnOffHallLightCommand implements Command {
    SmartHome smartHome;
    TurnOffHallLightCommand(SmartHome home){
        this.smartHome=home;
    }
    @Override
    public void execute() throws IOException {
        for (Room room: smartHome.getRooms()) {
            for (Light light: room.getLights()) {
                if(light.getId().equals("HallLight")){
                    light.setStateOff("HallLight");
                }
            }

        }

    }
}
