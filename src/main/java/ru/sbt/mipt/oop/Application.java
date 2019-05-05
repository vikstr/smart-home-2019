package ru.sbt.mipt.oop;

import com.google.gson.Gson;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

import static ru.sbt.mipt.oop.SensorEventType.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Application {

    private static final Logger logger = LogManager.getLogger(Application.class);
    public static void main(String... args) throws IOException {
        logger.info("Starting configuration");
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigSpring.class);
        //LoaderSmartHome initSmartHome = new GsonSmartHomeLoader();
        LoaderSmartHome smartHomeLoader = context.getBean(LoaderSmartHome.class);
        SmartHome smarthome = smartHomeLoader.loadSmartHome();
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
