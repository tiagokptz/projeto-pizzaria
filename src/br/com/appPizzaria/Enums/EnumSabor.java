package br.com.appPizzaria.Enums;

public enum EnumSabor{
    CALABRESA("Calabresa"), QUATRO_QUEIJOS("Quatro queijos"), CARNE_DE_SOL("Carne de sol"),
    CROCK("Crock"), FRANGO_CATUPIRY("Frango com catupiry"), PORTUGUESA("Portuguesa"), DOIS_AMORES("Dois amores"),
    BRIGADEIRO("Brigadeiro");

    public String sabor;

    EnumSabor(String sabor){
        this.sabor = sabor;
    }
}
