package ru.sbt.mipt.oop;

import java.io.IOException;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class MainDoorEvent implements EventProcessor{

    MainDoorEvent(){
    }
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) throws IOException {
        if (event.getType() != DOOR_CLOSED) return;
        // событие от двери
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
                    // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                    if (room.getName().equals("hall")) {
                        for (Room homeRoom : smartHome.getRooms()) {
                            for (Light light : homeRoom.getLights()) {
                                light.setOn(false);
                                SensorCommand command = new CommanderSmartHome();
                                command.giveCommand(CommandType.LIGHT_OFF, light.getId());
                            }
                        }
                    }
                }
            }
        }
    }
}

