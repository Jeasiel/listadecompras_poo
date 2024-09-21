package br.edu.ufape.poo.listadecompras.negocios.excecoes;

public class ContaDuplicadaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public ContaDuplicadaException() {
		super("Email já cadastrado.");
    }

}
