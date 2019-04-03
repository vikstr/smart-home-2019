package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.Collection;

public class TurnOffAllLightsCommand implements Command {
    SmartHome smartHome;
    EventProcessor processor = new LightsEventProcessor();
    TurnOffAllLightsCommand(SmartHome home){
        this.smartHome=home;
    }
    @Override
    public void execute(String rcID) throws IOException {
        Collection<Room> rooms = smartHome.getRooms();
        for (Room room : rooms){
            room.getLights().forEach((c)->c.setStateOff(c.getId()));
        }
    }
}