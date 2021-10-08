/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

/**
 *
 * @author T-Gamer
 */
public class Usuario {
    
    public int id; 
    public String nome; 
    public String cpf;
    public String senha; 
    public String suspenso;  
    
    public Usuario(){
        
    }

    public Usuario(int id, String cpf, String nome, String senha, String suspenso) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.suspenso = suspenso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSuspenso() {
        return suspenso;
    }

    public void setSuspenso(String suspenso) {
        this.suspenso = suspenso;
    }
    
    
    
    
    
}
