<%@page import="aplicacao.Lancamento"%>
<%@page import="model.LancamentoDao"%>
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
                <h1>Lancamentos</h1> 
                
                <p>saldo:</p>
                    <%
                        int id = Integer.parseInt(request.getParameter("id"));
                        float valor_credito = 0;
                        float valor_debito = 0;

                        if (valor_credito > valor_debito) {
                    %> 

                <div class="alert alert-danger" role="alert">
                    Sua conta está em negativo!
                </div>


                <%  }
                    LancamentoDao lancamentoDao = new LancamentoDao();
                    ArrayList<Lancamento> lancamento_lista = lancamentoDao.mostrar_lancamentos(id);
                    Lancamento lancamento = new Lancamento();

                    for (int i = 0; i < lancamento_lista.size(); i++) {
                        lancamento = lancamento_lista.get(i);

                        if (lancamento.getOperacao() == "C") {
                            valor_credito += lancamento.getValor();
                        } else {
                            valor_debito += lancamento.getValor();
                        }
                %>


                <tr>

                    <td><%= lancamento.getId()%></td>
                    <td><%= lancamento.getId_conta()%></td> 
                    <td><%= lancamento.getId_categoria()%></td> 
                    <td><%= lancamento.getValor()%></td> 
                    <td><%= lancamento.getOperacao()%></td> 
                    <td><%= lancamento.getData()%></td> 
                    <td><%= lancamento.getDescricao()%></td>
                    <td> <a class="btn btn-success" href="AdministradorController?acao=editar&id=<%= lancamento.getId()%>">Editar</a>   
                        <a class="btn btn-danger" href="AdministradorController?acao=excluir&id=<%= lancamento.getId()%>"> Excluir</a></td>
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