package br.com.appPizzaria.Model.Funcionarios;

import br.com.appPizzaria.Contracts.IAtendimento;
import br.com.appPizzaria.Enums.EnumTipoConta;
import br.com.appPizzaria.Model.Bebidas.Bebida;
import br.com.appPizzaria.Model.Pedido;

import java.util.Scanner;

public class Garcom extends Funcionario implements IAtendimento {

    public Scanner scanner;
    public int quantMesasAtendidas;
    public Pedido pedido;

    public Garcom(String nome, int idade, Data dataDeNascimento) {
        super(nome, idade, dataDeNascimento);
        this.pedido = null;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarPedido(){
        System.out.println("________________________");
        System.out.println("Pizzas: ");
        for(int i = 0; i < this.pedido.pizzas.length; i++){
            if(this.pedido.pizzas[i] != null){
                System.out.println(this.pedido.pizzas[i]);
            }
        }
        System.out.println();

        if(this.pedido.bebidas != null){
            System.out.println("Bebidas: ");
            for(int i = 0; i < this.pedido.bebidas.length; i++){
                if(this.pedido.bebidas[i] != null){
                    System.out.println(this.pedido.bebidas[i]);
                }
            }
        }

        System.out.println("________________________");
        System.out.printf("Total: %.2f \n", this.pedido.valor);
    }

    @Override
    public void anotarPedido(Bebida[] freezer){
        boolean pedidoAnotado = false;
        while(true){
            System.out.print("Número da mesa: ");
            int numeroDaMesa = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Número de pizzas: ");
            int quantPizzas = scanner.nextInt();
            scanner.nextLine();

            if(quantPizzas == 0){
                System.out.println("O pedido não pode ficar sem pizzas.");
            } else{
                System.out.print("Número de bebidas: ");
                int quantBebidas = scanner.nextInt();
                scanner.nextLine();

                if(quantBebidas == 0){
                    this.pedido = new Pedido(numeroDaMesa, quantPizzas);
                } else{
                    this.pedido = new Pedido(numeroDaMesa, quantPizzas, quantBebidas);

                    this.pedido.mostrarFreezer(freezer);
                    for(int i = 0; i < quantBebidas; i++){
                        System.out.println("[1] Refrigerante \n[2] Cerveja \n[3] Água mineral");
                        int tipoBebida = scanner.nextInt();
                        scanner.nextLine();

                        if(tipoBebida != 1 && tipoBebida != 2 && tipoBebida != 3){
                            System.out.println("Opção inválida;");
                        } else{
                            System.out.print("Nome: ");
                            String nome = scanner.nextLine();

                            System.out.print("Litros: ");
                            double litros = scanner.nextDouble();
                            scanner.nextLine();

                            this.pedido.reservarBebida(freezer, tipoBebida, nome, litros);
                        }
                    }
                }

                for(int i = 0; i < quantPizzas; i++){
                    System.out.printf("Quantidade de sabores da %sª pizza: ", i + 1);
                    int quantSabores = scanner.nextInt();
                    scanner.nextLine();

                    if(quantSabores != 0){
                        pedidoAnotado = true;
                        this.pedido.mostrarSabores();
                        this.pedido.mostrarTamanhosPizza();

                        if(quantSabores == 1){
                            this.pedido.montarPizzaUmSabor();

                        } else if(quantSabores == 2){
                            this.pedido.montarPizzaDoisSabores();

                        } else if(quantSabores == 3){
                            this.pedido.montarPizzaTresSabores();

                        } else {
                            System.out.println("Uma pizza só pode ter até três sabores.");
                        }
                    } else{
                        System.out.println("A pizza precisa ter um sabor.");
                    }
                }
                if(pedidoAnotado){
                    this.quantMesasAtendidas++;
                    this.pedido.calcularPreco();
                    this.mostrarPedido();
                    break;
                }
            }
        }
    }

    @Override
    public boolean checarUsuario(Funcionario[] funcionarios, String usuario) {
        return super.checarUsuario(funcionarios, usuario);
    }

    @Override
    public boolean criarConta(Funcionario[] funcionarios, String usuario, String senha) {
        boolean retorno = this.checarUsuario(funcionarios, usuario);
        if(retorno){
            this.conta = new Conta(usuario, senha, EnumTipoConta.GARCOM);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ", Conta=" + this.conta.toString() + ">";
    }
}
