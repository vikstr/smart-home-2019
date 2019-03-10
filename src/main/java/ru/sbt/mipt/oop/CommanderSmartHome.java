package ru.sbt.mipt.oop;

import java.io.IOException;

public class CommanderSmartHome implements SensorCommand {
    @Override
    public void giveCommand(CommandType type, String objectId) throws IOException {
        System.out.println("Pretend we're sending command: SensorCommand{" + "type=" + type + ", objectId='"
                + objectId+ '\'' + '}');
    }
}