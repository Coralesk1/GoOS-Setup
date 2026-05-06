package org.example.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

public class InstalandoController {

    @FXML
    private ProgressBar progressBar;

    @FXML
    public void initialize() {
        // Inicializa a barra em 0
        progressBar.setProgress(0);

        // Timeline para animar o progresso durante 5 segundos (5000ms)
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(progressBar.progressProperty(), 0)),
            new KeyFrame(Duration.seconds(5), new KeyValue(progressBar.progressProperty(), 1))
        );
        timeline.setCycleCount(1);
        timeline.play();
        
        timeline.setOnFinished(event -> {
            System.out.println("Instalação concluída!");
            // Aqui você poderia navegar para a próxima tela após a conclusão
        });
    }
}
