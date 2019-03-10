package ru.sbt.mipt.oop;

import java.io.IOException;

public interface EventGenerator {
    SensorEvent getNextSensorEvent() throws IOException;
}
