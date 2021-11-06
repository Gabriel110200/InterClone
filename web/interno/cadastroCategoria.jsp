<%@page import="aplicacao.Categoria"%>
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
        <% Categoria categoria = (Categoria) request.getAttribute("categoria");%>
        
        <div class="form-container">
            <form id="category-form" class="main-form" method="POST" action="CategoriaController">
                <h2 class="text-center mb-2">Cadastrar Categoria</h2>

                <div id="btnCancel">
                    <img src="images/icons/close.png" alt="Cancelar" title="Cancelar" />
                </div> 
                
                <input type="hidden" value="<%= categoria.getId() %>" name="id" />

                <div class="row mb-3 mt-4">
                    <div class="col">
                        <div class="form-group">
                            <label for="name">Descrição:</label>
                            <input type="text" class="form-control" name="descricao" value="<%=categoria.getDescricao() %>" id="description" maxlength="20" />
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
                $('#category-form').validate({
                    errorPlacement: function (label, element) {
                        label.addClass('error-msg text-danger');
                        label.insertAfter(element);
                    },
                    wrapper: 'span',
                    rules: {
                        description: {
                            required: true,
                            maxlength: 20,
                        },
                    },
                   
                });

                $('.cpf').mask('000.000.000-00', {reverse: true});
                $('#btnCancel').click(() => (document.location.href = 'interno'));
            }); 
        </script>
    </body>
</html>
