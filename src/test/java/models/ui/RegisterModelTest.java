package models.ui;

import controllers.RegisterController;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import views.RegisterView;

import static org.junit.Assert.*;

public class RegisterModelTest {
    String username;
    private RegisterModel registerModel;

    @Before
    public void setUp() throws Exception {
        Dotenv dotenv = Dotenv.load();
        this.registerModel = new RegisterModel();
        this.username = dotenv.get("TEST_USERNAME");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isUsernameFormat() {
    }

    @Test
    public void isPasswordFormat() {
    }

    @Test
    public void isConfirmPasswordFormat() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void isMatching() {
    }

    @Test
    public void isDuplicateUsername() {
        boolean actualResult = registerModel.isDuplicateUsername(username);
        assertTrue(actualResult);
    }

    @Test
    public void insert() {
    }

    @Test
    public void username() {
    }

    @Test
    public void password() {
    }

    @Test
    public void confirmPassword() {
    }
}