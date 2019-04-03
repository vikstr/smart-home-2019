package ru.sbt.mipt.oop;

import java.util.HashMap;

public class RemoteControlExecuter implements RemoteControl {
    public Map<String, Command> buttonCodeCommandMap = new HashMap<>();
    private String rciD;
    private final CommandHistory commandHistory;
    public RemoteController(String RCiD, CommandHistory commandHistory) {
        this.RCiD = RCiD;
        this.commandHistory = commandHistory;
    }

    public void linkButtonAndCommand (String buttonCode, Command command) {
        buttonCodeCommandMap.put(buttonCode,command);
    }

    @Override
    public void onButtonPressed(String buttonCode) {
        if (buttonCodeCommandMap.containsKey(buttonCode))
        {
            buttonCodeCommandMap.get(buttonCode).execute();
        }
    }
}
