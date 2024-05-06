package br.com.appPizzaria.Model.Pizzas;

import br.com.appPizzaria.Enums.EnumSabor;
import br.com.appPizzaria.Enums.EnumTamanho;

public class PizzaUmSabor extends Pizza{
    public PizzaUmSabor(EnumSabor sabor, EnumTamanho tamanho) {
        super(sabor, tamanho);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
