/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoriaDao;

/**
 *
 * @author T-Gamer
 */
@WebServlet(name = "CategoriaController", urlPatterns = {"/CategoriaController"})
public class CategoriaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = (String) request.getParameter("acao");
        Categoria categoria = new Categoria();
        CategoriaDao categoriaDao = new CategoriaDao();
        int id;

        switch (acao) {

            case "inserir":

                categoria.setId(0);
                categoria.setDescricao("");
                request.setAttribute("categoria", categoria);
                RequestDispatcher incluir = request.getRequestDispatcher("/interno/cadastroCategoria.jsp");
                incluir.forward(request, response);

                break;

            case "editar":

                id = Integer.parseInt(request.getParameter("id"));
                categoria = categoriaDao.getCategoriaPorId(id);
                request.setAttribute("categoria", categoria);

                RequestDispatcher editar = request.getRequestDispatcher("/interno/cadastroCategoria.jsp");
                editar.forward(request, response);

                break;

            case "excluir":
                id = Integer.parseInt(request.getParameter("id"));
                categoriaDao.remover(id);
                RequestDispatcher excluir = request.getRequestDispatcher("/interno/mostrarCategoria.jsp");
                excluir.forward(request, response);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CategoriaDao categoriaDao = new CategoriaDao();
        Categoria categoria = new Categoria();
        int id = Integer.parseInt(request.getParameter("id"));
        String descricao = request.getParameter("descricao");

        categoria.setDescricao(descricao); 
        categoriaDao.inserir(categoria); 
        
        RequestDispatcher rd = request.getRequestDispatcher("/interno/sucesso.jsp"); 
        rd.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
