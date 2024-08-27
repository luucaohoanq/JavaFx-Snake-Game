package com.lcaohoanq.formhandling.controllers;

import com.lcaohoanq.formhandling.utils.ApiUtils;
import com.lcaohoanq.formhandling.views.UIPrompts;
import com.lcaohoanq.formhandling.views.base.BaseResources;
import java.net.http.HttpResponse;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.event.ActionEvent;
import javax.swing.JOptionPane;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginController extends BaseResources {

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;
    @FXML
    private Button loginButton;
    private String email = "";
    private String password = "";

    @FXML
    public void initialize() {
        usernameTextField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                System.out.println("Enter key pressed");
                loginButtonAction(null);  // Trigger login action when Enter key is pressed
            }
        });
        enterPasswordField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                System.out.println("Enter key pressed");
                loginButtonAction(null);  // Trigger login action when Enter key is pressed
            }
        });
    }


    public void loginButtonAction(ActionEvent event) {
        if ((!usernameTextField.getText().isBlank()) && (!enterPasswordField.getText().isBlank())) {
//            loginMessageLabel.setText("You tried to login");
            validateLogin();
        } else {
            UIPrompts.IS_EMPTY_FIELD();
        }
    }

    public void validateLogin() {
        email = usernameTextField.getText();
        password = enterPasswordField.getText();
        if (email.equals("admin") && password.equals("admin")) {
            UIPrompts.IS_LOGIN_SUCCESS();
        } else {
            login(email, password);
        }
    }

    private void login(String email_phone, String password) {
        // Create a new thread to avoid blocking the Swing event dispatch thread
        new Thread(() -> {
            try {
                // Replace with your API URL
                String apiUrl = "http://localhost:8081/users/login";
                // Create the payload as a map and convert it to JSON
                Map<String, String> payload = Map.of(
                    "email_phone", email_phone, // Replace with actual value
                    "password", password // Replace with actual value
                );

                // Send the request and get the response
                HttpResponse<String> response = ApiUtils.postRequest(apiUrl, payload);

                // Handle the response
                switch (response.statusCode()) {
                    case 200:
                        UIPrompts.IS_LOGIN_SUCCESS();
                        break;
                    case 400:
                        JOptionPane.showMessageDialog(null,
                            "Username or password is incorrect, please try again!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,
                            "Internal server error, please try again later!");
                        break;
                }
            } catch (IOException | InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
            }
        }).start();
    }

    @FXML
    // Custom method for login via Google action
    private void loginViaGoogleAction() {
        UIPrompts.IS_NOT_SUPPORT();
    }

    @FXML
    private void loginViaFacebookAction() {
        UIPrompts.IS_NOT_SUPPORT();
    }

    public void signupHereAction(ActionEvent actionEvent) {
        try {
            // Specify the URL of the website
            URI uri = new URI("http://localhost:3000/users/register");
            // Open the website in the default browser
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(uri);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}