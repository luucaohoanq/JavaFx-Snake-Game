package utils;

import static org.junit.jupiter.api.Assertions.*;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnvUtilsTest {
    private Dotenv dotenv;
    private final String DB_URL_DOCKER = "jdbc:mysql://localhost:3307/snake_game_app";

    @BeforeEach
    public void setUp() {
        dotenv = Dotenv.configure().load();
    }

    @Test
    public void testGet() {
        assertEquals(DB_URL_DOCKER, dotenv.get("DB_URL_DOCKER"));
    }
}