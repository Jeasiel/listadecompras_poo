package br.edu.ufape.poo.listadecompras.negocios;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.listadecompras.dados.IRepositorioContas;
import br.edu.ufape.poo.listadecompras.negocios.cadastro.InterfaceCadastroConta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloEmailException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloIdException;

public class NegocioConta implements InterfaceCadastroConta{

    //Fazer as exceções
    private IRepositorioContas repositorioContas;
    

    public List<Conta> procurarContaEmail(String email) 
    throws NaoEncontradoPeloEmailException{
        
        if(repositorioContas.findByEmail(email) == null || repositorioContas.findByEmail(email).isEmpty()){
            throw  new NaoEncontradoPeloEmailException(email);
        }
       
        return repositorioContas.findByEmail(email);
    }

    public void salvarConta(Conta entity)
    throws ContaNaoEncontradaException{
        if(repositorioContas.findById(entity.getId()) == null){
            throw new ContaNaoEncontradaException(entity);
        }
        repositorioContas.save(entity);
    }

	public List<Conta> listarContas(){
        return repositorioContas.findAll();
    }

	public void removerConta(Long id)
    throws NaoEncontradoPeloIdException{
        if(repositorioContas.findById(id) == null){
            throw new NaoEncontradoPeloIdException(id);
        }
        repositorioContas.deleteById(id);
    }

	public void removerConta(Conta entity)
    throws ContaNaoEncontradaException{
        if(repositorioContas.findById(entity.getId()) == null){
            throw new ContaNaoEncontradaException(entity);
        }
        repositorioContas.delete(entity);
    }

	public Optional<Conta> localizarContaId(long id)
    throws NaoEncontradoPeloIdException{
        if(repositorioContas.findById(id) == null){
            throw new NaoEncontradoPeloIdException(id);
        }
        return repositorioContas.findById(id);
    }
}
