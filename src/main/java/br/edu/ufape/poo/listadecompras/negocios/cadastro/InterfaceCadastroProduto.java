package br.edu.ufape.poo.listadecompras.negocios.cadastro;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Lista;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Produto;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ListaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloIdException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NomeInvalidoException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ProdutoNaoEncontradoException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.QuantidadeInvalidaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ValorInvalidoException;


public interface InterfaceCadastroProduto {
    
    List<Produto> procurarProdutoLista(Lista lista) throws ListaNaoEncontradaException;

    void salvarProduto(Produto entity, Lista lista) throws ProdutoNaoEncontradoException, NomeInvalidoException, ValorInvalidoException, QuantidadeInvalidaException, ListaNaoEncontradaException;

	List<Produto> listarProdutos();

	void removerProduto(long id) throws NaoEncontradoPeloIdException;

	void removerProduto(Produto entity, Lista lista) throws ProdutoNaoEncontradoException, ListaNaoEncontradaException;

	Optional<Produto> localizarProdutoId(long id) throws NaoEncontradoPeloIdException;
}
