package br.com.appPizzaria.Model;

import br.com.appPizzaria.Contracts.IAutenticacao;
import br.com.appPizzaria.Contracts.IContratar;
import br.com.appPizzaria.Enums.EnumMes;
import br.com.appPizzaria.Model.Bebidas.Bebida;
import br.com.appPizzaria.Model.Funcionarios.Funcionario;
import br.com.appPizzaria.Model.Funcionarios.Data;
import br.com.appPizzaria.Model.Funcionarios.Garcom;

import java.util.Scanner;

public class Pizzaria implements IAutenticacao {
    public Scanner scanner;
    public String nomePizzaria;
    public Funcionario[] funcionarios;
    public Garcom[] garcons;
    public Bebida[] freezer;

    public Pizzaria(String nomePizzaria, int quantFuncionarios,int quantGarcons, int quantBebidas) {
        this.nomePizzaria = nomePizzaria;
        this.funcionarios = new Funcionario[quantFuncionarios];
        this.garcons = new Garcom[quantGarcons];
        this.freezer = new Bebida[quantBebidas];
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int entrar(String usuario, String senha){
        for(int i = 0; i < funcionarios.length; i++){
            if(funcionarios[i] != null && funcionarios[i].conta.usuario.equals(usuario) && funcionarios[i].conta.senha.equals(senha)){
                funcionarios[i].conta.isLogado();
                return funcionarios[i].conta.tipo.tipo;
            }
        }
        return 0;
    }

    @Override
    public boolean sair(){
        for(int i = 0; i < funcionarios.length; i++){
            if(funcionarios[i] != null && funcionarios[i].conta.logado){
                funcionarios[i].conta.isLogado();
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "<Pizzaria: Nome=" + this.nomePizzaria+ ">";
    }
}
