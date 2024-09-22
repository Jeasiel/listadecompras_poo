package br.edu.ufape.poo.listadecompras.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Usuario;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaDuplicadaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.EmailInvalidoExeception;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloEmailException;
import br.edu.ufape.poo.listadecompras.negocios.fachada.FachadaUsuario;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
    @Autowired
    public FachadaUsuario fachadaUsuario;

    @GetMapping("/usuario")
    public List<Conta> listarUsuario() {
        return fachadaUsuario.getUsuarios();
    }

    @PostMapping("/usuario")
    public Conta salvarUsuario(@RequestParam String nome, @RequestParam String email, @RequestParam String senha) throws ContaNaoEncontradaException, ContaDuplicadaException, EmailInvalidoExeception {
        fachadaUsuario.criarConta(nome, email, senha);
        return null;
    }

    @PostMapping("/usuario/login")
    public void login(@RequestParam String email, @RequestParam String senha) throws NaoEncontradoPeloEmailException {
        fachadaUsuario.login(email, senha);
    }
    
    @GetMapping("/usuario/login")
    public Usuario getUsuarioLogado() {
        return fachadaUsuario.getUsuarioLogado();
    }
    
}
