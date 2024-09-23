package br.edu.ufape.poo.listadecompras.listadecompras.testes_unitarios;


import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.listadecompras.dados.IRepositorioContas;
import br.edu.ufape.poo.listadecompras.dados.IRepositorioListas;
import br.edu.ufape.poo.listadecompras.dados.IRepositorioProduto;
import br.edu.ufape.poo.listadecompras.negocios.NegocioConta;
import br.edu.ufape.poo.listadecompras.negocios.NegocioLista;
import br.edu.ufape.poo.listadecompras.negocios.NegocioProduto;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Lista;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Produto;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Usuario;

@SpringBootTest
public class NegocioProdutoTestUnitario {

    @Autowired
    private IRepositorioProduto repositorioProduto;
    @Autowired
    private IRepositorioListas repositorioLista;
    @Autowired
    private IRepositorioContas repositorioContas;

    private NegocioProduto negociosProduto;
    private NegocioLista negociosLista;
    private NegocioConta negociosConta;


    @Test
    void localizarIdProdutoTeste(){
        assertTrue(negociosProduto.localizarIdProduto(1));
    } 


    @BeforeEach
    void inicializarProdutoTeste(){

        Conta c = new Usuario("Aline", "aliinanda@gmail.com", "12345");
        Conta a = new Usuario("Clauderson", "clauderson@gmail.com", "aFline");
        Conta b = new Usuario("Jeaso", "jeasiel@gmail.com", "codecode1");
        Conta d = new Usuario("Abraao", "abrplaytube@gmail.com", "abr15");
        
        repositorioContas.save(a);
        repositorioContas.save(b);
        repositorioContas.save(c);
        repositorioContas.save(d);

        Lista a1 = new Lista("note", "Mercado");
        repositorioLista.save(a1);

        Produto p1 = new Produto("feijão", 12.90, 5);
        repositorioProduto.save(p1);

        negociosConta = new NegocioConta();
        negociosConta.setRepositorioContas(repositorioContas);

        negociosLista = new NegocioLista();
        negociosLista.setRepositorioListas(repositorioLista);

        negociosProduto = new NegocioProduto();
        negociosProduto.setRepositorioProduto(repositorioProduto);
    } 
}
