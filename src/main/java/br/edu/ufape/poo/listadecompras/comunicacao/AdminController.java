package br.edu.ufape.poo.listadecompras.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.listadecompras.negocios.entidade.Administrador;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Usuario;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaDuplicadaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.EmailInvalidoExeception;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloIdException;
import br.edu.ufape.poo.listadecompras.negocios.fachada.FachadaAdmin;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class AdminController {

    @Autowired
    public FachadaAdmin fachadaAdmin;

    // Usuario/Conta

    @GetMapping("/admin")
    public List<Usuario> listarUsuarioAdm() {
        return fachadaAdmin.getUsuarios();
    }

    @PatchMapping("/admin")
    public void editarContaUsuario(@RequestBody Conta conta, @RequestParam String nome, @RequestParam String email, @RequestParam String senha) throws NaoEncontradoPeloIdException, ContaDuplicadaException, EmailInvalidoExeception{
        fachadaAdmin.editarContaUsuario(conta, nome, email, senha);
    }

    @DeleteMapping("/admin")
    public void deletarContaUsuario(@RequestBody Conta conta) throws NaoEncontradoPeloIdException{
        fachadaAdmin.deletarContaUsuario(conta);
    }

    // Login

    @PostMapping("/admin/login")
    public void login(String email, String senha){

    }

    @GetMapping("/admin/login")
    public Administrador getAdminLogado() {
        return fachadaAdmin.getAdminLogado();
    }

    @GetMapping("/admin/logoff")
    public void logoff() {
        fachadaAdmin.logoff();
    }

    // Admin - conta
    @PostMapping("/admin/conta")
    public void criarContaAdmin(@RequestParam String nome, @RequestParam String email, @RequestParam String senha) throws ContaNaoEncontradaException, ContaDuplicadaException, EmailInvalidoExeception {
        fachadaAdmin.criarContaAdmin(nome, email, senha);
    }
    
    @PatchMapping("/admin/conta")
    public void editarContaAdmin(@RequestParam String nome, @RequestParam String email, @RequestParam String senha) throws NaoEncontradoPeloIdException, ContaDuplicadaException, EmailInvalidoExeception{
        fachadaAdmin.editarContaAdmin(nome, email, senha);
    }

    @DeleteMapping("/admin/conta")
    public void deletarContaAdmin() throws ContaNaoEncontradaException{
        fachadaAdmin.deletarConta();
    }
    
}
