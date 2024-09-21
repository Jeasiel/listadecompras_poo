package br.edu.ufape.poo.listadecompras.negocios;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.listadecompras.dados.IRepositorioListas;
import br.edu.ufape.poo.listadecompras.dados.IRepositorioProduto;
import br.edu.ufape.poo.listadecompras.negocios.cadastro.InterfaceCadastroProduto;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Lista;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Produto;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ListaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloIdException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ProdutoNaoEncontradoException;

public class NegocioProduto implements InterfaceCadastroProduto{

    //Fazer as capturas e exceções
    private IRepositorioProduto repositorioProduto;
    private IRepositorioListas repositorioListas;

    public List<Produto> procurarProdutoLista(Lista lista)
    throws ListaNaoEncontradaException{

        if(repositorioListas.findById(lista.getId()) == null){
            throw new ListaNaoEncontradaException(lista);
        }

        return repositorioProduto.findByLista(lista);
    }

    public void salvarProduto(Produto entity)
    throws ProdutoNaoEncontradoException{
        if(repositorioProduto.findById(entity.getId()) == null){
            throw new ProdutoNaoEncontradoException(entity);
        }
        repositorioProduto.save(entity);
    }

	public List<Produto> listarProdutos(){
        return repositorioProduto.findAll();
    }

	public void removerProduto(Long id)
    throws NaoEncontradoPeloIdException{

        if(repositorioProduto.findById(id) == null){
            throw new NaoEncontradoPeloIdException(id);
        }
        repositorioProduto.deleteById(id);
    }

	public void removerProduto(Produto entity)
    throws ProdutoNaoEncontradoException{

        if(repositorioProduto.findById(entity.getId()) == null){
            throw new ProdutoNaoEncontradoException(entity);
        }

        repositorioProduto.delete(entity);
        
    }

	public Optional<Produto> localizarProdutoId(long id)
    throws NaoEncontradoPeloIdException{

        if(repositorioProduto.findById(id) == null){
            throw new NaoEncontradoPeloIdException(id);
        }
        
        return repositorioProduto.findById(id);
    }
}