package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;


public class WelcomeController {

    @FXML
    private Button btnNext;

    @FXML
    private ListView<String> listIdiomas;


    @FXML
    void handleNext(ActionEvent event) {

        String idiomaSelecionado = listIdiomas.getSelectionModel().getSelectedItem();
        if (idiomaSelecionado == null || idiomaSelecionado.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Seleção Necessária");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um idioma antes de continuar.");
            alert.showAndWait();
            return;
        }
        Navigation.navigate("/view/TelaTimeZone.fxml");
    }

    @FXML
    public void initialize() {

        if (ConfigInstalacao.getIdioma() != null) {
            listIdiomas.getSelectionModel().select(ConfigInstalacao.getIdioma());
        }

        if (listIdiomas != null){
            listIdiomas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    ConfigInstalacao.setIdioma(newValue);
                }
            });
        }

    }




}
