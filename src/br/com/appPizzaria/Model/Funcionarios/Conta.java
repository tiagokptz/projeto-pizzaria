package br.com.appPizzaria.Model.Funcionarios;

import br.com.appPizzaria.Enums.EnumTipoConta;

public class Conta {
    public String usuario;
    public String senha;
    public EnumTipoConta tipo;
    public boolean logado;

    public Conta(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
        this.logado = false;
    }

    public Conta(String usuario, String senha, EnumTipoConta tipo) {
        this.usuario = usuario;
        this.senha = senha;
        this.tipo = tipo;
    }

    public void isLogado() {
        this.logado = !this.logado;
    }

    public String getUsuario(){
        return this.usuario;
    }

    @Override
    public String toString() {
        if(this.tipo.tipo == 1){
            return "<Conta: Usuario=" + this.usuario + " | Gerente >";
        }
        return "<Conta: Usuario=" + this.usuario + " | Garçom >";
    }
}
