package br.edu.ufape.poo.listadecompras.negocios.excecoes;

public class NaoEncontradoPeloIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public NaoEncontradoPeloIdException(Long id) {
		super("Id não encontrado.");
		if(id == null){
			System.out.println("Id nulo.");
		}
		
    }

}
