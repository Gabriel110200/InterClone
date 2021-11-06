<%@page import="aplicacao.Lancamento"%>
<%@page import="aplicacao.Categoria"%>
<%@page import="model.CategoriaDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ContaDao"%>
<%@page import="aplicacao.Conta"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <base href="/InterClone/" target="_self" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/bootstrap.min.css" />

        <title>Cadastro</title>
    </head>
    <body> 
        <%@include file="sidebar.jsp" %>
        <div class="form-container">  
            
            
            <% Lancamento lancamento = (Lancamento)  request.getAttribute("lancamento"); %>
            <form id="form" class="main-form" method="POST" action="LancamentoController">
                <h2 class="text-center mb-2">Cadastrar Lançamento</h2>

                <div id="btnCancel">
                    <img src="images/icons/close.png" alt="Cancelar" title="Cancelar" />
                </div> 
                
                <input type="hidden" value="<%= lancamento.getId() %>" name="id" />
                
                <% 
                    ContaDao contadao = new ContaDao();  
                    CategoriaDao categoriadao = new CategoriaDao();

                   ArrayList<Conta> conta_list = contadao.mostrar(usuario.getId()); 
                   ArrayList<Categoria> categoria_list = categoriadao.mostrar();

                %>
                
                <div class="row mb-1 mt-4">
                    <div class="form-group col">
                        <label for="account">Conta-Corrente:</label>
                        <select id="account" name="id_conta" class="form-control">
                            <option disabled selected value>- Selecione uma opção -</option> 
                            <%for(int i=0;i<conta_list.size();i++){  
                                Conta conta =  new Conta(); 
                                conta = conta_list.get(i);
                            %>
                            <option value="<%= conta.getId() %>" >Conta <%= conta.getNome_conta() %></option>
                           
                            <% } %>
                        </select>
                    </div>
                </div>
                <div class="row mb-1">
                    <div class="form-group col">
                        <label for="category">Categoria:</label> 
                        <select id="category" name="id_categoria" class="form-control">
                            <option disabled selected value>- Selecione uma opção -</option> 
                            
                            <% for(int i=0;i<categoria_list.size();i++){ 
                                Categoria categoria = new Categoria(); 
                                categoria = categoria_list.get(i);
                            %>
                            
                            <option value="<%=categoria.getId() %>"><%= categoria.getDescricao() %></option>
                           
                            <% } %>
                           
                        </select>
                    </div>
                    <div class="form-group col">
                        <label for="operation">Operação:</label>
                        <select id="operation" name="operacao" class="form-control">
                            <option disabled selected value>- Selecione uma opção -</option>
                            <option value="C">Crédito</option>
                            <option value="D">Débito</option>
                        </select>
                    </div>
                </div>
                <div class="row mb-1">
                    <div class="form-group col">
                        <label for="value">Valor:</label>
                        <input type="text" class="form-control" name="valor" value="<%= lancamento.getValor() %>" id="value" />
                    </div>
                    <div class="form-group col">
                        <label for="date">Data:</label>
                        <input type="date" class="form-control" name="data" id="date" value="<%= lancamento.getData() %>" />
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="form-group col">
                        <div class="form-group">
                            <label for="name">Descrição:</label>
                            <textarea class="form-control" name="descricao" id="description" rows="3" maxlength="100" value="<%= lancamento.getDescricao() %>"></textarea>
                        </div>
                    </div>
                </div>
                <button id="btnSubmit" type="submit" class="btn btn-success">Cadastrar</button>
            </form>
        </div>

        <script src="js/jquery-3.6.0.min.js"></script>
        <script src="js/jquery.mask.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.validate.min.js"></script>
        <script src="js/localization/messages_pt_BR.js"></script>

        <script>
            $(document).ready(function () {
                $('#form').validate({
                    errorPlacement: function (label, element) {
                        label.addClass('error-msg text-danger');
                        label.insertAfter(element);
                    },
                    wrapper: 'span',
                    rules: {
                        account: {
                            required: true,
                        },
                        category: {
                            required: true,
                        },
                        operation: {
                            required: true,
                        },
                        value: {
                            required: true,
                        },
                        date: {
                            required: true,
                        },
                        description: {
                            required: true,
                            maxlength: 100,
                        },
                    },
                  
                });

                $('#value').mask('0.000.000.000,00', {reverse: true});
                $('#btnCancel').click(() => (document.location.href = 'externo')); */
            });
        </script>
    </body>
</html>
