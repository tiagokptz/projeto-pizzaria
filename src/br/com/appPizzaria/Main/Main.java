package br.com.appPizzaria.Main;

import br.com.appPizzaria.Enums.EnumMes;
import br.com.appPizzaria.Model.Bebidas.AguaMineral;
import br.com.appPizzaria.Model.Bebidas.Bebida;
import br.com.appPizzaria.Model.Bebidas.Cerveja;
import br.com.appPizzaria.Model.Bebidas.Refrigerante;
import br.com.appPizzaria.Model.Funcionarios.Data;
import br.com.appPizzaria.Model.Funcionarios.Funcionario;
import br.com.appPizzaria.Model.Funcionarios.Garcom;
import br.com.appPizzaria.Model.Funcionarios.Gerente;
import br.com.appPizzaria.Model.Pedido;
import br.com.appPizzaria.Model.Pizzaria;
import br.com.appPizzaria.Model.Pizzas.Pizza;
import br.com.appPizzaria.Model.Utils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Pizzaria pizzaria = new Pizzaria("Tarandela", 5, 4, 6);

        Gerente gerente = new Gerente("Tiago", 18, new Data(6, EnumMes.NOVEMBRO, 2005));
        gerente.criarConta(pizzaria.funcionarios, "tiagokptz", "12345");

        pizzaria.funcionarios[0] = gerente;

        Garcom garcom1 = new Garcom("Elias", 18, new Data(6, EnumMes.NOVEMBRO, 2005));
        garcom1.criarConta(pizzaria.funcionarios, "eliasfeio", "12345");

        pizzaria.funcionarios[1] = garcom1;

        pizzaria.garcons[0] = garcom1;

        Refrigerante refri0 = new Refrigerante("Coca-cola Zero", 1, 10, 25, true);
        Refrigerante refri = new Refrigerante("Coca-cola", 1, 10, 50, false);

        Cerveja cerveja = new Cerveja("Heineken", 0.6, 12.50, 50, true);
        Cerveja cerveja0 = new Cerveja("Heineken 0.0", 0.6, 12.50, 25, false);

        AguaMineral agua = new AguaMineral("Água mineral", 1, 8, 75, false);
        AguaMineral agua1 = new AguaMineral("Água mineral com Gás", 1, 2, 1, true);

        pizzaria.freezer[0] = refri0;
        pizzaria.freezer[1] = refri;
        pizzaria.freezer[2] = cerveja;
        pizzaria.freezer[3] = cerveja0;
        pizzaria.freezer[4] = agua;
        pizzaria.freezer[5] = agua1;

        Utils util = new Utils();

        while(true){
            System.out.println("________________________");
            System.out.println("Pizzaria " + pizzaria.nomePizzaria);
            System.out.println("[1] Login");
            System.out.println("[2] Sair");
            System.out.println("________________________");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if(opcao == 1){
                System.out.print("Usuario: ");
                String usuario = scanner.nextLine();

                System.out.print("Senha: ");
                String senha = scanner.nextLine();

                int tipo = pizzaria.entrar(usuario, senha);

                if(tipo == 1){
                    boolean continuar = true;
                    while(continuar){
                        System.out.println("________________________");
                        System.out.println("[1] Contratar garçom");
                        System.out.println("[2] Demitir garçom");
                        System.out.println("[3] Planilha de garçons");
                        System.out.println("[4] Sair");
                        System.out.println("________________________");
                        int opcaoGerente = scanner.nextInt();;
                        scanner.nextLine();

                        if(opcaoGerente == 1){
                            Garcom garcom = gerente.contratar();

                            while(true){
                                System.out.println("Cria conta: ");
                                System.out.print("Usuário: ");
                                String usuarioGarcom = scanner.nextLine();

                                System.out.print("Senha: ");
                                String senhaGarcom = scanner.nextLine();

                                boolean retorno = garcom.criarConta(pizzaria.funcionarios, usuarioGarcom, senhaGarcom);

                                if(retorno){
                                    gerente.adicionarFuncionario(pizzaria.funcionarios, garcom);
                                    gerente.adicionarGarcom(pizzaria.garcons, garcom);
                                    break;
                                } else{
                                    System.out.println("Usuário ja existe, crie outro.");
                                }
                            }

                        } else if(opcaoGerente == 2){
                            System.out.print("Informe o usuário do garçom: ");
                            String usuarioDemitir = scanner.nextLine();

                            gerente.demitir(pizzaria.garcons, usuarioDemitir);

                        } else if(opcaoGerente == 3){
                            gerente.listarGarcons(pizzaria.garcons);

                        } else if(opcaoGerente == 4){
                            continuar = pizzaria.sair();

                        } else{
                            System.out.println("Opção inválida");
                        }
                    }

                } else if(tipo == 2){
                    boolean continuar = true;
                    while(continuar){
                        System.out.println("________________________");
                        System.out.println("[1] Anotar pedido");
                        System.out.println("[2] Sair");
                        System.out.println("________________________");
                        int opcaoGarcom = scanner.nextInt();
                        scanner.nextLine();
                        if(opcaoGarcom == 1){
                            util.chamarAnotarPedido(pizzaria.garcons, pizzaria.freezer);

                        } else if(opcaoGarcom == 2){
                            continuar = pizzaria.sair();

                        } else{
                            System.out.println("Opção inválida.");
                        }
                    }

                } else{
                    System.out.println("Usuário ou senha inválidos!");
                }
            } else if(opcao == 2){
                break;
            } else{
                System.out.println("Opção inválida.");
            }
        }
    }
}
