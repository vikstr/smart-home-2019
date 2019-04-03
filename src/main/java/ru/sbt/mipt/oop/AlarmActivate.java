package ru.sbt.mipt.oop;

public class AlarmActivate implements Alarm {
    AlarmSignal alarmSignal;
    boolean activated=false;
    boolean isOn = false;
    public AlarmActivate(AlarmSignal alarm, String  password) {
        this.alarmSignal = alarm;
        this.alarmSignal.setPassword(password);
    }
    public AlarmSignal getAlarmSignal(){
        return this.alarmSignal;
    }
    public boolean isActivated(){
        return activated;
    }
    public boolean isTurnOn(){
        return isOn;
    }
    @Override
    public void setState(Alarm alarm) {
        alarmSignal.setState(alarm);
    }

    @Override
    public void activate(String password) {
        this.activated = true;
        setState(new AlarmSignal());
    }

    @Override
    public void deactivate(String password) {
        if (alarmSignal.checkPassword(password)) {
            setState(new AlarmBun(alarmSignal));
            this.activated = false;
        } else {
            System.out.println("Incorrect password");
            setState(new AlarmSignal());
            this.isOn = true;
        }
    }

    @Override
    public void setAlarm() {
        this.isOn = true;
        setState(new AlarmSignal());
    }
}
