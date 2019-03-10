package ru.sbt.mipt.oop;

import java.io.IOException;

public interface EventProcessor {
    void processEvent(SmartHome smartHome, SensorEvent event)  throws IOException ;

}
