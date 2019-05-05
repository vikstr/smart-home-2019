package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.Collection;

public class TurnOffAllLightsCommand implements Command {
    SmartHome smartHome;
    TurnOffAllLightsCommand(SmartHome home){
        this.smartHome=home;
    }
    @Override
    public void execute() throws IOException {
        for (Room room : smartHome.getRooms()){
            room.getLights().forEach((c)->c.setStateOff(c.getId()));
        }
    }
}