package br.edu.ufape.poo.listadecompras.listadecompras.testes_unitarios;


import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.listadecompras.dados.IRepositorioContas;
import br.edu.ufape.poo.listadecompras.negocios.NegocioConta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Usuario;

@SpringBootTest
public class NegocioContaTestUnitario {

    @Autowired
    private IRepositorioContas repositorioContas;
    private NegocioConta negociosConta;


    @Test
    void localizarIdContaTeste(){
        assertTrue(negociosConta.localizarIdConta(1));
    } 

    @Test
    void quantidadeContasTeste(){
        assertTrue(negociosConta.quantidadeContas() >= 4);
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

        negociosConta = new NegocioConta();
        negociosConta.setRepositorioContas(repositorioContas);

    } 
}
