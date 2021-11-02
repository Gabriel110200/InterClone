/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import aplicacao.Conta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author T-Gamer
 */
@WebServlet(name = "ContaDao", urlPatterns = {"/ContaDao"})
public class ContaDao extends HttpServlet {

    private Connection conexao = null;
    public ContaDao(){
        
        try {
            conexao = Conexao.criaConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
    
    public ArrayList<Conta> mostrar(int id){ 
        
        String sql  = "SELECT * FROM contas WHERE id_usuario = " + id; 
        
        ArrayList<Conta> conta_list = new ArrayList();
        
        try { 
           // PreparedStatement stmt = conexao.createStatement();  
           Statement stmt = conexao.createStatement(); 
           
           ResultSet rs = stmt.executeQuery(sql); 
            
          
            
            while(rs.next()){
                Conta conta = new Conta();  
                conta.setId(rs.getInt("id")); 
                conta.setId_usuario(rs.getInt("id_usuario"));
                conta.setAgencia(rs.getString("agencia")); 
                conta.setBanco(rs.getString("banco"));
                conta.setConta_corrente(rs.getString("conta_corrente"));
                conta.setNome_conta(rs.getString("nome_conta"));  
                
                conta_list.add(conta);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return conta_list;
        
        
    }
    
    public void inserir_conta(Conta conta){ 
        String sql;
        if(conta.getId()==0){
           sql  = "INSERT INTO contas(id_usuario,nome_conta,banco,agencia,conta_corrente) VALUES(?,?,?,?,?)";
        } else {
            sql  = "UPDATE contas SET nome_conta =?,banco=?,agencia=?,conta_corrente=? WHERE id=?";
        }
        
        
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql); 
            
            stmt.setInt(1, conta.getId_usuario());
            stmt.setString(2,conta.getNome_conta()); 
            stmt.setString(3,conta.getBanco()); 
            stmt.setString(4,conta.getAgencia()); 
            stmt.setString(5,conta.getConta_corrente());  
            
            if(conta.getId()>0){
                stmt.setInt(5, conta.getId());
            }
            
            
            
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    } 
    
    public Conta getContaPorId(int id) {
       
        try {

            String sql = "SELECT  * FROM usuarios";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Conta conta = new Conta(); 
                if (id == rs.getInt("id"));
                { 
                   
                    String nome_conta = rs.getString("nome_conta");
                    String banco = rs.getString("banco");
                    String agencia = rs.getString("agencia");
                    String conta_corrente = rs.getString("conta_corrente");

                   
                    
                    conta.setNome_conta(nome_conta);
                    conta.setBanco(banco); 
                    conta.setAgencia(agencia); 
                    conta.setConta_corrente(conta_corrente); 
                    
                    return conta;

                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;

    }
    
    public void remover(int id){
        
        String sql = "DELETE FROM contas WHERE id = ?"; 
        
        try { 
            PreparedStatement stmt = conexao.prepareStatement(sql); 
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            
          
            
        } catch (SQLException ex) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
