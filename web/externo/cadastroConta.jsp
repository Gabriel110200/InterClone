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
        
        <%Conta conta = (Conta) request.getAttribute("conta"); %>
        
        <div class="form-container">
            <form id="form" class="main-form" method="POST" action="ContaController">
                <h2 class="text-center mb-2">Cadastrar Conta</h2>

                <div id="btnCancel">
                    <img src="images/icons/close.png" alt="Cancelar" title="Cancelar" />
                </div>
                
                <input type="hidden" value="<%= conta.getId() %>" name="id" /> 
                <input type="hidden" value="<%= conta.getId_usuario()%>" name="id_usuario" />
                
                <div class="row mb-3 mt-4">
                    <div class="col">
                        <div class="form-group">
                            <label for="name">Nome:</label>
                            <input
                                type="text"
                                class="form-control"
                                name="nome_conta"
                                id="nome_conta"
                                placeholder="Digite um apelido para a conta corrente"
                                maxlength="20"               
                                value="<%=conta.getNome_conta() %>"
                                />
                        </div>
                    </div>
                </div>
                <div class="row mb-4">
                    <div class="col">
                        <div class="form-group">
                            <label for="password">Banco:</label>
                            <input type="text" class="form-control" name="banco" id="banco" value="<%=conta.getBanco() %>" />
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="confirmPassword">Agência:</label>
                            <input type="text" class="form-control" name="agencia" id="agencia" value="<%=conta.getAgencia() %>" />
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="confirmPassword">Conta-corrente:</label>
                            <input type="text" class="form-control" name="conta_corrente" id="conta_corrente" value="<%=conta.getConta_corrente()%>" />
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
                        name: {
                            required: true,
                            maxlength: 20,
                        },
                        bank: {
                            required: true,
                            maxlength: 3,
                        },
                        agency: {
                            required: true,
                            maxlength: 6,
                        },
                        account: {
                            required: true,
                            maxlength: 6,
                        },
                    },
                   
                });

                $('#bank').mask('000');
                $('#agency').mask('000000');
                $('#account').mask('000000');
                $('#btnCancel').click(() => (document.location.href = 'externo'));
            }); */
        </script>
    </body>
</html>

