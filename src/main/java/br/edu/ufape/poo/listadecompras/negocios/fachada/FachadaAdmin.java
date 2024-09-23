package br.edu.ufape.poo.listadecompras.negocios.fachada;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.listadecompras.negocios.cadastro.InterfaceCadastroConta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Administrador;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Conta;
import br.edu.ufape.poo.listadecompras.negocios.entidade.Usuario;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaDuplicadaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.ContaNaoEncontradaException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.EmailInvalidoExeception;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloEmailException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.NaoEncontradoPeloIdException;
import br.edu.ufape.poo.listadecompras.negocios.excecoes.SenhaErradaException;

@Service
public class FachadaAdmin {
    
	@Autowired
	private InterfaceCadastroConta cadastroConta;

	private Administrador adminLogado;

	//Gerencia contas | CRUD
	//Talvez seja necessário fazer um método de editar em cada uma das classes de negócio
	public void editarContaUsuario(Conta conta, String nome, String email, String senha) throws NaoEncontradoPeloIdException, ContaDuplicadaException, EmailInvalidoExeception{
		Conta c = cadastroConta.localizarContaId(conta.getId()).get();
		if(nome != null){
			c.setNome(nome);
		}
		if(email != null){
			c.setEmail(email);
		}
		if(senha != null){
			c.setSenha(senha);
		}
		cadastroConta.removerConta(c.getId());
		cadastroConta.salvarConta(c);
	}

	public void deletarContaUsuario(Conta conta) throws NaoEncontradoPeloIdException{
		cadastroConta.removerConta(conta.getId());
	}

	//Mexe com a conta do adm
	public void criarContaAdmin(String nome, String email, String senha) throws ContaNaoEncontradaException, ContaDuplicadaException, EmailInvalidoExeception{
        cadastroConta.salvarConta(new Administrador(nome, email, senha));
    }

	public void editarContaAdmin(String nome, String email, String senha) throws NaoEncontradoPeloIdException, ContaDuplicadaException, EmailInvalidoExeception{
        if(!"".equals(nome)){
            adminLogado.setNome(nome);
        }
        if(!"".equals(email)){
            adminLogado.setEmail(email);
        }
        if(!"".equals(senha)){
            adminLogado.setSenha(senha);
        }
        if(!(!"".equals(nome) && !"".equals(email) && !"".equals(senha))){
            Administrador u = (Administrador) cadastroConta.localizarContaId(adminLogado.getId()).get();
            u.setNome(nome);
            u.setEmail(email);
            u.setSenha(senha);
            cadastroConta.salvarConta(u);
        }
    }
	public void deletarConta() throws ContaNaoEncontradaException{
		cadastroConta.removerConta(adminLogado);
		logoff();
    }

    public void login(String email, String senha) throws NaoEncontradoPeloEmailException, SenhaErradaException{
        this.adminLogado = (Administrador) cadastroConta.login(email, senha);
    }

	public void logoff(){
        this.adminLogado = null;
    }

    public Administrador getAdminLogado() {
        return adminLogado;
    }

	public List<Usuario> getUsuarios(){
		List<Usuario> out = new ArrayList<>();
		for(int i = 0; i < cadastroConta.listarContas().size(); i++){
			if(cadastroConta.listarContas().get(i).getClass() != new Administrador().getClass()){
				out.add((Usuario) cadastroConta.listarContas().get(i));
			}
		}
		return out;
	}
}
