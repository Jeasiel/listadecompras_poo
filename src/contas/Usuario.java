package contas;

import interfaces.IRepositorioListas;
import java.util.ArrayList;
import listas.Lista;

public class Usuario extends ContaAbstrata implements IRepositorioListas{
	
	private ArrayList<Lista> arrayListas = new ArrayList<>();
	//ver como aplicar o conceito de listas globais
    
    public Usuario(String nome, String email, String senha) {
        super(nome, email, senha);
        //provalvemente puxar do banco de dados e dar um setListas
    }

    @Override
    public void fazerLogin(String email, String senha) { // talvez seja melhor serem metodos do repositorio ou de uma classe de comunicação?
    	//fazer método
    }

    @Override
    public void atualizarCadastro(String email, String senha) { // talvez seja melhor serem metodos do repositorio ou de uma classe de comunicação?
    	//fazer método
    }

    public void criarLista(){
        //ver como se aplicaria para os varios construtores de listas
    }

    public void editarLista(Lista l){
        //fazer método
    }

	@Override
	public void adicionarLista(Lista l) {
		//Em construção
		
		
		arrayListas.add(l);
	}

	@Override
	public void removerLista(Lista l) {
		//Em construção
		
		if(consultarLista(l) == -1) {
			//throwException
		}
		else {
			arrayListas.remove(consultarLista(l)); //remove com base no index dado;
		}
		
	}

	@Override
	public void atualizarLista(Lista l) {
		//Em construção
		
		if(consultarLista(l) == -1) {
			//throwException
		}
		else {
			Lista e = arrayListas.get(consultarLista(l)); //retorna o index da lista correta
			editarLista(e);
		}
		
	}

	@Override
	public int consultarLista(Lista l) {	
		//Em construção
		
		int index = arrayListas.indexOf(l);
		
		if(index >= 0) {
			return index;
		}
		
		return -1;
		
		
	}

	@Override
	public ArrayList<Lista> getListas() {
		//Em construção
		
		return arrayListas;
	}

	@Override
	public void setListas(ArrayList<Lista> arrayLista) {
		//Em construção
		
		this.arrayListas.clear();
		this.arrayListas.addAll(arrayLista);
	}
    
}