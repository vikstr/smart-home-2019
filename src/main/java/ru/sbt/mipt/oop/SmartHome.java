package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable{
    public AlarmSignal alarmSignal;
    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
    public void setAlarmSignal(AlarmSignal signal){
        this.alarmSignal = signal;
    }
    public Collection<Room> getRooms() {
        return rooms;
    }
    @Override
    public void executeAction(Action action){
        rooms.forEach(c -> c.executeAction(action));
    }
    public AlarmSignal getAlarmSignal() {
        return alarmSignal;
    }
    public void alarmActivate(String password) {
        this.alarmSignal.activate(password);
    }
    public void alarmBun(String password) {
        this.alarmSignal.deactivate(password);
    }
}
