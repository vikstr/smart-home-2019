package ru.sbt.mipt.oop;

public interface EventProcessor implements DoorEvent, LightEvents{

    void processEvent(SmartHome smartHome, SensorEvent event);

}
