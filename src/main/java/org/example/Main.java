package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.controller.ConfigInstalacao;
import org.example.controller.Navigation;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Navigation.setStage(primaryStage);
        
        primaryStage.setTitle("Install GoOS");
        
        // Inicia com a tela de Welcome
        Navigation.navigate("/view/TelaWelcome.fxml");
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/*
 * - extends é para que o Main se torna uma aplicação grafica
 * - No Main o metodo launch() é responsavel por inicializar o ambiemte JavaFX , e chama internamente o metodo start()
 * - o metodo start() é onde tudo começa , pois é ela que defini a janela
 * - FXMLLoader esse comando le o que tem no (fxml) e transforma em um objeto java Parent
 * - Scene é o conteudo da janela
 * - primaryStage.show(): Por padrão, a janela é criada invisível. Esse comando a torna visível para o usuário.
 * */
