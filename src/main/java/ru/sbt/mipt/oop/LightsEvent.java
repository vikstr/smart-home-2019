package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightsEvent implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!(event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF)) return;
        for (Room room : smartHome.getRooms()) {
            Light light = room.getLightById(event.getObjectId());
            if (event.getType() == LIGHT_ON) {
                light.setOn(true);
                light.printTurnOnLight(room.getName());
            } else {
                light.setOn(false);
                light.printTurnOffLight(room.getName());
            }
        }
    }
}