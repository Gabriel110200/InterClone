<%-- 
    Document   : mostrarAdmin
    Created on : 14/10/2021, 14:03:16
    Author     : T-Gamer
--%>

<%@page import="model.AdministradoresDao"%>
<%@page import="aplicacao.Administrador"%>
<%@page import="java.util.ArrayList"%>
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
                        <th scope="col">nome</th>
                        <th scope="col">cpf</th>
                        <th scope="col">senha</th> 
                        <th scope="col">Alterar</th>
                    </tr>
                </thead> 

                <tbody>

                    <%  AdministradoresDao admDao = new AdministradoresDao();
                        ArrayList<Administrador> adm_lista = admDao.mostrar();
                        Administrador adm = new Administrador();

                        for (int i = 0; i < adm_lista.size(); i++) {
                            adm = adm_lista.get(i);
                    %>


                    <tr>

                        <td><%= adm.getId()%></td>
                        <td><%= adm.getCpf()%></td> 
                        <td><%= adm.getNome()%></td> 
                        <td><%= adm.getSenha()%></td>
                        <td> <a class="btn btn-success" href="AdministradorController?acao=editar&id=<%= adm.getId()%>">Editar</a>   
                            <a class="btn btn-danger" href="AdministradorController?acao=excluir&id=<%= adm.getId()%>"> Excluir</a></td>
                    </tr>
                    <% }%>
                </tbody>
            </table>  
        </div>


    </body> 

    <script src="js/jquery-3.6.0.min.js"></script>
    <script src="js/jquery.mask.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/additional-methods.min.js"></script>
    <script src="js/localization/messages_pt_BR.js"></script>


</html>
