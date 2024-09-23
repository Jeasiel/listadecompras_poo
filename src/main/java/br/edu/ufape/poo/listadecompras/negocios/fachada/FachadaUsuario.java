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
    public void criarLista(String nome, String tipo) throws ListaNaoEncontradaException, ContaNaoEncontradaException{
        boolean criado = false;
        if(!"".equals(nome) && !"".equals(tipo)){
            criado = true;
            cadastroLista.salvarLista(new Lista(nome, tipo), usuarioLogado);
        } else if(!"".equals(nome)){
            criado = true;
            cadastroLista.salvarLista(new Lista(nome), usuarioLogado);
        }
        if(!criado){
            cadastroLista.salvarLista(new Lista(), usuarioLogado);
        }
    }

    public void editarLista(Lista l, String nome, String tipo) throws NaoEncontradoPeloIdException, ListaNaoEncontradaException, ProdutoNaoEncontradoException, NomeInvalidoException, ValorInvalidoException, QuantidadeInvalidaException, ContaNaoEncontradaException{
        Lista inner = cadastroLista.localizarListaId(l.getId()).get();
        if(!"".equals(nome)){
            inner.setNome(nome);
        }
        if(!"".equals(tipo)){
            inner.setTipo(tipo);
        }
        cadastroLista.salvarLista(inner, usuarioLogado);
    }

	public void removerLista(Lista l) throws NaoEncontradoPeloIdException, ListaNaoEncontradaException, ProdutoNaoEncontradoException, ContaNaoEncontradaException{
        cadastroLista.removerLista(l, usuarioLogado);
	}
	
	public List<Lista> getListas() throws ListaNaoEncontradaException, ContaNaoEncontradaException{
		return cadastroLista.procurarListaConta(usuarioLogado);
	}
    
    //Mexe com produto
    public void adicionarProduto(String nome, double precoEstimado, int quantidade, Lista lista) throws ProdutoNaoEncontradoException, NomeInvalidoException, ValorInvalidoException, QuantidadeInvalidaException, ListaNaoEncontradaException{
        cadastroProduto.salvarProduto(new Produto(nome, precoEstimado, quantidade), lista);
    }

    public void adicionarProdutoID(String nome, double precoEstimado, int quantidade, long idLista) throws ProdutoNaoEncontradoException, NomeInvalidoException, ValorInvalidoException, QuantidadeInvalidaException, NaoEncontradoPeloIdException, ListaNaoEncontradaException{
        adicionarProduto(nome, precoEstimado, quantidade, cadastroLista.localizarListaId(idLista).get());
    }

    public void editarProduto(String nome, double precoEstimado, int quantidade, Produto produto, Lista lista) throws NaoEncontradoPeloIdException, ProdutoNaoEncontradoException, NomeInvalidoException, ValorInvalidoException, QuantidadeInvalidaException, ListaNaoEncontradaException{
        Produto p = cadastroProduto.localizarProdutoId(produto.getId()).get();
        if(!"".equals(nome)){
            p.setNome(nome);
        }
        if(precoEstimado != 0){
            p.setPrecoEstimado(precoEstimado);
        }
        if(quantidade != 0){
            p.setQuantidade(quantidade);
        }
        cadastroProduto.salvarProduto(p, lista);
    }

    public void editarProdutoID(String nome, double precoEstimado, int quantidade, Produto produto, long id) throws NaoEncontradoPeloIdException, ProdutoNaoEncontradoException, NomeInvalidoException, ValorInvalidoException, QuantidadeInvalidaException, ListaNaoEncontradaException{
        editarProduto(nome, precoEstimado, quantidade, produto, cadastroLista.localizarListaId(id).get());
    }

    public List<Produto> getProdutosID(long id) throws ListaNaoEncontradaException, NaoEncontradoPeloIdException{
        return getProdutos(cadastroLista.localizarListaId(id).get());
    }

    public List<Produto> getProdutos(Lista l) throws ListaNaoEncontradaException{
        return cadastroProduto.procurarProdutoLista(l);
    }

    public void removerProduto(Produto produto, Lista lista) throws ProdutoNaoEncontradoException, ListaNaoEncontradaException{
        cadastroProduto.removerProduto(produto, lista);
    }

    public void removerProdutoID(Produto produto, long id) throws ProdutoNaoEncontradoException, ListaNaoEncontradaException, NaoEncontradoPeloIdException{
        removerProduto(produto, cadastroLista.localizarListaId(id).get());
    }

    //Mexe com conta

    public void criarContaUsuario(String nome, String email, String senha) throws ContaNaoEncontradaException, ContaDuplicadaException, EmailInvalidoExeception{
        cadastroConta.salvarConta(new Usuario(nome, email, senha));
    }

    public void editarConta(String nome, String email, String senha) throws NaoEncontradoPeloIdException, ContaDuplicadaException, EmailInvalidoExeception{
        if(!"".equals(nome)){
            usuarioLogado.setNome(nome);
        }
        if(!"".equals(email)){
            usuarioLogado.setEmail(email);
        }
        if(!"".equals(senha)){
            usuarioLogado.setSenha(senha);
        }
        if(!(!"".equals(nome) && !"".equals(email) && !"".equals(senha))){
            Usuario u = (Usuario) cadastroConta.localizarContaId(usuarioLogado.getId()).get();
            u.setNome(nome);
            u.setEmail(email);
            u.setSenha(senha);
            cadastroConta.salvarConta(u);
        }
    }
    
    public void deletarConta() throws ContaNaoEncontradaException{
        logoff();
        cadastroConta.removerConta(usuarioLogado);
    }

    public void login(String email, String senha) throws NaoEncontradoPeloEmailException, SenhaErradaException{
        this.usuarioLogado = (Usuario) cadastroConta.login(email, senha);
    }

    public void logoff(){
        this.usuarioLogado = null;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    //Extra, para teste (não apareceria em um sistema real)

    public List<Conta> getUsuarios(){
        return cadastroConta.listarContas();
    }

    public InterfaceCadastroConta getCadastroConta() {
        return cadastroConta;
    }

    public void setCadastroConta(InterfaceCadastroConta cadastroConta) {
        this.cadastroConta = cadastroConta;
    }

    public InterfaceCadastroLista getCadastroLista() {
        return cadastroLista;
    }

    public void setCadastroLista(InterfaceCadastroLista cadastroLista) {
        this.cadastroLista = cadastroLista;
    }

    public InterfaceCadastroProduto getCadastroProduto() {
        return cadastroProduto;
    }

    public void setCadastroProduto(InterfaceCadastroProduto cadastroProduto) {
        this.cadastroProduto = cadastroProduto;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
}
