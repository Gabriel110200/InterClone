/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Conta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ContaDao;

/**
 *
 * @author T-Gamer
 */
@WebServlet(name = "ContaController", urlPatterns = {"/ContaController"})
public class ContaController extends HttpServlet {

   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = (String) request.getParameter("acao");
        Conta conta = new Conta();
        ContaDao contaDao = new ContaDao();
        int id;

        switch (acao) {

            case "inserir":

                conta.setId(0);
                conta.setAgencia(""); 
                conta.setBanco(""); 
                conta.setConta_corrente(""); 
                
               
                request.setAttribute("conta", conta);
                RequestDispatcher incluir = request.getRequestDispatcher("/externo/cadastroConta.jsp");
                incluir.forward(request, response);

                break;

            case "editar":

                id = Integer.parseInt(request.getParameter("id"));
                conta = contaDao.getContaPorId(id);
                request.setAttribute("categoria", conta);

                RequestDispatcher editar = request.getRequestDispatcher("/externo/cadastroConta.jsp");
                editar.forward(request, response);

                break;

            case "excluir":
                id = Integer.parseInt(request.getParameter("id"));
                contaDao.remover(id);
                RequestDispatcher excluir = request.getRequestDispatcher("/externo/mostrarConta.jsp");
                excluir.forward(request, response);
                break;

        }
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Conta conta = new Conta(); 
        ContaDao contaDao = new ContaDao(); 
        
        String nome_conta =  request.getParameter("nome_conta");  
        String banco =  request.getParameter("banco");
        String agencia =  request.getParameter("agencia");
        String conta_corrente =  request.getParameter("conta_corrente"); 
        
        conta.setNome_conta(nome_conta);
        conta.setBanco(banco); 
        conta.setAgencia(agencia); 
        conta.setConta_corrente(conta_corrente); 
        
        contaDao.inserir_conta(conta); 
        
        RequestDispatcher sucesso = request.getRequestDispatcher("externo/sucesso.html"); 
        sucesso.forward(request, response);
      
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
