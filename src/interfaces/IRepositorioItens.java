package interfaces;

import java.util.ArrayList;
import produtos.Produto;

public interface IRepositorioItens { //ver se realmente ten utilidade
	
	public ArrayList<Produto> listaProdutos = new ArrayList<>();
	
	public void adicionarProduto(String nome, double precoEstimado, int quantidade);
	
	public boolean removerProduto(String nome);
	
	public void removerProdutoNoIndice(int posicao);
	
	public boolean atualizarProduto(String nome, double precoEstimado, int quantidade);
	
	public void atualizarProdutoNoIndice(int posicao, double precoEstimado, int quantidade);
	
}
