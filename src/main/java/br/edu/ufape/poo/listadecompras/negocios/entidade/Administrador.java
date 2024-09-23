package br.edu.ufape.poo.listadecompras.negocios.entidade;

import jakarta.persistence.Entity;

@Entity
public class Administrador extends Conta {

	public Administrador(){
		super();
	}
	
    public Administrador(String nome, String email, String senha) {
        super(nome, email, senha);
    }
}