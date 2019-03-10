package ru.sbt.mipt.oop;

import java.io.IOException;

public interface CommanderEvent {
    void printCommand(SmartHome smartHome, String objectName) throws IOException;
}
