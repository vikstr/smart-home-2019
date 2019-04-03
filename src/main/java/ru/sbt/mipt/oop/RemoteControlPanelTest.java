package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class RemoteControlPanelTest {
    SmartHome smartHome;
    AlarmActivate alarm;
    String lightOffId;
    String lightOnId;
    Light light1;
    Light light2;
    Light mainLight = new Light("HallLight",false);
    RemoteControlPanelTest() throws IOException {
        this.lightOffId = "1";
        this.lightOnId = "2";
        String alarmPass = "PasswordByDefault";
        AlarmSignal signal = new AlarmSignal();
        this.alarm = new AlarmActivate(signal,alarmPass);
        Collection<Room> rooms = new ArrayList<>();
        Collection<Light> lights = new ArrayList<>();
        this.light1 = new Light(lightOffId, true);
        this.light2 = new Light(lightOnId, false);
        lights.add(light1);
        lights.add(light2);
        lights.add(mainLight);
        Room room = new Room(
                lights,
                Collections.singletonList(new Door(true, "1")),
                "room");
        rooms.add(room);
        this.smartHome = new SmartHome(rooms);
        smartHome.setAlarmSignal(signal);
    }
    @Test
    void run() throws IOException {
        RemoteControlPanel controlPanel = new RemoteControlPanel();
        String alarmCode = "1";
        String lightsOnCode = "2";
        String lightHallCode = "3";
        String lightsOffCode = "4";
        String signalCode = "A";
        String mainDoorCloseCode = "B";
        Command activateAlarm = new AlarmActivateCommand(smartHome);
        Command turnOnSignal = new TurnOnSignalCommand(alarm);
        Command turnOffLights = new TurnOffAllLightsCommand(smartHome);
        Command turnOnLights = new TurnOnAllLightsCommand(smartHome);
        Command closeHallDoor = new CloseHallDoorCommand(smartHome);
        Command turnOffLightHall = new TurnOffHallLightCommand(smartHome);
        controlPanel.setCommand(alarmCode, activateAlarm);
        controlPanel.setCommand(signalCode, turnOnSignal);
        controlPanel.setCommand(lightsOffCode, turnOffLights);
        controlPanel.setCommand(lightsOnCode,turnOnLights);
        controlPanel.setCommand(mainDoorCloseCode,closeHallDoor);
        controlPanel.setCommand(lightHallCode,turnOffLightHall);
        controlPanel.onButtonPressed(alarmCode," ");
        assertTrue(alarm.isActivated());
        controlPanel.onButtonPressed(signalCode," ");
        assertTrue(alarm.isTurnOn());
        controlPanel.onButtonPressed(lightsOffCode, " ");
        for (Room room: smartHome.getRooms()) {
            for (Light light: room.getLights()) {
                assertFalse(light.isOn());
            }
        }
        controlPanel.onButtonPressed(lightsOnCode," ");
        for (Room room: smartHome.getRooms()) {
            for (Light light: room.getLights()) {
                assertTrue(light.isOn());
            }
        }
        controlPanel.onButtonPressed(lightHallCode, "HallLight");
        controlPanel.onButtonPressed(mainDoorCloseCode," ");
        for (Room room: smartHome.getRooms()) {
            for (Light light: room.getLights()) {
                assertFalse(light.isOn());
            }
        }
    }

}