package br.com.appPizzaria.Model.Pizzas;

import br.com.appPizzaria.Enums.EnumSabor;
import br.com.appPizzaria.Enums.EnumTamanho;


abstract public class Pizza {
    public EnumSabor sabor;
    public EnumTamanho tamanho;

    public Pizza(EnumSabor sabor, EnumTamanho tamanho) {
        this.sabor = sabor;
        this.tamanho = tamanho;
    }

    @Override
    public String toString(){
        return "<Pizza: Sabor= " + this.sabor.sabor + " | Tamanho=" + this.tamanho.tamanho + ">";
    }
}
