package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Application {

    private static LoaderSmartHome smarthomeloader = new GsonSmartHomeLoader();

    public static void setSmarthomeloader(LoaderSmartHome smarthomeloader) {
        Application.smarthomeloader = smarthomeloader;
    }

    public static void main(String... args) throws IOException {
        SmartHome smarthome = smarthomeloader.loadSmartHome();
        startEvents(smarthome);
    }
    private static void startEvents(SmartHome smartHome) {
        SensorEvent sensorEvent = CreateRandomEvent.getNextSensorEvent();
        Collection<EventProcessor> eventProcessorCollection = configureEventProcessors();
        while (sensorEvent != null) {
            System.out.println("Got event: " + sensorEvent);
            for (EventProcessor eventProcess : eventProcessorCollection) {
                eventProcess.processEvent(smartHome, sensorEvent);
            }
            sensorEvent = CreateRandomEvent.getNextSensorEvent();
        }
    }
    private static Collection<EventProcessor> configureEventProcessors() {
        Collection<EventProcessor> eventProcessorCollection = new ArrayList<>();
        eventProcessorCollection.add(new LightsEvent());
        eventProcessorCollection.add(new DoorEvent());
        eventProcessorCollection.add(new MainDoorEvent());
        return eventProcessorCollection;
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }

}
