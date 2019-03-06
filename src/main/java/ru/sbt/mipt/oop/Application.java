package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Application {

    private static Smarthomeloader smarthomeloader = new GsonSmartHomeLoader();

    public static void loadSmartHome(LoadSmartHome smarthomeloader) {
        Application.smarthomeloader = smarthomeloader;
    }

    public static void main(String... args) throws IOException {
        SmartHome smarthome = smarthomeloader.loadsmarthome();
        startEvents(smarthome);
    }
    private static void startEvents(SmartHome smartHome) {
        SensorEvent sensorEvent = CreateRandomEvent.getNextSensorEvent();
        Collection<EventProcessor> eventProcessorCollection = configureEventProcessors();
        while (sensorEvent != null) {
            System.out.println("Got event: " + sensorEvent);
            for (EventProcessor eventProcessorCollection : event) {
                event.processEvent(smartHome, sensorEvent);
            }
            sensorEvent = CreateRandomEvent.getNextSensorEvent();
        }
    }
    private static Collection<EventProcessor> configureEventProcessors() {
        Collection<EventProcessor> eventProcessorCollection = new ArrayList<>();
        eventProcessorCollection.add(new LightsEvents());
        eventProcessorCollection.add(new DoorEventProcessor());
        eventProcessorCollection.add(new MainDoorEvent());
        return eventProcessorCollection;
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }

}
