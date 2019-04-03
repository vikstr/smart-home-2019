package ru.sbt.mipt.oop;

import java.io.IOException;

public class AlarmDeactivateCommand implements Command {
    SmartHome smartHome;
    EventProcessor processor = new AlarmEventProcessor();
    AlarmDeactivateCommand(SmartHome home){
        this.smartHome=home;
    }
    @Override
    public void execute(String rcID) throws IOException {
        SensorEvent event = new SensorEvent(SensorEventType.ALARM_DEACTIVATE, rcID);
        processor.processEvent(smartHome,event);
    }
}

