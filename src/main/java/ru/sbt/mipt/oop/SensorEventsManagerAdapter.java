package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.SensorEventsManager;

import java.io.IOException;

public class SensorEventsManagerAdapter {
    private SensorEventsManager sensorEventsManager;
    private SmartHome smartHome;
    public SensorEventsManagerAdapter(SmartHome smartHome) {
        this.sensorEventsManager = new SensorEventsManager();
        this.smartHome = smartHome;
    }

    public void start() throws IOException {
        sensorEventsManager.start();
    }

    public void addEventProcessor(EventProcessor eventProcessor) {
        sensorEventsManager.registerEventHandler(new EventHandlerAdapter(smartHome,eventProcessor));
    }
}
