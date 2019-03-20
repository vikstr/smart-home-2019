package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATE;

public class AlarmEventProcessor implements EventProcessor {
    @Override
    public  void processEvent(SmartHome home,SensorEvent event) {
        if (!(event.getType() == ALARM_ACTIVATE || event.getType() == SensorEventType.ALARM_DEACTIVATE)) return;
        if (event.getType() == ALARM_ACTIVATE) {
            home.alarmActivate(event.getObjectId());
        } else {
            home.alarmBun(event.getObjectId());
        }
    }
}
