package com.lcaohoanq.fxsnakegame.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lcaohoanq.fxsnakegame.enums.HoverElement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import lombok.extern.slf4j.Slf4j;
import com.lcaohoanq.fxsnakegame.styles.UIHovers;
import com.lcaohoanq.fxsnakegame.utils.ApiUtils;
import com.lcaohoanq.fxsnakegame.views.SwingLoginView;
import com.lcaohoanq.fxsnakegame.views.utils.UIPrompts;

@Slf4j
public final class SwingLoginController implements ActionListener, MouseListener {

    public static String email = "";
    private final SwingLoginView loginView;
    public String password = "";
    private final UIHovers<SwingLoginView> uiHovers;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public SwingLoginController(SwingLoginView loginView) {
        super();
        this.loginView = loginView;
        this.uiHovers = new UIHovers<>(loginView);
        httpClient = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule()).enable(
            SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        email = loginView.getDataWhenLogin().getEmail();
        password = loginView.getDataWhenLogin().getPassword();

        if (loginView.isAdmin()) {
            loginView.handleSuccess();
            log.info("Admin login successful");
            return;
        }
        //prevent empty field when click submit button, but not when click on the menu
        if (loginView.isEmpty() && e.getSource() instanceof JButton) {
            UIPrompts.IS_EMPTY_FIELD();
            log.error("Empty field when login, please try again");
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
                        loginView.handleSuccess();
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

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == loginView.getJTextField_Right_Middle_Email()) {
            if (!loginView.getStatusToggle()) {
                uiHovers.setHoverEmail(HoverElement.ENABLE.isStatus(), "light");
            } else {
                uiHovers.setHoverEmail(HoverElement.ENABLE.isStatus(), "dark");
            }
        }
        if (e.getSource() == loginView.getJPasswordField_Right_Middle_Password()) {
            if (!loginView.getStatusToggle()) {
                uiHovers.setHoverEmail(HoverElement.ENABLE.isStatus(), "light");

            } else {
                uiHovers.setHoverEmail(HoverElement.ENABLE.isStatus(), "dark");
            }
        }
        if (e.getSource() == loginView.getJButton_Right_Bottom_Submit()) {
            if (!loginView.getStatusToggle()) {
                uiHovers.setHoverEmail(HoverElement.ENABLE.isStatus(), "light");
            } else {
                uiHovers.setHoverEmail(HoverElement.ENABLE.isStatus(), "dark");
            }
        }
        if (e.getSource() == loginView.getJButton_Right_Bottom_Others()) {
            uiHovers.setHoverOther(HoverElement.ENABLE.isStatus());
        }
        if (e.getSource() == loginView.getJButton_Right_Bottom_Forgot_Password()) {
            uiHovers.setHoverForgotPassword(HoverElement.ENABLE.isStatus());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == loginView.getJTextField_Right_Middle_Email()) {
            if (!loginView.getStatusToggle()) {
                uiHovers.setHoverEmail(HoverElement.DISABLE.isStatus(), "light");
            } else {
                uiHovers.setHoverEmail(HoverElement.DISABLE.isStatus(), "dark");
            }
        }
        if (e.getSource() == loginView.getJTextField_Right_Middle_FirstName()) {
            if (!loginView.getStatusToggle()) {
                uiHovers.setHoverFirstName(HoverElement.DISABLE.isStatus(), "light");
            } else {
                uiHovers.setHoverFirstName(HoverElement.DISABLE.isStatus(), "dark");
            }
        }
        if (e.getSource() == loginView.getJTextField_Right_Middle_LastName()) {
            if (!loginView.getStatusToggle()) {
                uiHovers.setHoverLastName(HoverElement.DISABLE.isStatus(), "light");
            } else {
                uiHovers.setHoverLastName(HoverElement.DISABLE.isStatus(), "dark");
            }
        }
        if (e.getSource() == loginView.getJPasswordField_Right_Middle_Password()) {
            if (!loginView.getStatusToggle()) {
                uiHovers.setHoverPassword(HoverElement.DISABLE.isStatus(), "light");
            } else {
                uiHovers.setHoverPassword(HoverElement.DISABLE.isStatus(), "dark");
            }
        }
        if (e.getSource() == loginView.getJButton_Right_Bottom_Submit()) {
            if (!loginView.getStatusToggle()) {
                uiHovers.setHoverButton(HoverElement.DISABLE.isStatus(), "light");
            } else {
                uiHovers.setHoverButton(HoverElement.DISABLE.isStatus(), "dark");
            }
        }
        if (e.getSource() == loginView.getJButton_Right_Bottom_Others()) {
            uiHovers.setHoverOther(HoverElement.DISABLE.isStatus());
        }
        if (e.getSource() == loginView.getJButton_Right_Bottom_Forgot_Password()) {
            uiHovers.setHoverForgotPassword(HoverElement.DISABLE.isStatus());
        }
    }
}
