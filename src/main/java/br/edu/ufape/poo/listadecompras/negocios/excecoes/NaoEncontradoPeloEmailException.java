package br.edu.ufape.poo.listadecompras.negocios.excecoes;

public class NaoEncontradoPeloEmailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public NaoEncontradoPeloEmailException(String email) {
		super("Email não encontrado.");
		if(email == null){
			System.out.println("Email nulo.");
		}
    }

}
