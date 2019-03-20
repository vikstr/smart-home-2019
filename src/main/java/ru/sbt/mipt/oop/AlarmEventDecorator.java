package ru.sbt.mipt.oop;

import java.io.IOException;

public class AlarmEventDecorator implements EventProcessor {
    private EventProcessor eventProcessor;
    @Override
    public void processEvent(SmartHome home, SensorEvent event) throws IOException {
        if (home.getAlarmSignal().getState() instanceof AlarmActivate) {
            home.getAlarmSignal().setAlarm();
            return;
        }
        if (home.getAlarmSignal().getState() instanceof AlarmSignal) {
            return;
        }
        eventProcessor.processEvent(home, event);
    }
}
