package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Application {

    public static void main(String... args) throws IOException {

        LoaderSmartHome initsmarthome = new GsonSmartHomeLoader();

        SmartHome smarthome = initsmarthome.loadSmartHome();
        startEvents(smarthome);
    }

    private static void startEvents(SmartHome smartHome) {
        SensorEvent sensorEvent = CreateRandomEvent.getNextSensorEvent();
        Collection<EventProcessor> eventProcessorCollection = createEventProcessors();
        while (sensorEvent != null) {
            System.out.println("Got event: " + sensorEvent);
            for (EventProcessor eventProcess : eventProcessorCollection) {
                eventProcess.processEvent(smartHome, sensorEvent);
            }
            sensorEvent = CreateRandomEvent.getNextSensorEvent();
        }
    }
    private static Collection<EventProcessor> createEventProcessors() {
        Collection<EventProcessor> eventProcessorCollection = new ArrayList<>();
        eventProcessorCollection.add(new LightsEvent());
        eventProcessorCollection.add(new DoorEvent());
        eventProcessorCollection.add(new MainDoorEvent());
        return eventProcessorCollection;
    }
}
