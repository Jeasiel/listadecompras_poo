package br.edu.ufape.poo.listadecompras.listadecompras.testes_unitarios;


import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.listadecompras.dados.IRepositorioContas;
import br.edu.ufape.poo.listadecompras.dados.IRepositorioListas;
import br.edu.ufape.poo.listadecompras.negocios.NegocioConta;
import br.edu.ufape.poo.listadecompras.negocios.NegocioLista;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Lista;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Usuario;

@SpringBootTest
public class NegocioListaTestUnitario {

    @Autowired
    private IRepositorioContas repositorioContas;
    @Autowired
    private IRepositorioListas repositorioLista;
    private NegocioConta negociosConta;
    private NegocioLista negociosLista;


    @Test
    void localizarIdListaTeste(){
        assertTrue(negociosLista.localizarIdLista(1));
    } 


    @BeforeEach
    void inicializarListaTeste(){

        Conta c = new Usuario("Aline", "aliinanda@gmail.com", "12345");
        Conta a = new Usuario("Clauderson", "clauderson@gmail.com", "aFline");
        Conta b = new Usuario("Jeaso", "jeasiel@gmail.com", "codecode1");
        Conta d = new Usuario("Abraao", "abrplaytube@gmail.com", "abr15");
        
        repositorioContas.save(a);
        repositorioContas.save(b);
        repositorioContas.save(c);
        repositorioContas.save(d);

        Lista a1 = new Lista("note", "Mercado");
        //repositorioLista.save(a1);
        repositorioLista.save(a1);

        negociosConta = new NegocioConta();
        negociosConta.setRepositorioContas(repositorioContas);

        negociosLista = new NegocioLista();
        negociosLista.setRepositorioListas(repositorioLista);
    } 
}
