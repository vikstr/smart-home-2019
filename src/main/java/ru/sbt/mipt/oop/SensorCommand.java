package ru.sbt.mipt.oop;

import java.io.IOException;

public interface SensorCommand {
    void giveCommand(CommandType type, String objectId) throws IOException;
}
