/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    
    

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cpf = request.getParameter("cpf"); 
        String senha = request.getParameter("senha"); 
        AdministradoresDao admDao = new AdministradoresDao(); 
        
        if(admDao.validarLogin(cpf, senha)){
            
            RequestDispatcher rd = request.getRequestDispatcher("interno/index.html"); 
            rd.forward(request, response);
            
            
        } else {
            request.setAttribute("message","Login was not possible"); 
            RequestDispatcher rd = request.getRequestDispatcher("index.html"); 
            rd.forward(request, response);
        }
        
        
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
