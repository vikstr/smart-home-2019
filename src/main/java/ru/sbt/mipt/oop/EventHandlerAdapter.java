package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.CCSensorEvent;
import com.coolcompany.smarthome.EventHandler;

import java.io.IOException;
import java.util.*;

public class EventHandlerAdapter implements EventHandler {
    private EventProcessor eventProcessor;
    private SmartHome smartHome;
    private static Map<String,SensorEventType> eventTypeSet = new HashMap<>();
    public EventHandlerAdapter(SmartHome smartHome, EventProcessor eventProcessor){
        this.eventProcessor = eventProcessor;
        this.smartHome = smartHome;
        eventTypeSet.put("DoorIsOpened",SensorEventType.DOOR_OPEN);
        eventTypeSet.put("DoorIsClosed", SensorEventType.DOOR_CLOSED);
        eventTypeSet.put("LightIsTurnedOn",SensorEventType.LIGHT_ON);
        eventTypeSet.put("LightIsTurnedOff",SensorEventType.LIGHT_OFF);
        eventTypeSet.put("AlarmIsActivated", SensorEventType.ALARM_ACTIVATE);
        eventTypeSet.put("AlarmIsDeactivated",SensorEventType.ALARM_DEACTIVATE);

    }
    @Override
    public void handleEvent(CCSensorEvent event) throws IOException {
        SensorEvent sensorEvent = new SensorEvent(eventTypeSet.get(event.getEventType()),event.getObjectId());
        eventProcessor.processEvent(smartHome,sensorEvent);
    }
}
////