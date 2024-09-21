package br.edu.ufape.poo.listadecompras.negocios.fachada;

import java.util.ArrayList;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Lista;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Produto;

public class FachadaUsuario {
    private ArrayList<Lista> arrayListas = new ArrayList<>();
	//ver como aplicar o conceito de listas globais

    public void criarLista(){
        //ver como se aplicaria para os varios construtores de listas
    }

    public void editarLista(Lista l){
        //fazer método
    }
	
	public void adicionarLista(Lista l) {
		//Em construção
		
		
		arrayListas.add(l);
	}

	public void removerLista(Lista l) {
		//Em construção

		if(consultarLista(l) == -1) {
			//throwException
		}
		else {
			arrayListas.remove(consultarLista(l)); //remove com base no index dado;
		}
		
	}
	
	public void atualizarLista(Lista l) {
		//Em construção
		
		if(consultarLista(l) == -1) {
			//throwException
		}
		else {
			Lista e = arrayListas.get(consultarLista(l)); //retorna o index da lista correta
			editarLista(e);
		}
		
	}
	
	public int consultarLista(Lista l) {	
		//Em construção
		
		int index = arrayListas.indexOf(l);
		
		if(index >= 0) {
			return index;
		}
		
		return -1;
		
		
	}
	
	public ArrayList<Lista> getListas() {
		//Em construção
		
		return arrayListas;
	}
	
	public void setListas(ArrayList<Lista> arrayLista) {
		//Em construção
		
		this.arrayListas.clear();
		this.arrayListas.addAll(arrayLista);
	}

    public ArrayList<Lista> getArrayListas() {
        return arrayListas;
    }

    public void setArrayListas(ArrayList<Lista> arrayListas) {
        this.arrayListas = arrayListas;
    }
    
	//passar parte para a fachada -------------------- Dividir
    
    private ArrayList<Produto> listaProdutos = new ArrayList<>();
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
                //listaProdutos.get(i).atualizar(precoEstimado, quantidade);
                atualizado = true;
            }
        }
        return atualizado;
    }

    public void atualizarProdutoNoIndice(int posicao, double precoEstimado, int quantidade){
        //listaProdutos.get(posicao).atualizar(precoEstimado, quantidade);
    }

	//Vai para negócio
    public void editarConta(String nome, String email, String senha){
        if(nome != null){
            //this.nome = nome;
        }
        if(email != null){
            //this.email = email;
        }
        if(senha != null){
            //this.senha = senha;
        }
    }
}
