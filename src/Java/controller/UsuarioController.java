/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Usuario;
import model.ConexaoDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author T-Gamer
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = (String) request.getParameter("acao");
        ConexaoDao usuariodao = new ConexaoDao();
        int id;
        Usuario usuario = new Usuario();

       

            switch (acao) {

                case "inserir":

                    usuario.setId(0);
                    usuario.setCpf("");
                    usuario.setNome("");
                    usuario.setSenha("");
                    usuario.setSuspenso("N");

                    request.setAttribute("usuario", usuario); 
                    
                    RequestDispatcher inserir =  getServletContext().getRequestDispatcher("/interno/cadastroUsuario.jsp");
                    inserir.forward(request, response);

                    break;

                case "editar":

                    id = Integer.parseInt(request.getParameter("id"));
                    usuario = usuariodao.getUsuarioPorId(id);
                    request.setAttribute("usuario", usuario);
                    RequestDispatcher editar = request.getRequestDispatcher("/interno/cadastroUsuario.jsp");
                    editar.forward(request, response);

                    break;

                case "excluir":

                    id = Integer.parseInt(request.getParameter("id"));
                    usuariodao.excluir_usuario(id);
                    RequestDispatcher excluir = request.getRequestDispatcher("/interno/mostrarUsuarios.jsp");
                    excluir.forward(request, response);

                    break;

            }
      

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ConexaoDao usuariodao = new ConexaoDao();

        int id = Integer.parseInt(request.getParameter("id"));
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("name");
        String senha = request.getParameter("password");

        Usuario usuario = new Usuario(id, nome, cpf, senha, "N");

        usuariodao.inserir_usuarios(usuario);

        RequestDispatcher rd = request.getRequestDispatcher("/interno/sucesso.html");
        rd.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
