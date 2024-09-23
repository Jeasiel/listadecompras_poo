package br.edu.ufape.poo.listadecompras.listadecompras.testes_integração;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.listadecompras.dados.IRepositorioContas;
import br.edu.ufape.poo.listadecompras.dados.IRepositorioListas;
import br.edu.ufape.poo.listadecompras.negocios.NegocioConta;
import br.edu.ufape.poo.listadecompras.negocios.NegocioLista;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Usuario;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ListaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloEmailException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloIdException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ProdutoNaoEncontradoException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.SenhaErradaException;
import br.edu.ufape.poo.listadecompras.negocios.fachada.FachadaUsuario;
import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class NegocioListaTest {

    @Autowired
    private IRepositorioListas repositorioListas;
    @Autowired
    private IRepositorioContas repositorioContas;

    private FachadaUsuario fachada;
    private NegocioConta negocioConta;
    private NegocioLista negocioLista;
    

    @Test
    void salvarListaTeste() throws ListaNaoEncontradaException, NaoEncontradoPeloEmailException, SenhaErradaException, ContaNaoEncontradaException{

        long qtdLista = repositorioListas.count();
        fachada.criarLista("note", "Mercado");
        long qtdLista2 = repositorioListas.count();
        assertEquals(qtdLista + 1, qtdLista2);

    } 

    @Test
    void removerListaTeste() throws NaoEncontradoPeloIdException, ListaNaoEncontradaException, ContaNaoEncontradaException, NaoEncontradoPeloEmailException, SenhaErradaException, ProdutoNaoEncontradoException{

        fachada.login("clauderson@gmail.com", "aFline");
        fachada.criarLista("funfa", "jae");
        long qtdLista = repositorioListas.count();
        fachada.removerLista(fachada.getListas().get(0));
        long qtdLista2 = repositorioListas.count();
        assertEquals(qtdLista - 1, qtdLista2);

    } 

    @BeforeEach
    void inicializarListaTeste() throws ListaNaoEncontradaException, NaoEncontradoPeloEmailException, SenhaErradaException, ContaNaoEncontradaException{

        Conta c = new Usuario("Aline", "aliinanda@gmail.com", "12345");
        Conta a = new Usuario("Clauderson", "clauderson@gmail.com", "aFline");
        Conta b = new Usuario("Jeaso", "jeasiel@gmail.com", "codecode1");
        Conta d = new Usuario("Abraao", "abrplaytube@gmail.com", "abr15");

        repositorioContas.save(a);
        repositorioContas.save(b);
        repositorioContas.save(c);
        repositorioContas.save(d);

        fachada = new FachadaUsuario();
        negocioLista = new NegocioLista();
        negocioConta = new NegocioConta();
        negocioConta.setRepositorioContas(repositorioContas);
        fachada.setCadastroConta(negocioConta);
        negocioLista.setRepositorioListas(repositorioListas);
        negocioLista.setRepositorioContas(repositorioContas);
        fachada.setCadastroLista(negocioLista);
        

        
    } 
}
