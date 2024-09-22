package br.edu.ufape.poo.listadecompras.listadecompras.testes;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.listadecompras.dados.IRepositorioContas;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Usuario;

@SpringBootTest
public class NegocioContaTest {

    @Autowired
    private IRepositorioContas repositorioContas;


    @Test
    void salvarContaTeste(){

        long qtdContas = repositorioContas.count();
        Conta c = new Usuario("Aline", "aliinanda@gmail.com", "12345");
   
        repositorioContas.save(c);
        long qtdContas2 = repositorioContas.count();

        assertEquals(qtdContas + 1, qtdContas2);
    } 

    @Test
    void removerContaTeste(){

        long qtdContas = repositorioContas.count();
        Conta c = repositorioContas.findByEmail("aliinanda@gmail.com").get(0);
        repositorioContas.delete(c);
        long qtdContas2 = repositorioContas.count();

        assertEquals(qtdContas - 1, qtdContas2);
    } 

    @BeforeEach
    void inicializarContaTeste(){

        Conta c = new Usuario("Aline", "aliinanda@gmail.com", "12345");
        Conta a = new Usuario("Clauderson", "clauderson@gmail.com", "aFline");
        Conta b = new Usuario("Jeaso", "jeasiel@gmail.com", "codecode1");
        Conta d = new Usuario("Abraao", "abrplaytube@gmail.com", "abr15");
        
        repositorioContas.save(a);
        repositorioContas.save(b);
        repositorioContas.save(c);
        repositorioContas.save(d);


    } 
}
