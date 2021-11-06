
<%@page import="aplicacao.Usuario"%>
<%@page import="aplicacao.Conta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ContaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>  
        <base href="/InterClone/" target="_self" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/bootstrap.min.css" />
    </head>
    <body> 
        <%@include file="sidebar.jsp" %>
        <div class="container pt-3">
            <table class="table"> 

                <thead class="thead-dark">
                    <tr>
                        <th scope="col">id</th> 
                        <th scope="col">Nome da conta</th>
                        <th scope="col">Agencia</th>
                        <th scope="col">Banco</th> 
                        <th scope="col">Conta corrente</th> 
                        <th scope="col">Alterar dados</th>
                    </tr>
                </thead> 

                <tbody>
                <h1>Alterar dados da conta</h1>
                <%
             
                    ContaDao contaDao = new ContaDao();

                    ArrayList<Conta> conta_lista = contaDao.mostrar(usuario.getId());
                    Conta conta = new Conta();

                    for (int i = 0; i < conta_lista.size(); i++) {
                        conta = conta_lista.get(i);
                %>


                <tr>
                    <td><%= conta.getId()%></td>
                    <td><%= conta.getNome_conta()%></td>
                    <td><%= conta.getAgencia()%></td> 
                    <td><%= conta.getBanco()%></td> 
                    <td><%= conta.getConta_corrente()%></td>
                    <td> <a class="btn btn-success" href="UsuarioController?acao=editar&id=<%= conta.getId()%>" target="_self">Editar</a>   
                        <a class="btn btn-danger" href="UsuarioController?acao=excluir&id=<%= conta.getId()%>" target="_self"> Excluir</a> 
                        <a class="btn btn-warning" href="LancamentoController?acao=mostrar&id=<%= conta.getId()%>" target="_self">Verificar lançamentos</a></td>
                </tr>
                <% }%> 

                <a href="externo/index.jsp" target="_self">Voltar</a>
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
