package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RemoteControlPanel implements RemoteControl {
    private Map<String, Command> buttonMap;

    public RemoteControlPanel() {
        this.buttonMap = new HashMap<>();
    }

    public void setCommand (String buttonCode, Command command) {
        buttonMap.put(buttonCode,command);
    }

    @Override
    public void onButtonPressed(String buttonCode) throws IOException {
        if (buttonMap.containsKey(buttonCode))
        {
            buttonMap.get(buttonCode).execute();
        }
    }
}
