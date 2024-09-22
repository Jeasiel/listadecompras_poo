package br.edu.ufape.poo.listadecompras.listadecompras.testes;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.listadecompras.dados.IRepositorioContas;
import br.edu.ufape.poo.listadecompras.dados.IRepositorioListas;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Lista;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Usuario;

@SpringBootTest
public class NegocioListaTest {

    @Autowired
    private IRepositorioListas repositoriolListas;
    @Autowired
    private IRepositorioContas repositorioContas;

    @Test
    void salvarListaTeste(){

        Conta c = repositorioContas.findByEmail("abrplaytube@gmail.com").get(0);
        Lista a = new Lista("note", "Mercado", c);
        long qtdLista = repositoriolListas.count();
        repositoriolListas.save(a);
        long qtdLista2 = repositoriolListas.count();
        assertEquals(qtdLista + 1, qtdLista2);

    } 

    @Test
    void removerListaTeste(){

      
    } 

    @BeforeEach
    void inicializarListaTeste(){

        Conta c = new Usuario("Aline", "aliinanda@gmail.com", "12345");
        Conta a = new Usuario("Clauderson", "clauderson@gmail.com", "aFline");
        Conta b = new Usuario("Jeaso", "jeasiel@gmail.com", "codecode1");
        Conta d = new Usuario("Abraao", "abrplaytube@gmail.com", "abr15");
        Lista e = new Lista("note", "Mercado", c);

        repositorioContas.save(a);
        repositorioContas.save(b);
        repositorioContas.save(c);
        repositorioContas.save(d);


    } 
}
