package ru.sbt.mipt.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LightsEventProcessorTest {
    private LoaderSmartHome loader;
    private SmartHome smartHome;
    private LightsEventProcessor processor;
    private String id1;
    private String id2;
    private SensorEvent event1;
    private SensorEvent event2 ;
    LightsEventProcessorTest() throws IOException {
        this.loader = new GsonSmartHomeLoader();
        this.smartHome = loader.loadSmartHome();
        this.processor = new LightsEventProcessor();
        this.id1 = "1";
        this.id2 = "2";
        this.event1 = new SensorEvent(SensorEventType.LIGHT_ON, id1);
        this.event2 = new SensorEvent(SensorEventType.LIGHT_OFF, id2);
    }
    @BeforeEach
    void setUp() throws IOException {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                light.setStateOn(id1, false);
                light.setStateOff(id2, true);
            }
        }
    }
    @Test
    void processEventTurn_onLight() {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(id1)) {
                    assertFalse(light.isOn());
                }
            }
        }
        processor.processEvent(smartHome, event1);
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(id1)) {
                    assertTrue(light.isOn());
                }
            }
        }
    }

    @Test
    void processEventTurn_offLight() {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(id2)) {
                    assertTrue(light.isOn());
                }
            }
        }
        processor.processEvent(smartHome, event2);
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(id2)) {
                    assertFalse(light.isOn());
                }
            }
        }
    }
}