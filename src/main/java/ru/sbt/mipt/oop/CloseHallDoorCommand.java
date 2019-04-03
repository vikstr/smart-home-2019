package ru.sbt.mipt.oop;

import java.io.IOException;

public class CloseHallDoorCommand implements Command {
    SmartHome smartHome;
    EventProcessor processor = new MainDoorEvent();
    CloseHallDoorCommand(SmartHome home){
        this.smartHome=home;
    }
    @Override
    public void execute(String rcID) throws IOException {
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, rcID);
        processor.processEvent(smartHome,event);
    }
}
