package br.edu.ufape.poo.listadecompras.negocios;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.listadecompras.dados.IRepositorioProduto;
import br.edu.ufape.poo.listadecompras.negocios.cadastro.InterfaceCadastroProduto;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Lista;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Produto;

public class NegocioProduto implements InterfaceCadastroProduto{

    //Fazer as capturas e exceções
    private IRepositorioProduto repositorioProduto;

    public List<Produto> procurarProdutoLista(Lista lista){
        return repositorioProduto.findByLista(lista);
    }

    public void salvarProduto(Produto entity){
        repositorioProduto.save(entity);
    }

	public List<Produto> listarProdutos(){
        return repositorioProduto.findAll();
    }

	public void removerProduto(Long id){
        repositorioProduto.deleteById(id);
    }

	public void removerProduto(Produto entity){
        repositorioProduto.delete(entity);
    }

	public Optional<Produto> localizarProdutoId(long id){
        return repositorioProduto.findById(id);
    }
}