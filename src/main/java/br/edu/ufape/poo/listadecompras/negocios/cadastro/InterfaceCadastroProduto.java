package br.edu.ufape.poo.listadecompras.negocios.cadastro;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Lista;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Produto;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ListaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloIdException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ProdutoNaoEncontradoException;


public interface InterfaceCadastroProduto {
    
    List<Produto> procurarProdutoLista(Lista lista) throws ListaNaoEncontradaException;

    void salvarProduto(Produto entity) throws ProdutoNaoEncontradoException, ProdutoNaoEncontradoException;

	List<Produto> listarProdutos();

	void removerProduto(Long id) throws NaoEncontradoPeloIdException;

	void removerProduto(Produto entity) throws ProdutoNaoEncontradoException;

	Optional<Produto> localizarProdutoId(long id) throws NaoEncontradoPeloIdException;
}
