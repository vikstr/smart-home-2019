package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.Collection;

public class TurnOnAllLightsCommand implements Command {
    SmartHome smartHome;
    EventProcessor processor = new LightsEventProcessor();
    TurnOnAllLightsCommand(SmartHome home){
        this.smartHome=home;
    }
    @Override
    public void execute(String rcID) throws IOException {
        Collection<Room> rooms = smartHome.getRooms();
        for (Room room : rooms){
            room.getLights().forEach((c)->c.setStateOn(c.getId()));
        }
    }
}
