package ru.sbt.mipt.oop;

public interface Alarm {
    void activate(String password);
    void deactivate(String password);
    void setAlarm();
    void  setState(Alarm alarm);
}
