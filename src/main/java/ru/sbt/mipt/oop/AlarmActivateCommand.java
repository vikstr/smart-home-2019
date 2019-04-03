package ru.sbt.mipt.oop;

import java.io.IOException;

public class AlarmActivateCommand implements Command {
    AlarmActivate alarm;
    AlarmActivateCommand(AlarmActivate alarm){
        this.alarm = alarm;
    }
    @Override
    public void execute() throws IOException {
       alarm.activate("PasswordByDefault");
    }
}
