package br.com.appPizzaria.Model;

import br.com.appPizzaria.Contracts.ICalcular;
import br.com.appPizzaria.Enums.EnumSabor;
import br.com.appPizzaria.Enums.EnumTamanho;
import br.com.appPizzaria.Model.Bebidas.AguaMineral;
import br.com.appPizzaria.Model.Bebidas.Bebida;
import br.com.appPizzaria.Model.Bebidas.Cerveja;
import br.com.appPizzaria.Model.Bebidas.Refrigerante;
import br.com.appPizzaria.Model.Pizzas.Pizza;
import br.com.appPizzaria.Model.Pizzas.PizzaDoisSabores;
import br.com.appPizzaria.Model.Pizzas.PizzaTresSabores;
import br.com.appPizzaria.Model.Pizzas.PizzaUmSabor;

import java.util.Scanner;

public class Pedido implements ICalcular{
    public Scanner scanner;
    public int numeroDaMesa;
    public Pizza[] pizzas;
    public PizzaUmSabor pizzaUmSabor;
    public PizzaDoisSabores pizzaDoisSabores;
    public PizzaTresSabores pizzaTresSabores;
    public Bebida[] bebidas;
    public double valor = 0;

    public Pedido(int numeroDaMesa, int quantPizzas){
        this.numeroDaMesa = numeroDaMesa;
        this.pizzas = new Pizza[quantPizzas];
        this.pizzaUmSabor = null;
        this.pizzaDoisSabores = null;
        this.pizzaTresSabores = null;
        this.scanner = new Scanner(System.in);
    }

    public Pedido(int numeroDaMesa, int quantPizzas, int quantBebidas){
        this.numeroDaMesa = numeroDaMesa;
        this.pizzas = new Pizza[quantPizzas];
        this.bebidas = new Bebida[quantBebidas];
        this.pizzaUmSabor = null;
        this.pizzaDoisSabores = null;
        this.pizzaTresSabores = null;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void calcularPrecoPizza(Pizza pizza){
        double valorAux = 0;
        double valorCadaSaborExtra = 8;
        if(pizza.tamanho.tamanho.equals("Grande")){
            double valorPizzaGrande = 33;
            if(pizza instanceof PizzaUmSabor){
                valorAux += valorPizzaGrande;
            } else if(pizza instanceof PizzaDoisSabores){
                valorAux += (valorPizzaGrande + valorCadaSaborExtra);
            } else if(pizza instanceof PizzaTresSabores){
                valorAux += (valorPizzaGrande + (valorCadaSaborExtra * 2));
            }
        } else if(pizza.tamanho.tamanho.equals("Média")){
            double valorPizzaMedia = 28;
            if(pizza instanceof PizzaUmSabor){
                valorAux += valorPizzaMedia;
            } else if(pizza instanceof PizzaDoisSabores){
                valorAux += (valorPizzaMedia + valorCadaSaborExtra);
            } else if(pizza instanceof PizzaTresSabores){
                valorAux += (valorPizzaMedia + (valorCadaSaborExtra * 2));
            }
        } else if(pizza.tamanho.tamanho.equals("Pequena")){
            double valorPizzaPequena = 23;
            if(pizza instanceof PizzaUmSabor){
                valorAux += valorPizzaPequena;
            } else if(pizza instanceof PizzaDoisSabores){
                valorAux += (valorPizzaPequena + valorCadaSaborExtra);
            } else if(pizza instanceof PizzaTresSabores){
                valorAux += (valorPizzaPequena + (valorCadaSaborExtra * 2));
            }
        }
        this.valor += valorAux;
    }

    public void calcularPreco(){
        for(int i = 0; i < this.pizzas.length; i++){
            if(this.pizzas[i] != null){
                calcularPrecoPizza(this.pizzas[i]);
            }
        }
    }

    public void mostrarFreezer(Bebida[] freezer){
        System.out.println("________________________");
        for(int i = 0; i < freezer.length; i++){
            System.out.printf("[%d] %s", i + 1, freezer[i]);
            System.out.println();
        }
        System.out.println("________________________");
    }

    public void mostrarSabores(){
        System.out.println("________________________");
        System.out.println("Sabores:");
        for(int i = 0; i < EnumSabor.values().length; i++){
            String sabores = EnumSabor.values()[i].sabor;
            System.out.printf("[%d] %s\n", i, sabores);
        }
        System.out.println("________________________");
    }

    public void mostrarTamanhosPizza(){
        System.out.println("Tamanhos:");
        for(int i = 0; i < EnumTamanho.values().length; i++){
            String tamanhos = EnumTamanho.values()[i].tamanho;
            System.out.printf("[%d] %s \n", i, tamanhos);
        }
        System.out.println("________________________");
    }

    public void adicionarPizzasPedido(Pizza pizza){
        for(int i = 0; i < this.pizzas.length; i++){
            if(this.pizzas[i] == null){
                this.pizzas[i] = pizza;
                break;
            }
        }
    }

    public void montarPizzaUmSabor(){
        System.out.print("Numero do sabor: ");
        int numSabor = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tamanho: ");
        int tamanho = scanner.nextInt();
        scanner.nextLine();

        this.pizzaUmSabor = new PizzaUmSabor(EnumSabor.values()[numSabor], EnumTamanho.values()[tamanho]);
        this.adicionarPizzasPedido(pizzaUmSabor);
    }

    public void montarPizzaDoisSabores(){
        while(true){
            System.out.print("Numero do primeiro Sabor: ");
            int numPrimeiroSabor = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Numero do segundo sabor: ");
            int numSegundoSabor = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Tamanho: ");
            int tamanho = scanner.nextInt();
            scanner.nextLine();

            if(numPrimeiroSabor != numSegundoSabor){
                this.pizzaDoisSabores = new PizzaDoisSabores(EnumSabor.values()[numPrimeiroSabor],
                        EnumSabor.values()[numSegundoSabor], EnumTamanho.values()[tamanho]);

                this.adicionarPizzasPedido(pizzaDoisSabores);
                break;

            } else{
                System.out.println("As pizzas precisam ter sabores diferente.");
            }
        }
    }

    public void montarPizzaTresSabores(){
        while(true){
            System.out.print("Numero do primeiro sabor: ");
            int numPrimeiroSabor = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Numero do segundo sabor: ");
            int numSegundoSabor = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Numero do terceiro sabor: ");
            int numTerceiroSabor = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Tamanho: ");
            int tamanho = scanner.nextInt();
            scanner.nextLine();

            if(numPrimeiroSabor != numSegundoSabor && numPrimeiroSabor != numTerceiroSabor && numSegundoSabor != numTerceiroSabor){
                this.pizzaTresSabores = new PizzaTresSabores(EnumSabor.values()[numPrimeiroSabor],
                        EnumSabor.values()[numSegundoSabor], EnumSabor.values()[numTerceiroSabor], EnumTamanho.values()[tamanho]);

                this.adicionarPizzasPedido(pizzaTresSabores);
                break;

            } else{
                System.out.println("As pizzas precisam ter sabores diferente.");
            }
        }
    }

    public void adicionarBebidaPedido(Bebida bebida){
        for(int i = 0; i < this.bebidas.length; i++){
            if(this.bebidas[i] == null){
                this.bebidas[i] = bebida;
                break;
            }
        }
    }

    public void reservarBebida(Bebida[] freezer, int tipoBebida, String nome, double litros){
        boolean bebidaEncontrada = false;
        for(int i = 0; i < freezer.length; i++){
            if(freezer[i] != null && freezer[i].nome.equalsIgnoreCase(nome) && freezer[i].litros == litros) {//problema ta aqui
                bebidaEncontrada = true;
                if(freezer[i].getDisponivel()) {
                    if (tipoBebida == 1 && freezer[i] instanceof Refrigerante) {
                        Refrigerante refriReservado = new Refrigerante(freezer[i].nome, freezer[i].litros, ((Refrigerante) freezer[i]).light);
                        this.adicionarBebidaPedido(refriReservado);
                        freezer[i].diminuirQuant();
                        this.valor += freezer[i].getValor();
                        break;

                    } else if (tipoBebida == 2 && freezer[i] instanceof Cerveja) {
                        Cerveja cervejaReservada = new Cerveja(freezer[i].nome, freezer[i].litros, ((Cerveja) freezer[i]).comAlcool);
                        this.adicionarBebidaPedido(cervejaReservada);
                        freezer[i].diminuirQuant();
                        this.valor += freezer[i].getValor();
                        break;

                    } else if (tipoBebida == 3 && freezer[i] instanceof AguaMineral) {
                        AguaMineral aguaReservada = new AguaMineral(freezer[i].nome, freezer[i].litros, ((AguaMineral) freezer[i]).comGas);
                        this.adicionarBebidaPedido(aguaReservada);
                        freezer[i].diminuirQuant();
                        this.valor += freezer[i].getValor();
                        break;

                    }
                } else{
                    System.out.printf("%s acabou.\n", nome);
                }
            }
        }
        if(!bebidaEncontrada){
            System.out.println("Não tem esse bebida no freezer.");
        }
    }

    @Override
    public String toString() {
        return "<Pedido: Numero da Mesa=" + this.numeroDaMesa + " | Valor=" + this.valor + ">";
    }
}
