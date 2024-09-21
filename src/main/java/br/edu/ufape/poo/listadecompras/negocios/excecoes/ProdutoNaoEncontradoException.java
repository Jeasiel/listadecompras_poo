package br.edu.ufape.poo.listadecompras.negocios.excecoes;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Produto;

public class ProdutoNaoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public ProdutoNaoEncontradoException(Produto produto) {
		super("Produto não encontrado.");
		if(produto == null){
			System.out.println("Produto não referenciado.");
		}
    }

}
