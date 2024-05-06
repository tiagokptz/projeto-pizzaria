package br.com.appPizzaria.Contracts;

import br.com.appPizzaria.Model.Bebidas.Bebida;

public interface IAtendimento {
    void anotarPedido(Bebida[] freezer);
}
