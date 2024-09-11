package contas;

import listas.Lista;

public class Usuario extends ContaAbstrata{
    
    public Usuario(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    @Override
    public void fazerLogin(String email, String senha) {
        
    }

    @Override
    public void atualizarCadastro(String email, String senha) {
        
    }

    public Lista criarLista(){
        //fazer método
        return new Lista();
    }

    public void editarLista(){
        //fazer método
    }

    public void removerLista(){
        //fazer método
    }
    
}