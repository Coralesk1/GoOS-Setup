package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BotaoController {

    @FXML
    private Button btnInstalar;

    @FXML
    void efeitoEntrar() {
        // Aumenta o tamanho (zoom)
        btnInstalar.setScaleX(1.0);
        btnInstalar.setScaleY(1.0);

        // Cria um efeito de brilho intenso (Glow)
        javafx.scene.effect.DropShadow brilho = new javafx.scene.effect.DropShadow();
        brilho.setColor(javafx.scene.paint.Color.web("#ff0058")); // A cor rosa do GoOS
        brilho.setRadius(7); // O tamanho do brilho
        brilho.setSpread(0.5); // A intensidade

        btnInstalar.setEffect(brilho);

        // Muda a cor de fundo para um rosa mais claro (opcional)
        btnInstalar.setStyle("-fx-background-color: #ff2e7a; -fx-background-radius: 14;");
    }

    @FXML
    void efeitoSair() {
        // Volta ao tamanho original
        btnInstalar.setScaleX(1.0);
        btnInstalar.setScaleY(1.0);

        // Volta o brilho para o estado normal (ou remove)
        javafx.scene.effect.DropShadow brilhoNormal = new javafx.scene.effect.DropShadow();
        brilhoNormal.setColor(javafx.scene.paint.Color.web("#ff0058", 0.5)); // Mais transparente
        brilhoNormal.setRadius(20);

        btnInstalar.setEffect(brilhoNormal);

        // Volta para a cor padrão
        btnInstalar.setStyle("-fx-background-color: #ff0058; -fx-background-radius: 14;");
    }

    @FXML
    void efeitoPressionar() {
        btnInstalar.setScaleX(0.95); // Encolhe levemente
        btnInstalar.setScaleY(0.95);

        // Escurece a cor para parecer que afundou
        btnInstalar.setStyle("-fx-background-color: #c51162; -fx-background-radius: 14;");
    }

    @FXML
    void efeitoSoltar() {
        // Se o mouse ainda estiver em cima, volta para o tamanho de Hover
        btnInstalar.setScaleX(1.0);
        btnInstalar.setScaleY(1.0);
        btnInstalar.setStyle("-fx-background-color: #ff2e7a; -fx-background-radius: 14;");
    }


}