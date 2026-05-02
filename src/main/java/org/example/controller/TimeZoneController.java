package org.example.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;
import java.util.Map;

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
    private Pane mapPane;

    // Estrutura para coordenadas (x, y) no mapa 343x200
    private static class CityCoords {
        double x, y;
        CityCoords(double x, double y) { this.x = x; this.y = y; }
    }

    private final Map<String, CityCoords> cityData = new HashMap<>();

    public TimeZoneController() {
        // Coordenadas calibradas precisamente para o mapa 343x200
        
        // América
        cityData.put("Nova York", new CityCoords(70, 62));
        cityData.put("Toronto", new CityCoords(68, 58));
        cityData.put("Cidade do México", new CityCoords(55, 95));
        cityData.put("São Paulo", new CityCoords(110, 145));
        cityData.put("Buenos Aires", new CityCoords(105, 160));
        cityData.put("Santiago", new CityCoords(95, 160));
        
        // Europa
        cityData.put("Londres", new CityCoords(160, 55));
        cityData.put("Paris", new CityCoords(165, 60));
        cityData.put("Lisboa", new CityCoords(154, 70));
        cityData.put("Madrid", new CityCoords(158, 70));
        cityData.put("Berlim", new CityCoords(172, 58));
        cityData.put("Roma", new CityCoords(172, 70));
        cityData.put("Moscou", new CityCoords(200, 52));
        
        // África
        cityData.put("Cairo", new CityCoords(190, 82));
        cityData.put("Joanesburgo", new CityCoords(185, 158));
        cityData.put("Lagos", new CityCoords(165, 110));
        cityData.put("Luanda", new CityCoords(170, 130));
        cityData.put("Nairobi", new CityCoords(192, 120));
        cityData.put("Túnis", new CityCoords(170, 78));
        
        // Ásia
        cityData.put("Dubai", new CityCoords(210, 92));
        cityData.put("Mumbai", new CityCoords(230, 108));
        cityData.put("Pequim", new CityCoords(275, 75));
        cityData.put("Seul", new CityCoords(288, 78));
        cityData.put("Tóquio", new CityCoords(302, 80));
        cityData.put("Banguecoque", new CityCoords(260, 115));
        cityData.put("Jacarta", new CityCoords(262, 140));
        
        // Austrália / Oceania
        cityData.put("Perth", new CityCoords(270, 168));
        cityData.put("Adelaide", new CityCoords(285, 172));
        cityData.put("Melbourne", new CityCoords(292, 178));
        cityData.put("Sydney", new CityCoords(300, 172));
        cityData.put("Brisbane", new CityCoords(305, 162));
        cityData.put("Auckland", new CityCoords(322, 185));
    }

    @FXML
    void handleBack(ActionEvent event) {
        Navigation.navigate("/view/TelaWelcome.fxml");
    }

    @FXML
    void handleNext(ActionEvent event) {
        System.out.println("Next pressed: Região: " + cbRegiao.getValue() + ", Zona: " + cbZona.getValue());
    }

    @FXML
    public void handleRegiaoChange(ActionEvent event) {
        String regiaoSelecionada = cbRegiao.getValue();
        if (regiaoSelecionada != null) {
            atualizarZonas(regiaoSelecionada);
            pintarFaixaRegiao(regiaoSelecionada);
        }
    }

    @FXML
    public void handleZonaChange(ActionEvent event) {
        String zonaSelecionada = cbZona.getValue();
        if (zonaSelecionada != null) {
            marcarPontoZona(zonaSelecionada);
        }
    }

    @FXML
    public void initialize() {
        limparMapa();
    }

    private void limparMapa() {
        if (mapPane != null) {
            mapPane.getChildren().removeIf(node -> !(node instanceof javafx.scene.image.ImageView));
        }
    }

    private void pintarFaixaRegiao(String regiao) {
        limparMapa();
        double xInicio = 0, largura = 0;
        switch (regiao) {
            case "América": xInicio = 20; largura = 115; break;
            case "Europa": xInicio = 150; largura = 50; break;
            case "África": xInicio = 155; largura = 55; break;
            case "Ásia": xInicio = 200; largura = 115; break;
            case "Austrália": xInicio = 265; largura = 70; break;
        }
        if (largura > 0) {
            Rectangle faixa = new Rectangle(xInicio, 0, largura, 200);
            faixa.setFill(Color.web("#0078d7", 0.15));
            mapPane.getChildren().add(faixa);
        }
    }

    private void marcarPontoZona(String zona) {
        mapPane.getChildren().removeIf(node -> node instanceof Circle || node instanceof Label || 
            (node instanceof Rectangle && ((Rectangle)node).getFill().equals(Color.web("#0078d7", 0.4))));

        CityCoords coords = cityData.get(zona);
        if (coords != null) {
            Rectangle faixaFuso = new Rectangle(coords.x - 10, 0, 20, 200);
            faixaFuso.setFill(Color.web("#0078d7", 0.4));
            mapPane.getChildren().add(faixaFuso);

            Circle ponto = new Circle(coords.x, coords.y, 4, Color.RED);
            ponto.setStroke(Color.WHITE);
            ponto.setStrokeWidth(1);
            mapPane.getChildren().add(ponto);

            Label label = new Label(zona);
            label.setLayoutX(coords.x + 6);
            label.setLayoutY(coords.y - 20);
            label.setStyle("-fx-background-color: #3d3d3d; -fx-text-fill: white; -fx-padding: 2 5; -fx-background-radius: 3; -fx-font-size: 11px;");
            mapPane.getChildren().add(label);
        }
    }

    @FXML
    public void atualizarZonas(String regiao) {
        if (regiao == null) return;

        switch (regiao) {
            case "África":
                cbZona.setItems(FXCollections.observableArrayList("Cairo", "Joanesburgo", "Lagos", "Luanda", "Nairobi", "Túnis"));
                break;
            case "América":
                cbZona.setItems(FXCollections.observableArrayList("Buenos Aires", "Cidade do México", "Nova York", "Santiago", "São Paulo", "Toronto"));
                break;
            case "Ásia":
                cbZona.setItems(FXCollections.observableArrayList("Banguecoque", "Dubai", "Jacarta", "Mumbai", "Pequim", "Seul", "Tóquio"));
                break;
            case "Austrália":
                cbZona.setItems(FXCollections.observableArrayList("Adelaide", "Brisbane", "Melbourne", "Perth", "Sydney", "Auckland"));
                break;
            case "Europa":
                cbZona.setItems(FXCollections.observableArrayList("Berlim", "Lisboa", "Londres", "Madrid", "Moscou", "Paris", "Roma"));
                break;
            default:
                cbZona.getItems().clear();
                break;
        }
    }

}
