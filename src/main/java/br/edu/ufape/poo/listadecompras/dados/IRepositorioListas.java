package br.edu.ufape.poo.listadecompras.dados;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Lista;

@Repository
public interface IRepositorioListas extends JpaRepository<Lista, Long>{ 

	//public ArrayList<Lista> findByConta(Conta conta);

}
