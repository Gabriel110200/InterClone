/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import aplicacao.Usuario;
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
@WebServlet(name = "conexaodao", urlPatterns = {"/conexaodao"})
public class ConexaoDao extends HttpServlet {
    
    private Connection conexao;
    
    public void ConexaoDao() {
        
        try {
            
            conexao = Conexao.criaConexao();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Problema ao criar o DAO");
        }
        
    }
    
    public ArrayList<Usuario> mostrar_usuarios() {
        
        ArrayList<Usuario> usuarios = new ArrayList<>();        
        
        try {            
            
            String sql = "SELECT * FROM usuarios";
            Statement stmt = conexao.createStatement();            
            
            ResultSet rs = stmt.executeQuery(sql);            
            
            while (rs.next()) {
                
                Usuario usuario = new Usuario(rs.getInt("id"),
                         rs.getString("cpf"),
                         rs.getString("nome"),
                         rs.getString("senha"),
                         rs.getString("suspenso")); 
                
                usuarios.add(usuario);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return usuarios;
        
    }
    
    public void inserir_usuarios(Usuario usuario) {
        
        String sql;
        if (usuario.getId() == 0) {
            
            sql = "INSERT INTO usuarios(id,nome,cpf,senha,suspenso) VALUES (?,?,?,?,?) ";
            
        } else {
            sql = "UPDATE usuarios SET  cpf=?, nome = ? , senha = ? , suspenso = ?";
        }
        
        try {
            
            PreparedStatement rs = conexao.prepareStatement(sql);
            
            rs.setInt(1, usuario.getId());
            rs.setString(2, usuario.getNome());
            rs.setString(3, usuario.getSenha());
            rs.setString(4, usuario.getSuspenso());
            
            rs.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public Usuario getUsuarioPorId(int id) {
        Usuario usuario = new Usuario();
        try {
            
            String sql = "SELECT  * FROM ususario";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                
                if (id == rs.getInt("id"));
                {
                    String nome = rs.getString("nome");
                    String cpf = rs.getString("cpf");
                    String senha = rs.getString("senha");
                    String sus = rs.getString("suspenso");
                    
                    usuario = new Usuario(id, nome, cpf, senha, sus);
                    
                }
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return usuario;
        
    } 
    
    
    public void excluir_usuario(int id){
        
       
        
        try { 
             String sql = "DELETE usuarios WHERE id=?"; 
             PreparedStatement stmt = conexao.prepareStatement(sql); 
             stmt.execute(); 
             
             

            
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        }
    
    
    
    public void close() throws SQLException {
        conexao.close();
    }
    
} 


