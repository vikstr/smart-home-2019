package ru.sbt.mipt.oop;

import java.io.IOException;

public class TurnOffLightCommand implements Command {
    SmartHome smartHome;
    EventProcessor processor = new LightsEventProcessor();
    TurnOffLightCommand(SmartHome home){
        this.smartHome=home;
    }
    @Override
    public void execute(String rcID) throws IOException {
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_OFF, rcID);
        processor.processEvent(smartHome,event);
    }
}
