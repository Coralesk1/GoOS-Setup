package org.example.controller;

public class ConfigInstalacao {

    private static String idioma;
    private static String regiao;
    private static String zona;

    public static String getIdioma() {
        return idioma;
    }

    public static void setIdioma(String idioma) {
        ConfigInstalacao.idioma = idioma;
    }

    public static String getRegiao() {
        return regiao;
    }

    public static void setRegiao(String regiao) {
        ConfigInstalacao.regiao = regiao;
    }

    public static String getZona() {
        return zona;
    }

    public static void setZona(String zona) {
        ConfigInstalacao.zona = zona;
    }
}
