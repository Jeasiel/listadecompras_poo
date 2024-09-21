package br.edu.ufape.poo.listadecompras.listadecompras;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.listadecompras.dados.IRepositorioContas;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Usuario;

@SpringBootTest
public class IRepositorioContasTest {
    
    @Autowired
    private IRepositorioContas repositorioContas;

    @Test
    void repositoriotest(){
        long qtdUsuario = repositorioContas.count();
        repositorioContas.save(new Usuario("Nome", "wings@gmail.com", "senha"));
        assertEquals(qtdUsuario + 1, repositorioContas.count());
    }
}
