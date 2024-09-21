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

    public List<Lista> procurarListaConta(Conta conta)
    throws ContaNaoEncontradaException{

        if(repositorioContas.findById(conta.getId()) == null){
            throw new ContaNaoEncontradaException(conta);
        }

        return repositorioListas.findByConta(conta);
    }

    public void salvarLista(Lista entity)
    throws ListaNaoEncontradaException{

        if(repositorioListas.findById(entity.getId()) == null){
            throw new ListaNaoEncontradaException(entity);
        }
        repositorioListas.save(entity);
    }

	public List<Lista> listarListas(){
        return repositorioListas.findAll();
    }

	public void removerLista(long id)
    throws NaoEncontradoPeloIdException{

        if(!localizarIdLista(id)){
            throw new NaoEncontradoPeloIdException(id);
        }

        repositorioListas.deleteById(id);
    }

	public void removerLista(Lista entity)
    throws ListaNaoEncontradaException{
        if(repositorioListas.findById(entity.getId()) == null){
            throw new ListaNaoEncontradaException(entity);
        }
        repositorioListas.delete(entity);
    }

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
}
