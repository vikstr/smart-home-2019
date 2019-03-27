package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlarmStateTest {
    String password = "PasswordByDefault";
    @Test
    void activate() {
        AlarmSignal signal = new AlarmSignal();
        signal.activate(password);
        assertTrue(signal.getState() instanceof AlarmActivate);
    }

    @Test
    void deactivate() {
        AlarmSignal signal = new AlarmSignal();
        signal.activate(password);
        signal.deactivate(password);
        assertTrue(signal.getState() instanceof AlarmBun);
    }
}