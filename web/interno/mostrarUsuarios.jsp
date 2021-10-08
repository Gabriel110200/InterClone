<%-- 
    Document   : mostrarUsuarios
    Created on : 07/10/2021, 10:54:13
    Author     : T-Gamer
--%>

<%@page import="model.ConexaoDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="aplicacao.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table class="table"> 
            
            <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">cpf</th>
                    <th scope="col">nome</th>
                    <th scope="col">senha</th>
                </tr>
            </thead> 
            
            <tbody>
            
        <%  ConexaoDao usuarioDao = new ConexaoDao();

            ArrayList<Usuario> usuarios = usuarioDao.mostrar_usuarios();

            for(int i =0;i<usuarios.size();i++){ 
                        Usuario usuario = usuarios.get(i);
        %> 

            
                <tr>
                 
                    <td><%= usuario.getId() %></td>
                    <td><%= usuario.getCpf() %></td> 
                    <td><%= usuario.getNome() %></td> 
                    <td><%= usuario.getSenha() %></td>
                    <td> <a class="btn btn-success" href="UsuarioController?acao=editar&id="<%= usuario.getId() %>>Editar</a>   
                        <a class="btn btn-danger" href="UsuarioController?acao=excluir&id="><%= usuario.getId() %>Excluir</a></td>
                </tr>
             <% } %>
            </tbody>
        </table>

    </body>
</html>
