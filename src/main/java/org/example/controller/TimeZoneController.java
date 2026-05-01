package org.example.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class TimeZoneController {

    @FXML
    private Button btnBack;
    @FXML
    private Button btnNext;

    @FXML
    private ComboBox<String> cbRegiao;
    @FXML
    private ComboBox<String> cbZona;

    @FXML
    void handleBack(ActionEvent event) {
        Navigation.navigate("/view/TelaWelcome.fxml");
    }

    @FXML
    void handleNext(ActionEvent event) {
        // Implement next screen navigation when available
        System.out.println("Next pressed from TimeZone");
    }

    @FXML
    public void initialize() {
        cbRegiao.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                atualizarZonas(newValue);
            }
        });
    }

    private void atualizarZonas(String regiaoSelecionada) {
        // Limpa o ComboBox de Zona sempre que uma nova região é escolhida
        cbZona.getItems().clear();

        // Lógica condicional para definir o conteúdo da segunda caixa
        switch (regiaoSelecionada) {
            case "América":
                cbZona.setItems(FXCollections.observableArrayList("New York", "Sao Paulo", "Los Angeles"));
                break;
            case "Europa":
                cbZona.setItems(FXCollections.observableArrayList("London", "Paris", "Berlin"));
                break;
            case "Ásia":
                cbZona.setItems(FXCollections.observableArrayList("Tokyo", "Seoul", "Beijing"));
                break;
            default:
                cbZona.setItems(FXCollections.observableArrayList("Outro local"));
                break;
        }
    }

}
