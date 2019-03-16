package ru.sbt.mipt.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DoorEventProcessorTest {
    private LoaderSmartHome loader;
    private SmartHome smartHome;
    private DoorEventProcessor processor;
    private String id1;
    private String id2;
    private SensorEvent event1;
    private SensorEvent event2 ;
    DoorEventProcessorTest() throws IOException {
        this.loader = new GsonSmartHomeLoader();
        this.smartHome = loader.loadSmartHome();
        this.processor = new DoorEventProcessor();
        this.id1 = "1";
        this.id2 = "2";
        this.event1 = new SensorEvent(SensorEventType.DOOR_OPEN, id1);
        this.event2 = new SensorEvent(SensorEventType.DOOR_CLOSED, id2);
    }
    @BeforeEach
    void setUp() throws IOException {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                door.setState(id1, false);
                door.setState(id2, true);
            }
        }
    }
    @Test
    void processEventCloseDoor() {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(id2)) {
                    assertTrue(door.isOpen());
                }
            }
        }
        processor.processEvent(smartHome, event2);
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(id2)) {
                    assertFalse(door.isOpen());
                }
            }
        }
    }
    @Test
    void processEventOpenDoor() {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(id1)) {
                    assertFalse(door.isOpen());
                }
            }
        }
        processor.processEvent(smartHome, event1);
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(id1)) {
                    assertTrue(door.isOpen());
                }
            }
        }
    }
}