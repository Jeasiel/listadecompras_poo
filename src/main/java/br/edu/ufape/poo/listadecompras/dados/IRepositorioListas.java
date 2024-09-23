package br.edu.ufape.poo.listadecompras.dados;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Lista;

@Repository
public interface IRepositorioListas extends JpaRepository<Lista, Long>{ 

}
