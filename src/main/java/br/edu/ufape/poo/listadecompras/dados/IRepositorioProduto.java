package br.edu.ufape.poo.listadecompras.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Produto;

@Repository
public interface IRepositorioProduto extends JpaRepository<Produto, Long> { //ver se realmente ten utilidade
	
	
}
