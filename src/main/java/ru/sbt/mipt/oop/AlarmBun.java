package ru.sbt.mipt.oop;

public class AlarmBun implements Alarm {
    private AlarmSignal alarmSignal;
    public AlarmBun(AlarmSignal signal){
        this.alarmSignal = signal;
    }
    @Override
    public void setAlarm(){
        setState(new AlarmState(alarmSignal));
    }
    @Override
    public void setState(Alarm alarm) {
        alarmSignal.setState(alarm);
    }
    @Override
    public void activate(String password) {
        alarmSignal.setState(new AlarmActivate(alarmSignal,password));
    }
    @Override
    public void deactivate(String password) {
        System.out.print("Alarm is deactivated");
    }
}
