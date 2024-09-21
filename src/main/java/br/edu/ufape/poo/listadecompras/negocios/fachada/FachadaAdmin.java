package br.edu.ufape.poo.listadecompras.negocios.fachada;

import br.edu.ufape.poo.listadecompras.negocios.cadastro.InterfaceCadastroConta;
import br.edu.ufape.poo.listadecompras.negocios.cadastro.InterfaceCadastroLista;
import br.edu.ufape.poo.listadecompras.negocios.cadastro.InterfaceCadastroProduto;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Administrador;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaDuplicadaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.EmailInvalidoExeception;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloIdException;

public class FachadaAdmin {
    
	private InterfaceCadastroConta cadastroConta;
    private InterfaceCadastroLista cadastroLista;
    private InterfaceCadastroProduto cadastroProduto;

	private Administrador adminLogado;
	//Gerencia contas | CRUD
	//Talvez seja necessário fazer um método de editar em cada uma das classes de negócio
	public void editarContaUsuario(Conta conta, String nome, String email, String senha) throws NaoEncontradoPeloIdException, ContaDuplicadaException, EmailInvalidoExeception{
		Conta c = cadastroConta.localizarContaId(conta.getId()).get();
		if(nome != null){
			c.setNome(nome);
		}
		if(email != null){
			c.setEmail(email);
		}
		if(senha != null){
			c.setSenha(senha);
		}
		cadastroConta.removerConta(c.getId());
		cadastroConta.salvarConta(c);
	}

	public void deletarContaUsuario(Conta conta) throws NaoEncontradoPeloIdException{
		cadastroConta.removerConta(conta.getId());
	}
	
	//Gerencia listas (com listas modelo) | CRUD
	
}
