/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import aplicacao.Lancamento;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
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
@WebServlet(name = "LancamentoDao", urlPatterns = {"/LancamentoDao"})
public class LancamentoDao extends HttpServlet {
    
    Connection conexao;
    public LancamentoDao(){
        try {
            conexao = Conexao.criaConexao();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void inserir(Lancamento lancamento) throws ParseException{ 
        String sql;
        if(lancamento.getId()==0)
             sql  = "INSERT INTO lancamentos(id_conta,id_categoria,valor,operacao,data,descricao) VALUES(?,?,?,?,?,?)"; 
        else 
            sql = "UPDATE lancamentos SET id_conta= ? , id_categoria=?,  "
                    + "valor=?, operacao=?,data = ?,descricao = ? WHERE id = ?";
        
        
        PreparedStatement stmt; 
        try {
            stmt = conexao.prepareStatement(sql);  
            
            
            
            Date data = Date.valueOf(lancamento.getData()) ;
            
            stmt.setInt(1,lancamento.getId_conta()); 
            stmt.setInt(2,lancamento.getId_categoria()); 
            stmt.setFloat(3,lancamento.getValor()); 
            stmt.setString(4,lancamento.getOperacao()); 
            stmt.setDate(5,data); 
            stmt.setString(6,lancamento.getDescricao());  
            
            if(lancamento.getId()>0){
                stmt.setInt(7, lancamento.getId());
            }
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     
    } 
    
    
     public ArrayList<Lancamento> mostrar_lancamentos(int id) {

        ArrayList<Lancamento> lancamento_list = new ArrayList<>();

        try {

            String sql = "SELECT * FROM lancamentos WHERE id_conta = " + id;
            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery(sql); 
            Lancamento lancamento = new Lancamento(); 
            
              
              
            while (rs.next()) {
                    
               
                       lancamento.setId( rs.getInt("id"));
                       lancamento.setId_conta( rs.getInt("id_conta")); 
                       lancamento.setId_categoria( rs.getInt("id_categoria"));
                       lancamento.setValor( rs.getFloat("valor"));
                       lancamento.setOperacao(rs.getString("operacao"));
                       Date date = rs.getDate("data"); 
                       String data = date.toString(); 
                       lancamento.setData(data);
                       lancamento.setDescricao(rs.getString("desricao"));


            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lancamento_list;

    }
   
     
     public Lancamento getLancamentoPorId(int id) {
       
        try {

            String sql = "SELECT  * FROM usuarios";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery(sql); 
            
           

            while (rs.next()) {

                if (id == rs.getInt("id"));
                { 
                    int id_conta = rs.getInt("id_conta"); 
                    int id_categoria = rs.getInt("id_categoria");
                    float valor = rs.getFloat("valor");
                    String operacao = rs.getString("operacao");
                    Date date =  rs.getDate("data"); 
                    String data = date.toString();
                    String descricao = rs.getString("descricao");

                    Lancamento lancamento = new Lancamento(id,id_conta,id_categoria, valor, operacao, data, descricao); 
                    
                    return lancamento;

                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;

    } 
     
     
     public void remover(int id) {

        try {
            String sql = "DELETE FROM lancamentos WHERE id=?"; 
            
            PreparedStatement stmt = conexao.prepareStatement(sql); 
            
            stmt.setInt(1,id);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
     
   
}
