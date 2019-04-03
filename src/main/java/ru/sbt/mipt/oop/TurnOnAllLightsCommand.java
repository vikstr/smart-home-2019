package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.Collection;

public class TurnOnAllLightsCommand implements Command {
    SmartHome smartHome;
    TurnOnAllLightsCommand(SmartHome home){
        this.smartHome=home;
    }
    @Override
    public void execute() throws IOException {
        for (Room room : smartHome.getRooms()){
            room.getLights().forEach((c)->c.setStateOn(c.getId()));
        }
    }
}
