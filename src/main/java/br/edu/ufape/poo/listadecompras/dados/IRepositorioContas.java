package br.edu.ufape.poo.listadecompras.dados;
import java.util.ArrayList;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;

public interface IRepositorioContas{
	
	public ArrayList<Conta> listaContas = new ArrayList<>();
	
	public void adicionarConta(Conta u);
	
	public void removerConta(Conta u);
	
	public void atualizarConta(Conta u);
	
	public int consultarConta(Conta u);

	public ArrayList<Conta> getListaContas();

	public void setListaContas(ArrayList<Conta> listaContas);


}
