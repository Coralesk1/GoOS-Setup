package org.example.controller.tipoInstalacao;

public class Disk {

    private String identificador;
    private String modelo;
    private String capacidade;
    private String sistemaArquivos;

    public Disk(String identificador, String modelo, String capacidade, String sistemaArquivos) {
        this.identificador = "/dev/" + identificador;
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.sistemaArquivos = sistemaArquivos;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public String getSistemaArquivos() {
        return sistemaArquivos;
    }

    public void setSistemaArquivos(String sistemaArquivos) {
        this.sistemaArquivos = sistemaArquivos;
    }
}
