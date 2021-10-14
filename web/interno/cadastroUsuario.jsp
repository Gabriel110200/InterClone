<%@page import="aplicacao.Usuario"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <base href="/InterClone/" target="_blank" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/bootstrap.min.css" />

        <title>Cadastro</title>
    </head> 
             <% Usuario usuario = ( Usuario ) request.getAttribute("usuario"); %>
    <body>
        <div class="form-container">
            <form id="form" class="main-form" method="POST" action="UsuarioController">
                <h2 class="text-center mb-2">Cadastrar Usuárioooooo</h2>

                <div id="btnCancel">
                    <img src="images/icons/close.png" alt="Cancelar" title="Cancelar" />
                </div> 
                
                <input type="hidden" name="id" value="<%= usuario.getId() %>" />

                <div class="row mb-3 mt-4">
                    <div class="col-5">
                        <div class="form-group">
                            <label for="cpf">CPF:</label>
                            <input type="text" class="cpf form-control" name="cpf" value="<%= usuario.getCpf() %>"  id="cpf" placeholder="000.000.000-00" />
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="name">Nome:</label>
                            <input type="text" class="form-control" name="name" value="<%= usuario.getNome() %>" id="name" maxlength="20" />
                        </div>
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col">
                        <div class="form-group">
                            <label for="password">Senha:</label>
                            <input type="password" class="form-control" name="password" value="<%= usuario.getSenha() %>" id="password" />
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="confirmPassword">Confirmar senha:</label>
                            <input type="password" class="form-control" name="confirmPassword" id="confirmPassword" />
                        </div>
                    </div>
                </div>
                <div class="row mb-4">
                    <div class="col">
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="suspended" name="suspended" />
                            <label class="form-check-label" for="suspended">Suspender</label>
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
        <script src="js/additional-methods.min.js"></script>
        <script src="js/localization/messages_pt_BR.js"></script>

        <script> 
            /*
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
                        cpf: {
                            required: true,
                            cpfBR: true,
                        },
                        password: {
                            required: true,
                            minlength: 3,
                        },
                        confirmPassword: {
                            required: true,
                            equalTo: '#password',
                        },
                    },
                    submitHandler: function (form) {
                        alert('Cadastro do ' + $(form).find('input[name="name"]').val() + ' realizado');
                    },
                });

                $('.cpf').mask('000.000.000-00', {reverse: true});
                $('#btnCancel').click(() => (document.location.href = 'interno'));
            }); */
        </script>
    </body>
</html>

