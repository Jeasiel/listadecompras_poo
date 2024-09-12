package interfaces;

import contas.Usuario;
import java.util.ArrayList;

public interface IRepositorioContas {
	
	public ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	
	public void adicionarConta(Usuario u);
	
	public void removerConta(Usuario u);
	
	public void atualizarConta(Usuario u);
	
	public int consultarConta(Usuario u);

	public ArrayList<Usuario> getListaUsuarios();

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios);


}
