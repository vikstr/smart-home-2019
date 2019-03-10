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

        LoaderSmartHome initSmartHome = new GsonSmartHomeLoader();

        SmartHome smarthome = initSmartHome.loadSmartHome();
        startEvents(smarthome);
    }

    private static void startEvents(SmartHome smartHome)  throws IOException {
        EventGenerator randomEvent = new CreateRandomEvent();
        SensorEvent sensorEvent = randomEvent.getNextSensorEvent();
        Collection<EventProcessor> eventProcessorCollection = createEventProcessors();
        while (sensorEvent != null) {
            System.out.println("Got event: " + sensorEvent);
            for (EventProcessor eventProcess : eventProcessorCollection) {
                eventProcess.processEvent(smartHome, sensorEvent);
            }
            sensorEvent = randomEvent.getNextSensorEvent();
        }
    }
    private static Collection<EventProcessor> createEventProcessors() {
        Collection<EventProcessor> eventProcessorCollection = new ArrayList<>();
        eventProcessorCollection.add(new LightsEventProcessor());
        eventProcessorCollection.add(new DoorEventProcessor());
        eventProcessorCollection.add(new MainDoorEvent());
        return eventProcessorCollection;
    }
}
