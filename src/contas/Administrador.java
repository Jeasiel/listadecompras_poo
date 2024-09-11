package contas;

public class Administrador extends ContaAbstrata{
    
    public Administrador(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    @Override
    public void fazerLogin(String email, String senha) {
        //fazer método
    }

    @Override
    public void atualizarCadastro(String email, String senha) {
        //fazer método
    }
    
    public void gerenciarContas(){
        //fazer método
    }

    public void gerenciarListas(){
        //fazer método
    }
}