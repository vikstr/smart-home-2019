package ru.sbt.mipt.oop;

public class AlarmSignal implements Alarm {
    private String password;
    private Alarm alarm = new AlarmBun(this);
    public AlarmSignal(){
        password = "PasswordByDefault";
    }
    public void setPassword(String password){
        this.password = password;
    }
    public boolean checkPassword(String password)
    {
        return this.password==password;
    }
    @Override
    public void activate(String password){
        alarm.activate(password);
    }
    @Override
    public void deactivate(String password){
        alarm.deactivate(password);
    }
    @Override
    public void setAlarm(){
        alarm.setAlarm();
    }
    @Override
    public void setState(Alarm alarm){
        this.alarm = alarm;
    }

    public Alarm getState() {
        return alarm;
    }
}
