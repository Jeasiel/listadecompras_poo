package br.edu.ufape.poo.listadecompras.negocios.entidade;

import jakarta.persistence.Entity;

@Entity
public class Administrador extends Conta {

	private int nivelPermissao;

	public Administrador(){
		super();
	}
	
    public Administrador(String nome, String email, String senha, int nivelPermissao) {
        super(nome, email, senha);
		this.nivelPermissao = nivelPermissao;
    }

	public int getNivelPermissao() {
		return nivelPermissao;
	}
	
	public void setNivelPermissao(int nivelPermissao) {
		this.nivelPermissao = nivelPermissao;
	}
}