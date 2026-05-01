package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class WelcomeController {

    @FXML
    private Button btnNext;

    @FXML
    void handleNext(ActionEvent event) {
        Navigation.navigate("/view/TelaTimeZone.fxml");
    }
}
