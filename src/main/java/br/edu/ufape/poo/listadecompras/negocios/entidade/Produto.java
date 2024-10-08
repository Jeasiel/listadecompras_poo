package br.edu.ufape.poo.listadecompras.negocios.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private double precoEstimado;
    private int quantidade;

    public Produto(){
        
    }

    public Produto(String nome, double precoEstimado, int quantidade){
        this.nome = nome;
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
    
    public long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrecoEstimado(double precoEstimado) {
        this.precoEstimado = precoEstimado;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public void setId(long id) {
        this.id = id;
    }
}
