package com.lcaohoanq.formhandling;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import org.w3c.dom.events.MouseEvent;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Button cancelButton;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private Button signupHere;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;
    @FXML
    private ImageView logoImageView;
    @FXML
    private ImageView ggImageView;
    @FXML
    private ImageView fbImageView;
    @FXML
    private ImageView xImageView;
    public void cancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image brandingImage = new Image(getClass().getResource("/assets/img/lcaohoanq.branding.png").toExternalForm());
        brandingImageView.setImage(brandingImage);

        Image logoImage = new Image(getClass().getResource("/assets/img/fpt.png").toExternalForm());
        logoImageView.setImage(logoImage);

        Image ggImage = new Image(getClass().getResource("/assets/img/google.png").toExternalForm());
        ggImageView.setImage(ggImage);

        Image fbImage = new Image(getClass().getResource("/assets/img/facebook.png").toExternalForm());
        fbImageView.setImage(fbImage);

        Image xImage = new Image(getClass().getResource("/assets/img/twitter.png").toExternalForm());
        xImageView.setImage(xImage);
    }
    public void loginButtonAction(ActionEvent event) {
        if((!usernameTextField.getText().isBlank()) && (!enterPasswordField.getText().isBlank())){
//            loginMessageLabel.setText("You tried to login");
            validateLogin();
        }else{
            handleEmptyFields();
        }
    }
    private void handleEmptyFields(){
        AlertHandler.IS_EMPTY_FIELD("Empty Fields", "Please fill in all fields", null);
    }

    public void validateLogin(){
    }
    private void handleSuccess(){
        AlertHandler.IS_LOGIN_SUCCESS("Login Success", "Welcome " + usernameTextField.getText(), null);
    }
    public void signupHereAction(ActionEvent event) {
        try {
            // Load the register.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/assets/img/register.fxml"));

            // Get the current scene and set the new root
            Scene scene = signupHere.getScene();
            scene.setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    // Custom method for login via Google action
    private void loginViaGoogleAction() {
        // Add your code for Google login action here
        System.out.println("Logging in via Google...");
        Desktop desktop = Desktop.getDesktop();
        try {
            Desktop.getDesktop().browse(new URI("https://www.google.com"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void loginViaFacebookAction(){
        AlertHandler.IS_NOT_SUPPORT();
    }
    @FXML
    private void loginViaXAction(){
        AlertHandler.IS_NOT_SUPPORT();
    }

}