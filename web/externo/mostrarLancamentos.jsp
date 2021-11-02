<%@page import="java.util.ArrayList"%>
<%@page import="model.ContaDao"%>
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
                        <th scope="col">id_conta</th>
                        <th scope="col">id_categoria</th>
                        <th scope="col">valor</th> 
                        <th scope="col">operacao</th> 
                        <th scope="col">data</th> 
                        <th scope="col">descricao</th>
                            
                    </tr>
                </thead> 

                <tbody>
                <h1>Clique no nome da conta para seleciona-la e cadastrar lancamentos</h1>
                    <%  ContaDao contaDao = new ContaDao();
                        ArrayList<Conta> conta_lista = contaDao.mostrar();
                        Conta conta = new Conta();

                        for (int i = 0; i < conta_lista.size(); i++) {
                            conta = conta_lista.get(i);
                    %>


                    <tr>

                        <td><%= conta.getNome_conta()%></td>
                        <td><%= conta.getAgencia()%></td> 
                        <td><%= conta.getBanco() %></td> 
                        <td><%= conta.getConta_corrente() %></td>
                        <td> <a class="btn btn-success" href="AdministradorController?acao=editar&id=<%= conta.getId()%>">Editar</a>   
                            <a class="btn btn-danger" href="AdministradorController?acao=excluir&id=<%= conta.getId()%>"> Excluir</a></td>
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