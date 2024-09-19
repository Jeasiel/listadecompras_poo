package br.edu.ufape.poo.listadecompras.negocios.entidade;

public abstract class Conta{
    
    private String nome;
    private String email;
    private String senha;

    public Conta(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public void editarConta(String nome, String email, String senha){
        if(nome != null){
            this.nome = nome;
        }
        if(email != null){
            this.email = email;
        }
        if(senha != null){
            this.senha = senha;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
 
}