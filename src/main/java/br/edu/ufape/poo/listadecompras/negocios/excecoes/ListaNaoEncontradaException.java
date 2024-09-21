package br.edu.ufape.poo.listadecompras.negocios.excecoes;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Lista;

public class ListaNaoEncontradaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public ListaNaoEncontradaException(Lista lista) {
		super("Lista não encontrada.");
		if(lista == null){
			System.out.println("Lista não referenciada.");
		}
    }

}
