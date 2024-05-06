package br.com.appPizzaria.Enums;

public enum EnumMes {
    JANEIRO(1), FEVEREIRO(2), MARCO(3), ABRIL(4), MAIO(5),
    JUNHO(6), JULHO(7), AGOSTO(8), SETEMBRO(9), OUTUBRO(10),
    NOVEMBRO(11), DEZEMBRO(12);

    public int mes;

    EnumMes(int mes){
        this.mes = mes;
    }
}
