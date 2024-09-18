package br.edu.ufape.poo.listadecompras.dados;

import java.util.ArrayList;

import br.edu.ufape.poo.listadecompras.negocios.basica.Lista;

public interface IRepositorioListas { 
	
	public ArrayList<Lista> arrayListas = new ArrayList<>();
	
	public void adicionarLista(Lista l);
	
	public void removerLista(Lista l);
	
	public void atualizarLista(Lista l);
	
	public int consultarLista(Lista l);

	public ArrayList<Lista> getListas();

	public void setListas(ArrayList<Lista> arrayLista);


}
