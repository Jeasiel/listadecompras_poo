package br.edu.ufape.poo.listadecompras.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;

@Repository
public interface IRepositorioContas extends JpaRepository<Conta, Long>{
	
	public List<Conta> findByEmail(String email);

}
