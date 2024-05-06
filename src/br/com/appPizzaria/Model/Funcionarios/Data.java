package br.com.appPizzaria.Model.Funcionarios;

import br.com.appPizzaria.Enums.EnumMes;

public class Data {
    public int dia;
    public EnumMes mes;
    public int ano;

    public Data(int dia, EnumMes mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "<Data: " + this.dia + "/" + this.mes.mes + "/" + this.ano + ">";
    }
}
