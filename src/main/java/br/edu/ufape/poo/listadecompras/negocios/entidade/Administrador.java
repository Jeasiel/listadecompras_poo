package br.edu.ufape.poo.listadecompras.negocios.entidade;

import java.util.ArrayList;
//import listas.Lista;

public class Administrador extends Conta{
	
	private final ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	
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
	
	public void adicionarConta(Usuario u) {
		//em construção
		listaUsuarios.add(u);
	}

	public void removerConta(Usuario u) {
		//Em construção
		
		if(consultarConta(u) == -1) {
			//throwException
		}
		else {
			listaUsuarios.remove(consultarConta(u)); //remove com base no index dado;
		}		
	}
	
	public void editarConta(Usuario u) {
		//fazer método
	}


	public void atualizarConta(Usuario u) {
		//Em construção
		
		if(consultarConta(u) == -1) {
			//throwException
		}
		else {
			Usuario e = listaUsuarios.get(consultarConta(u)); //retorna o index da lista correta
			editarConta(e);
		}	
	}

	public int consultarConta(Usuario u) {
		//Em construção
		
		int index = listaUsuarios.indexOf(u);
				
		if(index >= 0) {
			return index;
		}
				
		return -1;	
	}

	public ArrayList<Usuario> getListaUsuarios() {
		//Em construção
		
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		//Em construção
		
		this.listaUsuarios.clear();
		this.listaUsuarios.addAll(listaUsuarios);
	}
}