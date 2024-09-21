package br.edu.ufape.poo.listadecompras.negocios.excecoes;

public class NaoEncontradoPeloIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public NaoEncontradoPeloIdException(long id) {
		super("Id não encontrado.");
		if(id == 0){
			System.out.println("Id nulo.");
		}
		
    }

}
