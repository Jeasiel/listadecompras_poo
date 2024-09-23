package br.edu.ufape.poo.listadecompras.negocios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.listadecompras.dados.IRepositorioListas;
import br.edu.ufape.poo.listadecompras.dados.IRepositorioProduto;
import br.edu.ufape.poo.listadecompras.negocios.cadastro.InterfaceCadastroProduto;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Lista;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Produto;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ListaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloIdException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NomeInvalidoException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ProdutoNaoEncontradoException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.QuantidadeInvalidaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ValorInvalidoException;

@Service
public class NegocioProduto implements InterfaceCadastroProduto{

    @Autowired
    private IRepositorioProduto repositorioProduto;
    @Autowired
    private IRepositorioListas repositorioListas;

    @Override
    public List<Produto> procurarProdutoLista(Lista lista)
    throws ListaNaoEncontradaException{

        if(repositorioListas.findById(lista.getId()) == null){
            throw new ListaNaoEncontradaException(lista);
        }

        return repositorioListas.findById(lista.getId()).get().getListaProdutos();
    }

    @Override
    public void salvarProduto(Produto entity, Lista lista)
    throws ProdutoNaoEncontradoException, NomeInvalidoException, ValorInvalidoException, QuantidadeInvalidaException, ListaNaoEncontradaException{

        if(entity.getNome().length() == 1){
			throw new NomeInvalidoException();
		}

        if(entity.getQuantidade() <= 0){
            throw new QuantidadeInvalidaException();
        }

        if(entity.getPrecoEstimado() <= 0){
            throw new ValorInvalidoException();
        }

        if(repositorioListas.findById(lista.getId()).get() == null){
            throw new ListaNaoEncontradaException(lista);
        }

        Lista innerLista = repositorioListas.findById(lista.getId()).get();
        List<Produto> inner = innerLista.getListaProdutos();
        inner.add(entity);
        innerLista.setListaProdutos(inner);
        repositorioListas.save(innerLista);
        repositorioProduto.save(entity);
    }

    @Override
	public List<Produto> listarProdutos(){
        return repositorioProduto.findAll();
    }

    @Override
	public void removerProduto(long id)
    throws NaoEncontradoPeloIdException{

        if(!localizarIdProduto(id)){
            throw new NaoEncontradoPeloIdException(id);
        }
        repositorioProduto.deleteById(id);
    }

    @Override
	public void removerProduto(Produto entity, Lista lista)
    throws ProdutoNaoEncontradoException, ListaNaoEncontradaException{

        if(repositorioProduto.findById(entity.getId()) == null){
            throw new ProdutoNaoEncontradoException(entity);
        }

        if(repositorioListas.findById(lista.getId()).get() == null){
            throw new ListaNaoEncontradaException(lista);
        }

        Lista innerLista = repositorioListas.findById(lista.getId()).get();
        List<Produto> inner = innerLista.getListaProdutos();
        for(int i = 0; i < inner.size(); i++){
            if(inner.get(i).getId() == entity.getId()){
                inner.remove(i);
                break;
            }
        }
        innerLista.setListaProdutos(inner);
        repositorioListas.save(innerLista);
        //remove (finalmente)
    }

    @Override
	public Optional<Produto> localizarProdutoId(long id)
    throws NaoEncontradoPeloIdException{

        if(!localizarIdProduto(id)){
            throw new NaoEncontradoPeloIdException(id);
        }
        
        return repositorioProduto.findById(id);
    }

    public boolean localizarIdProduto(long id){
        return repositorioProduto.findById(id) != null;
    }

    public void setRepositorioListas(IRepositorioListas repositorioListas){
        this.repositorioListas = repositorioListas;
    }

    public IRepositorioListas getRepositorioListas(){
        return this.repositorioListas;
    }

    public void setRepositorioProduto(IRepositorioProduto repositorioProduto){
        this.repositorioProduto = repositorioProduto;
    }

    public IRepositorioProduto getRepositorioProduto(){
        return this.repositorioProduto;
    }
}