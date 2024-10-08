package br.edu.ufape.poo.listadecompras.negocios.entidade;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Lista {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String tipo;
    private boolean modelo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Produto> listaProdutos;

    public Lista(){
        nome = "Lista";
        tipo = "Indefinido";
    }

    public Lista(String nome){
        this.nome = nome;
        tipo = "Indefinido";
    }

    public Lista(String nome, String tipo){
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public String getTipo() {
        return tipo;
    }
    
    public boolean isModelo(){
        return this.modelo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public void setModelo(boolean modelo){
        this.modelo = modelo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
