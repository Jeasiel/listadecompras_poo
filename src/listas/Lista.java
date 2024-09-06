package listas;
import java.util.ArrayList;

import produtos.*;

public class Lista { 
    private String nome;
    private String tipo;
    private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

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
    
    /**
     * Função que adiciona um produto à lista
     * @param nome Nome do produto
     * @param precoEstimado Preço estimado do produto
     * @param quantidade Quantidade do produto
     */
    public void adicionarProduto(String nome, double precoEstimado, int quantidade){
        Produto produto = new Produto(nome, precoEstimado, quantidade);
        listaProdutos.add(produto);
    }

    /**
     * Função que remove todos os produtos da lista com o respectivo nome
     * @param nome Nome do produto
     * @return Retorna {@code true} se remover um objeto da lista
     */
    public boolean removerProduto(String nome){
        boolean removido = false;
        for(int i = 0; i < listaProdutos.size(); i++){
            if(listaProdutos.get(i).getNome().equals(nome)){
                listaProdutos.remove(i);
                removido = true;
            }
        }
        return removido;
    }

    public void removerProdutoNoIndice(int posicao){
        listaProdutos.remove(posicao);
    }

    public boolean atualizarProduto(String nome, double precoEstimado, int quantidade){
        boolean atualizado = false;
        for(int i = 0; i < listaProdutos.size(); i++){
            if(listaProdutos.get(i).getNome().equals(nome)){
                listaProdutos.get(i).atualizar(precoEstimado, quantidade);
                atualizado = true;
            }
        }
        return atualizado;
    }

    public void atualizarProdutoNoIndice(int posicao, double precoEstimado, int quantidade){
        listaProdutos.get(posicao).atualizar(precoEstimado, quantidade);
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public String getTipo() {
        return tipo;
    }
}
