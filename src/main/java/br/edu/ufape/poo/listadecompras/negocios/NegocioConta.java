package br.edu.ufape.poo.listadecompras.negocios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.listadecompras.dados.IRepositorioContas;
import br.edu.ufape.poo.listadecompras.negocios.cadastro.InterfaceCadastroConta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaDuplicadaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.EmailInvalidoExeception;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloEmailException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloIdException;

@Service
public class NegocioConta implements InterfaceCadastroConta{

    @Autowired
    private IRepositorioContas repositorioContas;
    

    public List<Conta> procurarContaEmail(String email) 
    throws NaoEncontradoPeloEmailException{
        
        if(repositorioContas.findByEmail(email) == null){
            throw  new NaoEncontradoPeloEmailException(email);
        }
       
        return repositorioContas.findByEmail(email);
    }

    public void salvarConta(Conta entity)
    throws ContaDuplicadaException, EmailInvalidoExeception{

        if(!entity.getEmail().contains("@")){
			throw new EmailInvalidoExeception(entity.getEmail());
		}
		else if(!entity.getEmail().contains(".com")){
			throw new EmailInvalidoExeception(entity.getEmail());
		}
		else if(!entity.getEmail().contains("gmail") && 
        !entity.getEmail().contains("hotmail") && 
        !entity.getEmail().contains("outlook") && !entity.getEmail().contains("yahoo"))
        {
			throw new EmailInvalidoExeception(entity.getEmail());
		}
		else if(entity.getEmail().indexOf('@') < 3){
			throw new EmailInvalidoExeception(entity.getEmail());
		}

        if(repositorioContas.findByEmail(entity.getEmail()) != null){
            throw new ContaDuplicadaException();
        }

        repositorioContas.save(entity);
    }

	public List<Conta> listarContas(){
        return repositorioContas.findAll();
    }

	public void removerConta(long id)
    throws NaoEncontradoPeloIdException{
        if(!localizarIdConta(id)){
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
        if(!localizarIdConta(id)){
            throw new NaoEncontradoPeloIdException(id);
        }
        return repositorioContas.findById(id);
    }

    public boolean localizarIdConta(long id){
        return repositorioContas.findById(id) != null;
    }
}
