package br.com.appPizzaria.Model.Pizzas;

import br.com.appPizzaria.Enums.EnumSabor;
import br.com.appPizzaria.Enums.EnumTamanho;

public class PizzaDoisSabores extends Pizza{
    public EnumSabor segundoSabor;

    public PizzaDoisSabores(EnumSabor sabor, EnumSabor segundoSabor, EnumTamanho tamanho) {
        super(sabor, tamanho);
        this.segundoSabor = segundoSabor;
    }

    @Override
    public String toString() {
        return "<Pizza: Sabor= " + this.sabor.sabor + " | " + this.segundoSabor.sabor + "| Tamanho=" + this.tamanho.tamanho + ">";
    }
}
