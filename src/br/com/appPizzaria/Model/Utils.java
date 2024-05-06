package br.com.appPizzaria.Model;

import br.com.appPizzaria.Model.Bebidas.Bebida;
import br.com.appPizzaria.Model.Funcionarios.Garcom;

public class Utils {
    public void chamarAnotarPedido(Garcom[] garcons, Bebida[] freezer){
        for(int i = 0; i < garcons.length; i++){
            if(garcons[i] != null && garcons[i].conta.logado){
                garcons[i].anotarPedido(freezer);
            }
        }
    }

}
