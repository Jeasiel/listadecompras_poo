package br.edu.ufape.poo.listadecompras.listadecompras.testes_integração;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.listadecompras.dados.IRepositorioContas;
import br.edu.ufape.poo.listadecompras.negocios.NegocioConta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Usuario;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaDuplicadaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.EmailInvalidoExeception;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloEmailException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.SenhaErradaException;
import br.edu.ufape.poo.listadecompras.negocios.fachada.FachadaUsuario;

@SpringBootTest
public class NegocioContaTest {

    @Autowired
    private IRepositorioContas repositorioContas;
    private FachadaUsuario fachada;
    private NegocioConta negocioConta;

    @Test
    void salvarContaTeste() 
    throws ContaNaoEncontradaException, EmailInvalidoExeception, ContaDuplicadaException{ 

        long qtdContas = repositorioContas.count();
        fachada.criarContaUsuario("Alvin", "alvin@gmail.com", "56743");
        long qtdContas2 = repositorioContas.count();
        assertEquals(qtdContas + 1, qtdContas2);
    } 

    @Test
    void removerContaTeste() throws ContaNaoEncontradaException, NaoEncontradoPeloEmailException, SenhaErradaException{

        long qtdContas = repositorioContas.count();
        fachada.login("aliinanda@gmail.com", "12345");
        fachada.deletarConta();
        long qtdContas2 = repositorioContas.count();

        assertEquals(qtdContas - 1, qtdContas2);
    } 

    @BeforeEach
    void inicializarContaTeste() throws ContaDuplicadaException, EmailInvalidoExeception, ContaNaoEncontradaException, SenhaErradaException, NaoEncontradoPeloEmailException{
        
        Conta c = new Usuario("Aline", "aliinanda@gmail.com", "12345");
        Conta a = new Usuario("Clauderson", "clauderson@gmail.com", "aFline");
        Conta b = new Usuario("Jeaso", "jeasiel@gmail.com", "codecode1");
        Conta d = new Usuario("Abraao", "abrplaytube@gmail.com", "abr15");


        repositorioContas.save(a);
        repositorioContas.save(b);
        repositorioContas.save(c);
        repositorioContas.save(d);
        
        fachada = new FachadaUsuario();
        negocioConta = new NegocioConta();
        negocioConta.setRepositorioContas(repositorioContas);
        fachada.setCadastroConta(negocioConta);

    } 
}
