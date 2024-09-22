package br.edu.ufape.poo.listadecompras.negocios.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.listadecompras.negocios.cadastro.InterfaceCadastroConta;
import br.edu.ufape.poo.listadecompras.negocios.cadastro.InterfaceCadastroLista;
import br.edu.ufape.poo.listadecompras.negocios.cadastro.InterfaceCadastroProduto;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Lista;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Produto;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Usuario;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaDuplicadaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.EmailInvalidoExeception;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ListaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloEmailException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloIdException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NomeInvalidoException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ProdutoNaoEncontradoException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.QuantidadeInvalidaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.SenhaErradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ValorInvalidoException;

@Service
public class FachadaUsuario {

    @Autowired
    private InterfaceCadastroConta cadastroConta;

    @Autowired
    private InterfaceCadastroLista cadastroLista;

    @Autowired
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

    public void editarLista(Lista l, String nome, String tipo) throws NaoEncontradoPeloIdException, ListaNaoEncontradaException{
        Lista inner = cadastroLista.localizarListaId(l.getId()).get();
        inner.setNome(nome);
        inner.setTipo(tipo);
        cadastroLista.removerLista(l.getId());
        cadastroLista.salvarLista(inner);
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

    public void editarProduto(String nome, double precoEstimado, int quantidade, Produto produto) throws NaoEncontradoPeloIdException, ProdutoNaoEncontradoException, NomeInvalidoException, ValorInvalidoException, QuantidadeInvalidaException{
        Produto p = cadastroProduto.localizarProdutoId(produto.getId()).get();
        if(nome != null){
            p.setNome(nome);
        }
        if(quantidade != 0){
            p.setQuantidade(quantidade);
        }
        cadastroProduto.removerProduto(p.getId());
        cadastroProduto.salvarProduto(p);
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

    public void criarConta(Conta conta) throws ContaDuplicadaException, EmailInvalidoExeception{
        cadastroConta.salvarConta(conta);
    }

    public void editarConta(String nome, String email, String senha) throws NaoEncontradoPeloIdException, ContaDuplicadaException, EmailInvalidoExeception{
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
            cadastroConta.removerConta(u.getId());
            cadastroConta.salvarConta(u);
        }
    }

    public Usuario verConta(){
        return usuarioLogado;
    }
    
    public void deletarConta() throws ContaNaoEncontradaException{
        cadastroConta.removerConta(usuarioLogado);
    }

    public void login(String email, String senha) throws NaoEncontradoPeloEmailException, SenhaErradaException{
        usuarioLogado = (Usuario) cadastroConta.login(email, senha);
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    //Extra, para teste (não apareceria em um sistema real)

    public List<Conta> getUsuarios(){
        return cadastroConta.listarContas();
    }
}
