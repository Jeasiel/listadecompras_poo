package br.edu.ufape.poo.listadecompras.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import br.edu.ufape.poo.listadecompras.negocios.fachada.FachadaUsuario;


@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
    @Autowired
    public FachadaUsuario fachadaUsuario;

    // Usuario
    @GetMapping("/usuario")
    public List<Conta> listarUsuario() {
        return fachadaUsuario.getUsuarios();
    }

    @PostMapping("/usuario")
    public Conta salvarUsuario(@RequestParam String nome, @RequestParam String email, @RequestParam String senha) throws ContaNaoEncontradaException, ContaDuplicadaException, EmailInvalidoExeception {
        fachadaUsuario.criarConta(nome, email, senha);
        return null;
    }

    // Login

    @PostMapping("/usuario/login")
    public Usuario login(@RequestParam String email, @RequestParam String senha) throws NaoEncontradoPeloEmailException, SenhaErradaException {
        fachadaUsuario.login(email, senha);
        return fachadaUsuario.getUsuarioLogado();
    }
    
    @GetMapping("/usuario/login")
    public Usuario getUsuarioLogado() {
        return fachadaUsuario.getUsuarioLogado();
    }

    // Lista

    @GetMapping("/usuario/listas")
    public List<Lista> getListas() throws ListaNaoEncontradaException, ContaNaoEncontradaException {
        return fachadaUsuario.getListas();
    }
    
    @PostMapping("/usuario/listas")
    public void criarLista(@RequestParam String nome, @RequestParam String tipo) throws ListaNaoEncontradaException {
        fachadaUsuario.criarLista(nome, tipo);
    }
    
    @PatchMapping("/usuario/listas")
    public void editarLista(@RequestBody Lista l, @RequestParam String nome, @RequestParam String tipo) throws NaoEncontradoPeloIdException, ListaNaoEncontradaException{
        fachadaUsuario.editarLista(l, nome, tipo);
    }

    @DeleteMapping("/usuario/listas")
    public void removerLista(@RequestBody Lista l) throws NaoEncontradoPeloIdException, ListaNaoEncontradaException{
        fachadaUsuario.removerLista(l);
    }

    // Produto

    @GetMapping("/usuario/listas/{id}")
    public List<Produto> getProdutos(@PathVariable long id) throws ListaNaoEncontradaException, NaoEncontradoPeloIdException{
        return fachadaUsuario.getProdutosID(id);
    }
    
    @PostMapping("/usuario/listas")
    public void adicionarProduto(@RequestBody Lista lista, String nome, double preco, int quant) throws ProdutoNaoEncontradoException, NomeInvalidoException, ValorInvalidoException, QuantidadeInvalidaException {
        fachadaUsuario.adicionarProduto(nome, preco, quant, lista);
    }
    
    /**
    @PatchMapping("/usuario/listas")
    public void editarLista(@RequestBody Lista l, @RequestParam String nome, @RequestParam String tipo) throws NaoEncontradoPeloIdException, ListaNaoEncontradaException{
        fachadaUsuario.editarLista(l, nome, tipo);
    }

    @DeleteMapping("/usuario/listas")
    public void removerLista(@RequestBody Lista l) throws NaoEncontradoPeloIdException, ListaNaoEncontradaException{
        fachadaUsuario.removerLista(l);
    }
    */
}
