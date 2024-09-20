package br.edu.ufape.poo.listadecompras.negocios;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.listadecompras.dados.IRepositorioListas;
import br.edu.ufape.poo.listadecompras.negocios.cadastro.InterfaceCadastroLista;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Lista;

public class NegocioLista implements InterfaceCadastroLista{

    //Fazer tratamentos
    private IRepositorioListas repositorioListas;

    public List<Lista> procurarListaConta(Conta conta){
        return repositorioListas.findByConta(conta);
    }

    public void salvarLista(Lista entity){
        repositorioListas.save(entity);
    }

	public List<Lista> listarListas(){
        return repositorioListas.findAll();
    }

	public void removerLista(Long id){
        repositorioListas.deleteById(id);
    }

	public void removerLista(Lista entity){
        repositorioListas.delete(entity);
    }

	public Optional<Lista> localizarListaId(long id){
        return repositorioListas.findById(id);
    }
}
