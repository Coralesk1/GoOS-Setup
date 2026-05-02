package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;


public class WelcomeController {

    @FXML
    private Button btnNext;

    @FXML
    private ListView<String> listLinguagens;



    @FXML
    void handleNext(ActionEvent event) {
        Navigation.navigate("/view/TelaTimeZone.fxml");
    }

    @FXML
    public void initialize(){
        listLinguagens.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                System.out.println("Linguagem selecionada: " + newValue);
            }
        });

    }




}


