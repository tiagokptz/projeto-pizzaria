package br.com.appPizzaria.Model.Bebidas;

public class Refrigerante extends Bebida{
    public boolean light;

    public Refrigerante(String nome, double litros, double valor, int quant, boolean light) {
        super(nome, litros, valor, quant);
        this.light = light;
    }

    public Refrigerante(String nome, double litros, boolean light){
        super(nome, litros);
        this.light = light;
    }

    //por enquanto vai ficar assim
    @Override
    public String toString() {
        if(light){
            return "<Refrigerante: " + super.toString() + " | Sem açúcar >";
        }
        return "<Refrigerante: " + super.toString() + ">";
    }
}
