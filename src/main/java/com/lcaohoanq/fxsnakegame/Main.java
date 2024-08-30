package com.lcaohoanq.fxsnakegame;

import com.lcaohoanq.fxsnakegame.utils.LogsUtils;
import com.lcaohoanq.fxsnakegame.views.SwingLoginView;
import java.awt.EventQueue;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 830, 650);
        stage.setTitle("Hello!");
        stage.initStyle(StageStyle.DECORATED); // Hide the window's title bar (close, minimize, maximize buttons)
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        LogsUtils.ensureLogsFolderExists();

        launch();
    }
}