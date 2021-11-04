/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Lancamento;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LancamentoDao;

/**
 *
 * @author T-Gamer
 */
@WebServlet(name = "LancamentoController", urlPatterns = {"/LancamentoController"})
public class LancamentoController extends HttpServlet {

 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = (String) request.getParameter("acao");
        Lancamento lancamento = new Lancamento();
        LancamentoDao lancamentoDao = new LancamentoDao(); 
        int id;
      

        switch (acao) {

            case "inserir":

                lancamento.setId(0);  
                lancamento.setValor(0); 
                lancamento.setOperacao(""); 
                lancamento.setData(""); 
                lancamento.setDescricao("");

                request.setAttribute("lancamento", lancamento);
                RequestDispatcher incluir = request.getRequestDispatcher("/externo/cadastroLancamento.jsp");
                incluir.forward(request, response);

                break;

            case "editar":

                id = Integer.parseInt(request.getParameter("id"));
       //         lancamento = lancamentoDao.getLancamentoPorId(id);
                request.setAttribute("lancamento", lancamento);

                RequestDispatcher editar = request.getRequestDispatcher("/externo/cadastroLancamento.jsp");
                editar.forward(request, response);

                break; 
                
            case "mostrar": 
                
                id = Integer.parseInt(request.getParameter("id")); 
                
                request.setAttribute("id",id); 
                
                RequestDispatcher mostrar = request.getRequestDispatcher("externo/mostrarLancamentos.jsp"); 
                mostrar.forward(request, response);
                
                
            
            break;
                

            case "excluir":
                id = Integer.parseInt(request.getParameter("id"));
                lancamentoDao.remover(id);
                RequestDispatcher excluir = request.getRequestDispatcher("/externo/mostrarLancamento.jsp");
                excluir.forward(request, response);
                break;

        }
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     try { 
         
         Lancamento lancamento = new Lancamento();
         LancamentoDao lancamentoDao = new LancamentoDao();
         
         int id = Integer.parseInt(request.getParameter("id"));
         int id_conta = Integer.parseInt(request.getParameter("id_conta"));
         int id_categoria  = Integer.parseInt(request.getParameter("id_categoria"));
         float valor = Float.parseFloat(request.getParameter("valor"));
         String operacao  =  request.getParameter("operacao"); 
         String descricao =  request.getParameter("descricao"); 
         
         // tentativa de pegar data por request  
         String data = request.getParameter("data");
         
       
         
         
         
         lancamento.setId(id);
         lancamento.setId_conta(id_conta); ;
         lancamento.setId_categoria(id_categoria); ;
         lancamento.setValor(valor); ;
         lancamento.setOperacao(operacao); ;
         lancamento.setDescricao(descricao);  
         lancamento.setData(data);
         
         lancamentoDao.inserir(lancamento); ;
         
         RequestDispatcher sucesso = request.getRequestDispatcher("externo/sucesso.html");
         sucesso.forward(request, response);
     } catch (Exception ex) {
         Logger.getLogger(LancamentoController.class.getName()).log(Level.SEVERE, null, ex);
     }
      
    }

}
