package br.edu.ufape.poo.listadecompras.negocios.basica;

public class Produto {
    private String nome;
    private double precoEstimado;
    private int quantidade;

    public Produto(String nome, double precoEstimado, int quantidade){
        this.nome = nome;
        this.precoEstimado = precoEstimado;
        this.quantidade = quantidade;
    }

    public void atualizar(double precoEstimado, int quantidade){
        this.precoEstimado = precoEstimado;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoEstimado() {
        return precoEstimado;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString(){
        return "Nome do produto: " + nome + ". Preço estimado: R$" + precoEstimado + ". Quantidade desejada: " + quantidade + ".";
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
