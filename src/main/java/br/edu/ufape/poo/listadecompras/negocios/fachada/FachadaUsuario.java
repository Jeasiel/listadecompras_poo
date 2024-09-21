package br.edu.ufape.poo.listadecompras.negocios.fachada;

import java.util.List;

import br.edu.ufape.poo.listadecompras.negocios.cadastro.InterfaceCadastroConta;
import br.edu.ufape.poo.listadecompras.negocios.cadastro.InterfaceCadastroLista;
import br.edu.ufape.poo.listadecompras.negocios.cadastro.InterfaceCadastroProduto;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Lista;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Produto;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Usuario;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaDuplicadaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.EmailInvalidoExeception;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ListaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloIdException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NomeInvalidoException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ProdutoNaoEncontradoException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.QuantidadeInvalidaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ValorInvalidoException;

public class FachadaUsuario {

    private InterfaceCadastroConta cadastroConta;
    private InterfaceCadastroLista cadastroLista;
    private InterfaceCadastroProduto cadastroProduto;

    private Usuario usuarioLogado;

    //Mexe com lista
    public void criarLista(String nome, String tipo) throws ListaNaoEncontradaException{
        boolean criado = false;
        if(nome != null && tipo != null){
            criado = true;
            cadastroLista.salvarLista(new Lista(nome, tipo, usuarioLogado));
        } else if(nome != null){
            criado = true;
            cadastroLista.salvarLista(new Lista(nome, usuarioLogado));
        }
        if(!criado){
            cadastroLista.salvarLista(new Lista(usuarioLogado));
        }
    }

    public void editarLista(Lista l, String nome, String tipo) throws NaoEncontradoPeloIdException{
        cadastroLista.localizarListaId(l.getId()).get().setNome(nome);
        cadastroLista.localizarListaId(l.getId()).get().setTipo(tipo);
    }

	public void removerLista(Lista l) throws NaoEncontradoPeloIdException, ListaNaoEncontradaException{
        cadastroLista.removerLista(l);
	}
	
	public List<Lista> getListas() throws ListaNaoEncontradaException, ContaNaoEncontradaException{
		return cadastroLista.procurarListaConta(usuarioLogado);
	}
    
    //Mexe com produto
    public void adicionarProduto(String nome, double precoEstimado, int quantidade, Lista lista) throws ProdutoNaoEncontradoException, NomeInvalidoException, ValorInvalidoException, QuantidadeInvalidaException{
        cadastroProduto.salvarProduto(new Produto(nome, precoEstimado, quantidade, lista));
    }

    public void editarProduto(String nome, double precoEstimado, int quantidade, Produto produto) throws NaoEncontradoPeloIdException{
        Produto p = cadastroProduto.localizarProdutoId(produto.getId()).get();
        if(nome != null){
            p.setNome(nome);
        }
        if(quantidade != 0){
            p.setQuantidade(quantidade);
        }
    }

    public List<Produto> getProdutos(Lista l) throws ListaNaoEncontradaException{
        return cadastroProduto.procurarProdutoLista(l);
    }

    public void removerProduto(Produto produto) throws ProdutoNaoEncontradoException{
        cadastroProduto.removerProduto(produto);
    }

    //Mexe com conta

    public void criarConta(String nome, String email, String senha) throws ContaNaoEncontradaException, ContaDuplicadaException, EmailInvalidoExeception{
        cadastroConta.salvarConta(new Usuario(nome, email, senha));
    }

    public void editarConta(String nome, String email, String senha) throws NaoEncontradoPeloIdException{
        if(nome != null){
            usuarioLogado.setNome(nome);
        }
        if(email != null){
            usuarioLogado.setEmail(email);
        }
        if(senha != null){
            usuarioLogado.setSenha(senha);
        }
        if(!(nome != null && email != null && senha != null)){
            Usuario u = (Usuario) cadastroConta.localizarContaId(usuarioLogado.getId()).get();
            u.setNome(nome);
            u.setEmail(email);
            u.setSenha(senha);
        }
    }

    public Usuario verConta(){
        return usuarioLogado;
    }
    
    public void deletarConta() throws ContaNaoEncontradaException{
        cadastroConta.removerConta(usuarioLogado);
    }

    //Talvez seja necessário passar parte para a classe de negócio
}
