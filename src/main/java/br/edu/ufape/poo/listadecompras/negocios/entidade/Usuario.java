package br.edu.ufape.poo.listadecompras.negocios.entidade;

import jakarta.persistence.Entity;

@Entity
public class Usuario extends Conta{
	
	public Usuario(String nome, String email, String senha) {
        super(nome, email, senha);
    }
}