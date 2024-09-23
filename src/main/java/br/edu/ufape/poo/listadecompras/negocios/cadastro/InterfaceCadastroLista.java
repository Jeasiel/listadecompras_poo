package br.edu.ufape.poo.listadecompras.negocios.cadastro;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Lista;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ListaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloIdException;

public interface InterfaceCadastroLista {
    
    List<Lista> procurarListaConta(Conta conta) throws ContaNaoEncontradaException;

    void salvarLista(Lista entity, Conta conta) throws ListaNaoEncontradaException, ContaNaoEncontradaException;

	List<Lista> listarListas();

	void removerLista(long id) throws NaoEncontradoPeloIdException;

	void removerLista(Lista entity, Conta conta) throws ListaNaoEncontradaException, ContaNaoEncontradaException;

	Optional<Lista> localizarListaId(long id) throws NaoEncontradoPeloIdException;
}
