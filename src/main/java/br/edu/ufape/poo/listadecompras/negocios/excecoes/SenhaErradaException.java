package br.edu.ufape.poo.listadecompras.negocios.excecoes;

public class SenhaErradaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public  SenhaErradaException() {
		super("Senha inválida.");
    }

}
