package ru.sbt.mipt.oop;

import java.io.IOException;

public interface Command {
    void execute(String rcID) throws IOException;
}
