package br.edu.ufape.poo.listadecompras.negocios.excecoes;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;

public class ContaNaoEncontradaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public ContaNaoEncontradaException(Conta entity) {
		super("Conta não encontrada.");
		if(entity == null){
			System.out.println("Conta não referenciada.");
		}
    }

}
