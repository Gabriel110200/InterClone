/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;

import javax.servlet.ServletException; 
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author T-Gamer
 */
@WebServlet(name = "AcessoAdmin", urlPatterns = {"/AcessoAdmin"})
public class AcessoAdmin extends HttpServlet {

   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String cpf = request.getParameter("cpf"); 
            String password = request.getParameter("password"); 
            
            
            if(cpf.equals("24925281038") || password.equals("111")){
                RequestDispatcher rd = request.getRequestDispatcher("./interno/index.html");
                rd.forward(request, response);
                
            } 
            
            else{ 
                
                RequestDispatcher rd = request.getRequestDispatcher("index2.jsp");
                rd.forward(request,response);
                
            } 
        
        
        
    }

 
}
