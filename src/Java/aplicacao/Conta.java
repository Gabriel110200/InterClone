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
public class Conta {
    int id; 
    int id_usuario; 
    String nome_conta; 
    String banco; 
    String agencia; 
    String conta_corrente; 
    
    public Conta(){
        
    }

    public Conta(int id, int id_usuario, String nome_conta, String banco, String agencia, String conta_corrente) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.nome_conta = nome_conta;
        this.banco = banco;
        this.agencia = agencia;
        this.conta_corrente = conta_corrente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_conta() {
        return nome_conta;
    }

    public void setNome_conta(String nome_conta) {
        this.nome_conta = nome_conta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta_corrente() {
        return conta_corrente;
    }

    public void setConta_corrente(String conta_corrente) {
        this.conta_corrente = conta_corrente;
    }
    
    
}
