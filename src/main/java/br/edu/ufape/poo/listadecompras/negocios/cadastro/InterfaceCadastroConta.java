package br.edu.ufape.poo.listadecompras.negocios.cadastro;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloEmailException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloIdException;

public interface InterfaceCadastroConta {

    List<Conta> procurarContaEmail(String email) throws NaoEncontradoPeloEmailException;

    void salvarConta(Conta entity) throws ContaNaoEncontradaException;

	List<Conta> listarContas();

	void removerConta(Long id) throws NaoEncontradoPeloIdException;

	void removerConta(Conta entity) throws ContaNaoEncontradaException;

	Optional<Conta> localizarContaId(long id) throws NaoEncontradoPeloIdException;
}
