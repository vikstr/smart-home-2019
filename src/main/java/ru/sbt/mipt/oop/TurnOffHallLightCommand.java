package ru.sbt.mipt.oop;

import java.io.IOException;

public class TurnOffHallLightCommand implements Command {
    SmartHome smartHome;
    EventProcessor processor = new LightsEventProcessor();
    TurnOffHallLightCommand(SmartHome home){
        this.smartHome=home;
    }
    @Override
    public void execute(String rcID) throws IOException {
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_OFF, "HallLight");
        processor.processEvent(smartHome,event);
    }
}
