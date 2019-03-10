package ru.sbt.mipt.oop;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class SmartHomeEventTest {
    @Test
    public void MainDoorEventTest() throws IOException {
        ArrayList<Room> rooms = new ArrayList<>();
        Room room = new Room(Arrays.asList(new Light("1", false),
                new Light("2", true)),
                Arrays.asList(new Door(false, "1"),
                        new Door(true, "2")),"room");

        Room hall = new Room(Arrays.asList(new Light("3", true)),
                Arrays.asList(new Door(true, "3")),"hall");
        rooms.add(room);
        rooms.add(hall);

        SmartHome smartHome = new SmartHome(rooms);
        EventGenerator randomEvent = new CreateRandomEvent();
        SensorEvent sensorEvent = randomEvent.getNextSensorEvent();
        HomeEventsObserver homeEventsObserver = new HomeEventsObserver(smartHome,
                new RandomEventProvider());
        homeEventsObserver.addEventProcessor(new HallDoorEventProcessor());

        SensorEvent nextSensorEvent = new SensorEvent(SensorEventType.DOOR_CLOSED, "3");
        homeEventsObserver.runSensorEvent(smartHome, nextSensorEvent);

        //проверим что после события "Закрытие входной двери", входная дверь закрыта
        for (Room room1: smartHome.getRooms()){
            if (room1.getName().equals("hall")){
                assertFalse(room1.getDoors().stream().findFirst().orElse(null).getDoorState());
            }
        }

        //проверим что все светильники также выключены
        Integer lightOffAmount = 0;
        for (Room room1: smartHome.getRooms()){
            for (Light light: room1.getLights()){
                if (!light.isOn()){
                    lightOffAmount++;
                }
            }
        }
        assertEquals((Integer)3, lightOffAmount);


    }
}