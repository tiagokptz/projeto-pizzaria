package br.com.appPizzaria.Model.Bebidas;

public class AguaMineral extends Bebida{
    public boolean comGas;

    public AguaMineral(String nome, double litros, double valor, int quant, boolean comGas) {
        super(nome, litros, valor, quant);
        this.comGas = comGas;
    }

    public AguaMineral(String nome, double litros, boolean comGas){
        super(nome, litros);
        this.comGas = comGas;
    }

    @Override
    public String toString() {
        if(comGas){
            return "<Água: " + super.toString() + " | Com gás >";
        }
        return "<Água: " + super.toString() + ">";
    }
}
