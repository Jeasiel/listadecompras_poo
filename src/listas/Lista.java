package listas;
import java.util.ArrayList;

import produtos.*;

public class Lista {
    private String nome;
    private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    private String tipo;

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
     * @param quantidade Quantidade de produtos
     */
    public void adicionarProduto(String nome, double precoEstimado, int quantidade){
        if(!itemDuplicado(listaProdutos, nome, precoEstimado, quantidade)){
            Produto produto = new Produto(nome, precoEstimado, quantidade);
            listaProdutos.add(produto);
        }
    }

    /**
     * Função que remove todos os produtos da lista com o respectivo nome
     * @param nome Nome do produto
     * @return Retorna {@code true} se remover um objeto da lista
     */
    public boolean removerProduto(String nome){
        boolean removido = false;
        for(int i = 0; i < listaProdutos.size(); i++){
            if(listaProdutos.get(i).getNome() == nome){
                listaProdutos.remove(i);
                removido = true;
            }
        }
        return removido;
    }

    public boolean atualizarProduto(String nome, double precoEstimado, int quantidade){
        boolean atualizado = false;
        for(int i = 0; i < listaProdutos.size(); i++){
            if(nome == listaProdutos.get(i).getNome()){
                int quantidadeAnterior = listaProdutos.get(i).getQuantidade();
                listaProdutos.get(i).atualizar(precoEstimado, quantidadeAnterior += quantidade);
            }
        }
        return atualizado;
    }

    private boolean itemDuplicado(ArrayList<Produto> listaProdutos, String nome, double precoEstimado, int quantidade){
        boolean duplicata = false;
        for(int i = 0; i < listaProdutos.size(); i++){
            if(nome == listaProdutos.get(i).getNome()){
                int quantidadeAnterior = listaProdutos.get(i).getQuantidade();
                listaProdutos.get(i).atualizar(precoEstimado, quantidadeAnterior += quantidade);
                duplicata = true;
            }
        }
        return duplicata;
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
