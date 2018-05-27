package ca.hotdang.carddeck;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    // private static int PORT = 8080;
    // private static String JSON_RESPONSE = "application/json";
    // private static DeckOfCards deckOfCards;

    /**
     * Entrypoint
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
