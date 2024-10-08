package br.edu.ufape.poo.listadecompras.negocios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.listadecompras.dados.IRepositorioContas;
import br.edu.ufape.poo.listadecompras.dados.IRepositorioListas;
import br.edu.ufape.poo.listadecompras.negocios.cadastro.InterfaceCadastroLista;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Lista;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ListaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloIdException;

@Service
public class NegocioLista implements InterfaceCadastroLista{

    @Autowired
    private IRepositorioListas repositorioListas;
    @Autowired
    private IRepositorioContas repositorioContas;

    @Override
    public List<Lista> procurarListaConta(Conta conta)
    throws ContaNaoEncontradaException{

        if(repositorioContas.findById(conta.getId()).get() == null){
            throw new ContaNaoEncontradaException(conta);
        }

        return repositorioContas.findById(conta.getId()).get().getListas();
    }

    @Override
    public void salvarLista(Lista entity, Conta conta)
    throws ListaNaoEncontradaException, ContaNaoEncontradaException{

        if(repositorioListas.findById(entity.getId()) == null){
            throw new ListaNaoEncontradaException(entity);
        }

        if(repositorioContas.findById(conta.getId()).get() == null){
            throw new ContaNaoEncontradaException(conta);
        }

        Conta innerConta = repositorioContas.findById(conta.getId()).get();
        List<Lista> inner = innerConta.getListas();
        inner.add(entity);
        innerConta.setListas(inner);
        repositorioContas.save(innerConta);
        repositorioListas.save(entity);
    }

    @Override
	public List<Lista> listarListas(){
        return repositorioListas.findAll();
    }

    @Override
	public void removerLista(long id)
    throws NaoEncontradoPeloIdException{

        if(!localizarIdLista(id)){
            throw new NaoEncontradoPeloIdException(id);
        }

        repositorioListas.deleteById(id);
    }

    @Override
	public void removerLista(Lista entity, Conta conta)
    throws ListaNaoEncontradaException, ContaNaoEncontradaException{
        if(repositorioListas.findById(entity.getId()) == null){
            throw new ListaNaoEncontradaException(entity);
        }

        if(repositorioContas.findById(conta.getId()).get() == null){
            throw new ContaNaoEncontradaException(conta);
        }

        Conta innerConta = repositorioContas.findById(conta.getId()).get();
        List<Lista> inner = innerConta.getListas();
        for(int i = 0; i < inner.size(); i++){
            if(inner.get(i).getId() == entity.getId()){
                inner.remove(i);
                break;
            }
        }
        innerConta.setListas(inner);
        repositorioContas.save(innerConta);
    }

    @Override
	public Optional<Lista> localizarListaId(long id)
    throws NaoEncontradoPeloIdException{

        if(!localizarIdLista(id)){
            throw new NaoEncontradoPeloIdException(id);
        }
        
        return repositorioListas.findById(id);
    }

    public boolean localizarIdLista(long id){
        return repositorioListas.findById(id) != null;
    }

    public void setRepositorioContas(IRepositorioContas repositorioContas){
        this.repositorioContas = repositorioContas;
    }

    public IRepositorioContas getRepositorioContas(){
        return this.repositorioContas;
    }

    public void setRepositorioListas(IRepositorioListas repositorioListas){
        this.repositorioListas = repositorioListas;
    }

    public IRepositorioListas getRepositorioListas(){
        return this.repositorioListas;
    }
}
