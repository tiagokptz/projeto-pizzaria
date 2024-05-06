package br.com.appPizzaria.Contracts;

public interface IAutenticacao {
    int entrar(String usuario, String senha);
    boolean sair();
}
