package ru.sbt.mipt.oop;

public class AlarmState implements Alarm {
    private AlarmSignal alarmSignal;
    AlarmState(AlarmSignal alarm){
        this.alarmSignal = alarm;
        System.out.print("Sending sms");
    }
    @Override
    public void activate(String code){
        System.out.print("Achtung");
    }
    public void deactivate(String password){
        if(alarmSignal.checkPassword(password)) {
            alarmSignal.setState(new AlarmBun(alarmSignal));
            System.out.println("Welcome");
        }
        else {
            activate(" ");
        }
    }
    public void setAlarm() {
        System.out.print("Alarm is set");
    }
    public void  setState(Alarm alarm){
        alarmSignal.setState(alarm);
    }
}
