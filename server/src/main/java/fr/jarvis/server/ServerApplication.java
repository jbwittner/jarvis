package fr.jarvis.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Launcher of the application
 * @author Jean-Baptiste WITTNER
 */
@SpringBootApplication
public class ServerApplication {

    /**
     * Main of the application
     */
    public static void main(String[] args) {

        SpringApplication.run(ServerApplication.class, args);

    }

}