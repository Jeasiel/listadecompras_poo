package br.edu.ufape.poo.listadecompras.negocios.entidade;

import java.util.ArrayList;
//import listas.Lista;

public class Administrador extends Conta {
	private final ArrayList<Conta> listaContas = new ArrayList<>();
	
	//ter outro para administradores?
    
    public Administrador(String nome, String email, String senha) {
        super(nome, email, senha);
        //provavelmente ler do banco e dar um set aqui
    }
    
    public void gerenciarContas(){
        //controler?
    }

    public void gerenciarListasGlobais(){
        //ver como funcionaria
    }
	
	public void adicionarConta(Conta u) {
		//em construção
		listaContas.add(u);
	}

	public void removerConta(Conta u) {
		//Em construção
		
		if(consultarConta(u) == -1) {
			//throwException
		}
		else {
			listaContas.remove(consultarConta(u)); //remove com base no index dado;
		}		
	}
	
	public void atualizarConta(Conta u, String novoNome, String novoEmail, String novaSenha) {
		//Em construção
		
		if(consultarConta(u) == -1) {
			//throwException
		}
		else {
			Conta e = listaContas.get(consultarConta(u)); //retorna o index da lista correta
			e.editarConta(novoNome, novoEmail, novaSenha);
		}	
	}

	public int consultarConta(Conta u) {
		//Em construção
		int index = listaContas.indexOf(u);

		if(index >= 0) {
			return index;
		}
		return -1;	
	}

	public ArrayList<Conta> getListaContas() {
		//Em construção
		
		return listaContas;
	}

	public void setListaContas(ArrayList<Conta> listaContas) {
		//Em construção
		
		this.listaContas.clear();
		this.listaContas.addAll(listaContas);
	}
}