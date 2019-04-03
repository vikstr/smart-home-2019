package ru.sbt.mipt.oop;

public class TurnOnSignalCommand implements Command {
    AlarmActivate alarm;
    TurnOnSignalCommand(AlarmActivate alarm){
        this.alarm = alarm;
    }
    @Override
    public void execute(){
        alarm.setAlarm();
    }
}

