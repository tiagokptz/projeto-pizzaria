package br.com.appPizzaria.Model.Funcionarios;

import br.com.appPizzaria.Contracts.IContratar;
import br.com.appPizzaria.Enums.EnumMes;
import br.com.appPizzaria.Enums.EnumTipoConta;

import java.util.Scanner;

public class Gerente extends Funcionario implements IContratar {
    public Scanner scanner;
    public Gerente(String nome, int idade, Data dataDeNascimento) {
        super(nome, idade, dataDeNascimento);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public boolean criarConta(Funcionario[] funcionarios, String usuario, String senha) {
        this.conta = new Conta(usuario, senha, EnumTipoConta.GERENTE);
        return false; //so pra retorno alguma coisa
    }

    //trocar funcionarios por garcons
    public void listarGarcons(Garcom[] garcons){
        boolean planilhas = false;
        for(int i = 0; i < garcons.length; i++){
            if(garcons[i] != null){
                planilhas = true;
                System.out.println(garcons[i]);
            }
        }
        if(!planilhas){
            System.out.println("Não há garçons na planilha. Contrate-os.");
        }
    }

    public void adicionarFuncionario(Funcionario[] funcionarios, Garcom garcom){
        for(int i = 0; i < funcionarios.length; i++){
            if(funcionarios[i] == null){
                funcionarios[i] = garcom;
                break;
            }
        }
    }

    public void adicionarGarcom(Garcom[] garcons, Garcom garcom){
        for(int i = 0; i < garcons.length; i++){
            if(garcons[i] == null){
                garcons[i] = garcom;
                System.out.println("Contratado");
                break;
            }
        }
    }

    @Override
    public Garcom contratar(){
        String nome;
        int idade, dia, mes, ano;
        while(true){
            System.out.println("Preencha os dados: ");
            System.out.print("Nome: ");
            nome = scanner.nextLine();

            System.out.print("Idade: ");
            idade = scanner.nextInt();
            scanner.nextLine();

            if(idade >= 18){
                System.out.println("Data de nascimento(dd/mm/aaaa): ");
                System.out.print("Dia: ");
                dia = scanner.nextInt();
                scanner.nextLine();

                if(dia >= 1 && dia <= 31){
                    System.out.print("Mês: ");
                    mes = scanner.nextInt();
                    scanner.nextLine();

                    if(mes >= 1 && mes <= 12){
                        System.out.print("Ano: ");
                        ano = scanner.nextInt();
                        scanner.nextLine();
                        break;

                    } else{
                        System.out.println("Digite um mês válido.");
                    }
                } else{
                    System.out.println("Digite um dia válido.");
                }
            } else{
                System.out.println("Menor de idade não pode ser contratado");
            }
        }
        return new Garcom(nome, idade, new Data(dia, EnumMes.values()[mes], ano));
    }


    @Override
    public void demitir(Garcom[] garcons, String usuario){
        boolean demitido = false;
        for(int i = 0; i < garcons.length; i++){
            if(garcons[i] != null && garcons[i].conta.usuario.equals(usuario)){
                demitido = true;
                System.out.println(garcons[i].nome + " foi demitido.");
                garcons[i] = null;
                break;
            }
        }
        if(!demitido){
            System.out.printf("Usuário (%s) não foi encontrado.\n", usuario);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Conta=" + this.conta.toString() + ">";
    }
}
