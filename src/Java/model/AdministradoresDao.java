/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aplicacao.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author T-Gamer
 */
@WebServlet(name = "AdministradoresDao", urlPatterns = {"/AdministradoresDao"})
public class AdministradoresDao extends HttpServlet {

    private Connection conexao = null;

    public  AdministradoresDao() {
        try {
            conexao = Conexao.criaConexao();
        } catch (SQLException ex) {
            Logger.getLogger(AdministradoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    public int validarLogin(String cpf,String senha){
        
        String sql  = "SELECT * FROM administradores"; 
        int value = 0;
        
        try { 
            
            Statement stmt = conexao.createStatement(); 

            ResultSet rs = stmt.executeQuery(sql); 
            
            
            while(rs.next()){
                
              String cpf_table = rs.getString("cpf"); 
              String senha_table = rs.getString("senha"); 
              
              if(cpf_table.equals(cpf) && senha_table.equals(senha)){
                  
                  value = Integer.parseInt(rs.getString("id")); 
                  
                  
              }
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return value;
        
    }
    
    public ArrayList<Administrador> mostrar() throws SQLException{
        
        String sql = "SELECT * FROM administradores"; 
        ArrayList<Administrador> lista_adm = new ArrayList<>();
       
        
        Statement stmt = conexao.createStatement(); 
        
        ResultSet rs = stmt.executeQuery(sql); 
        
        while(rs.next()){
            Administrador adm = new Administrador(); 
            adm.setId(rs.getInt("id")); 
            adm.setNome(rs.getString("nome")); 
            adm.setCpf(rs.getString("cpf")); 
            adm.setSenha(rs.getString("senha")); 
            lista_adm.add(adm);
            
            
        }
        
      
        return lista_adm;
        
    } 
    
    

    public void inserir(Administrador administrador) {
        String sql; 
        
        if (administrador.getId() == 0) {
            sql = "INSERT INTO administradores(nome,cpf,senha) VALUES (?,?,?)";

        } else {
            sql = "UPDATE administradores SET nome=?,cpf=?,senha=? WHERE id=? ";
        }

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

           
            stmt.setString(1, administrador.getNome());
            stmt.setString(2, administrador.getCpf());
            stmt.setString(3, administrador.getSenha()); 
            
            if(administrador.getId()>0){
                 stmt.setInt(4, administrador.getId());
            }
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AdministradoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Administrador getAdmnPorId(int id) {

        String sql = "SELECT * FROM administradores";
        Administrador adm = new Administrador();

        try {
            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                if (rs.getInt("id") == id) {

                    adm.setId(id);
                    adm.setNome(rs.getString("nome"));
                    adm.setCpf(rs.getString("cpf"));
                    adm.setSenha(rs.getString("senha"));

                } 

            }

        } catch (SQLException ex) {
            Logger.getLogger(AdministradoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return adm;
    } 
    
    
    public void excluir(int id){
        
        String sql  = "DELETE FROM administradores WHERE id=? "; 
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql); 
            stmt.setInt(1, id);
            stmt.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
