package ru.sbt.mipt.oop;

import java.io.IOException;

public class TurnOnLightCommand implements Command {
    SmartHome smartHome;
    EventProcessor processor = new LightsEventProcessor();
    TurnOnLightCommand(SmartHome home){
        this.smartHome=home;
    }
    @Override
    public void execute(String rcID) throws IOException {
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, rcID);
        processor.processEvent(smartHome,event);
    }
}