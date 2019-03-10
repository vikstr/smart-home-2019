package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event){
        if (!(event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED)) return;
        // событие от двери
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        door.printOpenedDoor(room.getName());
                    } else {
                        door.printClosedDoor(room.getName());
                    }
                }
            }
        }
    }
}
