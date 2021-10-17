<%@page import="model.CategoriaDao"%>
<%@page import="aplicacao.Categoria"%>
 

<%@page import="model.ConexaoDao"%>
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
                        <th scope="col">descricao</th> 
                        <th scope="col">Alterar</th>
                      
                    </tr>
                </thead> 

                <tbody>

                    <%  CategoriaDao categoriaDao = new CategoriaDao();

                        ArrayList<Categoria> list_categoria = categoriaDao.mostrar();    ;

                        for (int i = 0; i < list_categoria.size(); i++) {
                            Categoria categoria = list_categoria.get(i);
                    %> 


                    <tr>

                        <td><%= categoria.getId()%></td>
                        <td><%= categoria.getDescricao() %></td> 
                       
                        <td> <a class="btn btn-success" href="CategoriaController?acao=editar&id=<%= categoria.getId() %>">Editar</a>   
                            <a class="btn btn-danger" href="CategoriaController?acao=excluir&id=<%= categoria.getId() %>"> Excluir</a></td>
                    </tr>
                    <% } %>
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