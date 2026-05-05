package org.example.controller.tipoInstalacao;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.controller.Navigation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TipoInstalacaoController {

    @FXML
    private Button btnBack;
    @FXML
    private Button btnNext;

    @FXML
    private TableView<Disk> tableViewDiscos;

    @FXML
    private TableColumn<Disk, String> colIdentificador;
    @FXML
    private TableColumn<Disk, String> colModelo;
    @FXML
    private TableColumn<Disk, String> colCapacidade;
    @FXML
    private TableColumn<Disk, String> colSistema;


    @FXML
    public void initialize() throws IOException {

        // Vincula a coluna "Identificador" ao campo "identificador" da classe Disk
        colIdentificador.setCellValueFactory(new PropertyValueFactory<>("identificador"));

        // Vincula a coluna "Modelo/Nome" ao campo "modelo" da classe Disk
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));

        // Vincula a coluna "Capacidade" ao campo "capacidade" da classe Disk
        colCapacidade.setCellValueFactory(new PropertyValueFactory<>("capacidade"));

        // Vincula a coluna "Sistema de arquivos" ao campo "sistemaArquivos"
        colSistema.setCellValueFactory(new PropertyValueFactory<>("sistemaArquivos"));

        listaDiscos();
    }

    @FXML
    void handleBack(ActionEvent event) {
        Navigation.navigate("/view/TelaTimeZone.fxml");
    }

    @FXML
    void handleNext(ActionEvent event) {

        /*validar se selelecionou agum disco*/

        /*if (idiomaSelecionado == null || idiomaSelecionado.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Seleção Necessária");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um idioma antes de continuar.");
            alert.showAndWait();
            return;
        }*/


        /*Navigation.navigate("/view/TelaTimeZone.fxml");*/

        System.out.println("Fim da navegação.");
    }

    @FXML
    public void listaDiscos() {
        List<Disk> listaDeDiscos = new ArrayList<>();

        try {
            // -d: apenas discos, -n: sem cabeçalho, -o: colunas escolhidas (incluindo FSTYPE)
            Process process = new ProcessBuilder("lsblk", "-d", "-n", "-o", "NAME,MODEL,SIZE,FSTYPE").start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                // Trim tira espaços sobrando nas pontas
                String[] partes = line.trim().split("\\s+", 4); // Divide em no máximo 4 partes

                if (partes.length >= 3) {
                    String nome = partes[0];
                    // Se não houver modelo (alguns discos de VM não trazem modelo), coloca "Desconhecido"
                    String modelo = (partes.length > 1) ? partes[1] : "Disco Genérico";
                    String tamanho = (partes.length > 2) ? partes[2] : "0B";
                    // Se não houver sistema de arquivos, define como "Vazio"
                    String sistema = (partes.length > 3) ? partes[3] : "Vazio/Desconhecido";

                    listaDeDiscos.add(new Disk(nome, modelo, tamanho, sistema));
                }
            }

            // Atualiza a tabela na tela
            tableViewDiscos.getItems().setAll(listaDeDiscos);

        } catch (Exception e) {
            System.err.println("Erro ao listar discos: " + e.getMessage());
        }
    }

}
