package ru.sbt.mipt.oop;

public class AlarmActivate implements Alarm {
    AlarmSignal alarmSignal;

    public AlarmActivate(AlarmSignal alarm, String  password) {
        this.alarmSignal = alarm;
        this.alarmSignal.setPassword(password);
    }
    @Override
    public void setState(Alarm alarm) {
        alarmSignal.setState(alarm);
    }

    @Override
    public void activate(String password) {
        setState(new AlarmSignal());
    }

    @Override
    public void deactivate(String password) {
        if (alarmSignal.checkPassword(password)) {
            setState(new AlarmBun(alarmSignal));
        } else {
            System.out.println("Incorrect password");
            setState(new AlarmSignal());
        }
    }

    @Override
    public void setAlarm() {
        setState(new AlarmSignal());
    }
}
