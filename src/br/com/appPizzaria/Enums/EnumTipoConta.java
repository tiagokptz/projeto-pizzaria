package br.com.appPizzaria.Enums;

public enum EnumTipoConta {
    GERENTE(1), GARCOM(2);

    public int tipo;

    EnumTipoConta(int tipo){
        this.tipo = tipo;
    }
}
