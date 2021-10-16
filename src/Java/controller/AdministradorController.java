/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Administrador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AdministradoresDao;

/**
 *
 * @author T-Gamer
 */
@WebServlet(name = "AdministradorController", urlPatterns = {"/AdministradorController"})
public class AdministradorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        Administrador adm = new Administrador();
        AdministradoresDao admDao = new AdministradoresDao();
        int id; 
        
        switch (acao) {

            case "inserir":

                adm.setId(0);
                adm.setCpf("");
                adm.setNome("");
                adm.setSenha("");
                request.setAttribute("adm", adm);
                RequestDispatcher rd = request.getRequestDispatcher("/interno/cadastroAdmin.jsp");
                rd.forward(request, response);

                break;

            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                adm = admDao.getAdmnPorId(id);
                request.setAttribute("adm", adm);

                RequestDispatcher editar = request.getRequestDispatcher("/interno/cadastroAdmin.jsp");
                editar.forward(request, response);

                break;

            case "excluir":
                id = Integer.parseInt(request.getParameter("id"));
                admDao.excluir(id);
                RequestDispatcher excluir = request.getRequestDispatcher("/interno/mostrarAdmin.jsp");
                excluir.forward(request, response);

                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Administrador adm = new Administrador();
        AdministradoresDao admDao = new AdministradoresDao();

        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");

        adm.setId(id);
        adm.setCpf(cpf);
        adm.setNome(nome);
        adm.setSenha(senha);

        admDao.inserir(adm);

        RequestDispatcher rd = request.getRequestDispatcher("/interno/sucesso.html");
        rd.forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
