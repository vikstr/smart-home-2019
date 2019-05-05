package ru.sbt.mipt.oop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ConfigSpring {

    @Bean
    LoaderSmartHome smartHomeLoader() {
        return new GsonSmartHomeLoader();
    }
}
