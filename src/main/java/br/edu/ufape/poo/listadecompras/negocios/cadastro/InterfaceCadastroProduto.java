package br.edu.ufape.poo.listadecompras.negocios.cadastro;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Lista;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Produto;

public interface InterfaceCadastroProduto {
    
    List<Produto> procurarProdutoLista(Lista lista);

    void salvarProduto(Produto entity);

	List<Produto> listarProdutos();

	void removerProduto(Long id);

	void removerProduto(Produto entity);

	Optional<Produto> localizarProdutoId(long id);
}
