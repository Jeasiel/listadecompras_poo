package br.edu.ufape.poo.listadecompras.negocios.cadastro;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Produto;

public interface InterfaceCadastroItens {
    
    List<Produto> procurarProdutoEmail(String email);

    Produto salvarProduto(Produto entity);

	List<Produto> listarProdutos();

	void removerProduto(Long id);

	void removerProduto(Produto entity);

	Optional<Produto> localizarProdutoId(long id);
}
