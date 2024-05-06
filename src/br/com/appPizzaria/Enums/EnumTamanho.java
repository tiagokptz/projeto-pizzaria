package br.com.appPizzaria.Enums;

public enum EnumTamanho {
    GRANDE("Grande"), MEDIA("Média"), PEQUENA("Pequena");

    public String tamanho;

    EnumTamanho(String tamanho){
        this.tamanho = tamanho;
    }
}
