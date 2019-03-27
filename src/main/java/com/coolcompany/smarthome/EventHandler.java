package com.coolcompany.smarthome;

import java.io.IOException;

public interface EventHandler {

    void handleEvent(CCSensorEvent event) throws IOException;

}
