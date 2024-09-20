package br.edu.ufape.poo.listadecompras.negocios;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.listadecompras.dados.IRepositorioContas;
import br.edu.ufape.poo.listadecompras.negocios.cadastro.InterfaceCadastroConta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;

public class NegocioConta implements InterfaceCadastroConta{

    //Fazer as exceções
    private IRepositorioContas repositorioContas;

    public List<Conta> procurarContaEmail(String email){
        return repositorioContas.findByEmail(email);
    }

    public void salvarConta(Conta entity){
        repositorioContas.save(entity);
    }

	public List<Conta> listarContas(){
        return repositorioContas.findAll();
    }

	public void removerConta(Long id){
        repositorioContas.deleteById(id);
    }

	public void removerConta(Conta entity){
        repositorioContas.delete(entity);
    }

	public Optional<Conta> localizarContaId(long id){
        return repositorioContas.findById(id);
    }
}
