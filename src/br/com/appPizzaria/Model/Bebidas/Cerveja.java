package br.com.appPizzaria.Model.Bebidas;

public class Cerveja extends Bebida{
    public boolean comAlcool;
    public Cerveja(String nome, double litros, double valor, int quant, boolean comAlcool) {
        super(nome, litros, valor, quant);
        this.comAlcool = comAlcool;
    }

    public Cerveja(String nome, double litros, boolean comAlcool){
        super(nome, litros);
        this.comAlcool = comAlcool;
    }

    @Override
    public String toString() {
        if(comAlcool){
            return "<Cerveja: " + super.toString() + ">";
        }
        return "<Cerveja: " + super.toString() + " | Sem álcool >";
    }
}
