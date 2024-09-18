package br.edu.ufape.poo.listadecompras.negocios.cadastro;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Lista;

public interface InterfaceCadastroLista {
    
    List<Lista> procurarListaEmail(String email);

    Lista salvarLista(Lista entity);

	List<Lista> listarListas();

	void removerLista(Long id);

	void removerLista(Lista entity);

	Optional<Lista> localizarListaId(long id);
}
