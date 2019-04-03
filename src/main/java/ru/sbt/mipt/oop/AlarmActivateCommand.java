package ru.sbt.mipt.oop;

import java.io.IOException;

public class AlarmActivateCommand implements Command {
    SmartHome smartHome;
    EventProcessor processor = new AlarmEventProcessor();
    AlarmActivateCommand(SmartHome home){
        this.smartHome=home;
    }
    @Override
    public void execute(String rcID) throws IOException {
        SensorEvent event = new SensorEvent(SensorEventType.ALARM_ACTIVATE, rcID);
        processor.processEvent(smartHome,event);
    }
}
