package br.com.appPizzaria.Contracts;

import br.com.appPizzaria.Model.Funcionarios.Garcom;

public interface IContratar {
    Garcom contratar();
    void demitir(Garcom[] garcons, String usuario);
}
