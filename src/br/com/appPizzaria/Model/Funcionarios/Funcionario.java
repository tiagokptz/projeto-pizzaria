package br.com.appPizzaria.Model.Funcionarios;

abstract public class Funcionario {
    public String nome;
    public int idade;
    public Data dataDeNascimento;
    public Conta conta;

    public Funcionario(String nome, int idade, Data dataDeNascimento) {
        this.nome = nome;
        this.idade = idade;
        this.dataDeNascimento = dataDeNascimento;
        this.conta = null;
    }

    public boolean checarUsuario(Funcionario[] funcionarios, String usuario){
        for(int i = 0; i < funcionarios.length; i++){
            if(funcionarios[i] != null && funcionarios[i].conta.getUsuario().equals(usuario)){
                return false;
            }
        }
        return true;
    }

    public boolean criarConta(Funcionario[] funcionarios, String usuario, String senha){
        this.conta = new Conta(usuario, senha);
        return false; //isso nunca é usado mesmo entao coloquei qualquer coisa
    }

    @Override
    public String toString(){
        return "<Funcionário: Nome=" + this.nome + ", Idade=" + this.idade + ", Data de nascimento=" + this.dataDeNascimento.toString();
    }
}
