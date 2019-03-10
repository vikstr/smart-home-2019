package ru.sbt.mipt.oop;

import java.io.IOException;

public class CreateRandomEvent  implements EventGenerator{
    @Override
    public SensorEvent getNextSensorEvent() throws IOException{
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
