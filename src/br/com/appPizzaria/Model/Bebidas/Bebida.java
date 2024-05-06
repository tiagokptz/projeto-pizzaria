package br.com.appPizzaria.Model.Bebidas;

abstract public class Bebida {
    public String nome;
    public double litros;
    private double valor;
    private int quant;
    private boolean disponivel;

    public Bebida(String nome, double litros, double valor, int quant) {
        this.nome = nome;
        this.litros = litros;
        this.valor = valor;
        this.quant = quant;
        this.disponivel = true;
    }
    public Bebida(String nome, double litros){
        this.nome = nome;
        this.litros = litros;
        this.quant = 1;

    }

    public void diminuirQuant(){
        this.quant--;
        if(this.quant == 0){
            mudarDisponibilidade();
        }
    }

    public void mudarDisponibilidade(){
        this.disponivel = !this.disponivel;
    }

    public double getValor() {
        return this.valor;
    }

    public boolean getDisponivel(){
        return this.disponivel;
    }

    @Override
    public String toString() {
        return "Nome=" + this.nome + " | Litros=" + this.litros + " | Quantidade=" + this.quant;
    }
}
