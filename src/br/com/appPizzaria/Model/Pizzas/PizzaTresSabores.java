package br.com.appPizzaria.Model.Pizzas;

import br.com.appPizzaria.Enums.EnumSabor;
import br.com.appPizzaria.Enums.EnumTamanho;

public class PizzaTresSabores extends Pizza{
    public EnumSabor segundoSabor;
    public EnumSabor terceiroSabor;

    public PizzaTresSabores(EnumSabor sabor, EnumSabor segundoSabor, EnumSabor terceiroSabor, EnumTamanho tamanho) {
        super(sabor, tamanho);
        this.segundoSabor = segundoSabor;
        this.terceiroSabor = terceiroSabor;
    }

    @Override
    public String toString() {
        return "<Pizza: Sabor= " + this.sabor.sabor + " | " + this.segundoSabor.sabor + " | " + this.terceiroSabor.sabor
                + "| Tamanho=" + this.tamanho.tamanho + ">";
    }
}
