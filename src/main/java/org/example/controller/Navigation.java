package org.example.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Navigation {
    private static Stage stage;

    public static void setStage(Stage stage) {
        Navigation.stage = stage;
    }

    public static void navigate(String fxmlPath) {
        try {
            Parent root = FXMLLoader.load(Navigation.class.getResource(fxmlPath));
            Scene scene = stage.getScene();
            if (scene == null) {
                scene = new Scene(root, 600, 400);
                stage.setScene(scene);
            } else {
                scene.setRoot(root);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
