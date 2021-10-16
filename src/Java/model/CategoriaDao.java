/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import aplicacao.Categoria;
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
@WebServlet(name = "CategoriaDao", urlPatterns = {"/CategoriaDao"})
public class CategoriaDao extends HttpServlet {

    private Connection conexao = null;

    public CategoriaDao() {

        try {
            conexao = Conexao.criaConexao();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Categoria> mostrar() throws SQLException {

        String sql = "SELECT * FROM administradores";
        ArrayList<Categoria> lista_categoria = new ArrayList<>();

        Statement stmt = conexao.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) { 
            
            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt("id"));
            categoria.setDescricao(rs.getString("descricao"));
            lista_categoria.add(categoria);

        }

        return lista_categoria;

    }

    public void inserir(Categoria categoria) throws SQLException {

        String sql;

        if (categoria.getId() == 0) {
            sql = "INSERT INTO categorias(descricao) VALUES(?)";
        } else {
            sql = "UPDATE categorias SET  descricao = ? WHERE id =?";
        }

        PreparedStatement stmt = conexao.prepareStatement(sql);

        
        stmt.setString(1, categoria.getDescricao()); 
        
        if(categoria.getId()>0){
            stmt.setInt(2, categoria.getId());
        }

        stmt.executeUpdate();

    }

    public void remover(int id) {

        String sql = "DELETE FROM categorias WHERE id=? ";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AdministradoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
