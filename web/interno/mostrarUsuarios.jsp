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
        <base href="/InterClone/" target="_blank" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/bootstrap.min.css" />
    </head>
    <body> 
        <div class="container pt-3">
            <table class="table"> 

                <thead>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">cpf</th>
                        <th scope="col">nome</th>
                        <th scope="col">senha</th> 
                        <th scope="col">Alterar</th>
                    </tr>
                </thead> 

                <tbody>

                    <%  ConexaoDao usuarioDao = new ConexaoDao();

                        ArrayList<Usuario> usuarios = usuarioDao.mostrar_usuarios();

                        for (int i = 0; i < usuarios.size(); i++) {
                            Usuario usuario = usuarios.get(i);
                    %> 


                    <tr>

                        <td><%= usuario.getId()%></td>
                        <td><%= usuario.getCpf()%></td> 
                        <td><%= usuario.getNome()%></td> 
                        <td><%= usuario.getSenha()%></td>
                        <td> <a class="btn btn-success" href="UsuarioController?acao=editar&id=<%= usuario.getId() %>">Editar</a>   
                            <a class="btn btn-danger" href="UsuarioController?acao=excluir&id=<%= usuario.getId() %>"> Excluir</a></td>
                    </tr>
                    <% }%>
                </tbody>
            </table>  
        </div>

        <script src="js/jquery-3.6.0.min.js"></script>
        <script src="js/jquery.mask.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.validate.min.js"></script>
        <script src="js/additional-methods.min.js"></script>
        <script src="js/localization/messages_pt_BR.js"></script>
    </body>
</html>
