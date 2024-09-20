package br.edu.ufape.poo.listadecompras.negocios.cadastro;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;

public interface InterfaceCadastroConta {

    List<Conta> procurarContaEmail(String email);

    void salvarConta(Conta entity);

	List<Conta> listarContas();

	void removerConta(Long id);

	void removerConta(Conta entity);

	Optional<Conta> localizarContaId(long id);
}
