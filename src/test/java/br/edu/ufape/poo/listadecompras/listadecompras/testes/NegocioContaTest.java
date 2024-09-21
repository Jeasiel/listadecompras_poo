package br.edu.ufape.poo.listadecompras.listadecompras.testes;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.listadecompras.negocios.NegocioConta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Usuario;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaDuplicadaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.EmailInvalidoExeception;

@SpringBootTest
public class NegocioContaTest {

    @Autowired
    private NegocioConta negocioConta;


    @Test
    public void salvarConta(Conta entity)
    throws ContaDuplicadaException, EmailInvalidoExeception{

        long qtdContas = negocioConta.quantidadeContas();
        Conta c = new Usuario("Aline", "aliinanda@gmail.com", "12345");

        negocioConta.salvarConta(c);
        long qtdContas2 = negocioConta.quantidadeContas();

        assertEquals(qtdContas + 1, qtdContas2);
    } 
}
