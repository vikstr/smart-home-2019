package ru.sbt.mipt.oop;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

class MainDoorEventTest {
    private LoaderSmartHome loader;
    private SmartHome smartHome;
    private MainDoorEvent processor;
    MainDoorEventTest() throws IOException {
        this.loader = new GsonSmartHomeLoader();
        this.smartHome = loader.loadSmartHome();
        this.processor = new MainDoorEvent();
    }
    @Before
    public void setUp() throws IOException {
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                for (Door door : room.getDoors()) {
                    door.setStateOpen(door.getId(), true);
                }
            }
            for (Light light : room.getLights()) {
                light.setStateOn(light.getId(), true);
            }
        }
    }
    @Test
    public void processEventCloseMainDoor() throws IOException {
        processor.processEvent(smartHome, createEvent());
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                for (Door door : room.getDoors()) {
                    assertFalse(door.isOpen());
                }
            }

            for (Light light : room.getLights()) {
                assertFalse(light.isOn());
            }
        }
    }

    public SensorEvent createEvent() {
        SensorEvent event;
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                for (Door door : room.getDoors()) {
                    event = new SensorEvent(SensorEventType.DOOR_CLOSED, door.getId());
                    return event;
                }
            }
        }
        return null;
    }

}