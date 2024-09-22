package br.edu.ufape.poo.listadecompras.negocios.cadastro;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaDuplicadaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.EmailInvalidoExeception;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloEmailException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloIdException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.SenhaErradaException;

public interface InterfaceCadastroConta {

    List<Conta> procurarContaEmail(String email) throws NaoEncontradoPeloEmailException;

    void salvarConta(Conta entity) throws ContaDuplicadaException, EmailInvalidoExeception;;

	List<Conta> listarContas();

	void removerConta(long id) throws NaoEncontradoPeloIdException;

	void removerConta(Conta entity) throws ContaNaoEncontradaException;

	Optional<Conta> localizarContaId(long id) throws NaoEncontradoPeloIdException;

	Conta login(String email, String senha) throws NaoEncontradoPeloEmailException, SenhaErradaException;
}
