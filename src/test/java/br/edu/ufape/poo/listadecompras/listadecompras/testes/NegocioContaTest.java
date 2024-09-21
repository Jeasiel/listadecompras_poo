package br.edu.ufape.poo.listadecompras.listadecompras.testes;


import static org.junit.jupiter.api.Assertions.assertEquals;
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
}
