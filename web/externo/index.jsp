<%@page import="aplicacao.Usuario"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <base href="/InterClone/" target="_blank" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/bootstrap.min.css" />

        <title>Dashboard</title>
    </head>
    <body> 
        <% Object logado = session.getAttribute("logado");
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            String nome = "";
            if (logado != null) {
                nome = usuario.getNome();
            }

        %>
        <div class="dashboard">
            <div class="dashboard-container">
              <h1>Bem-vindo: <span class="h2"><%= nome%></span>!</h1> 

                <div class="buttons-container">
                    <div class="row">
                        <div class="col-6">
                            <button class="dashboard-button" id="newAccount">Cadastrar Conta Corrente</button>
                        </div>
                        <div class="col-6">
                            <button class="dashboard-button" id="newBankPosting">Cadastrar Lançamento</button>
                        </div> 
                    </div>



                    <div class="row">
                        <div class="col-6">
                            <button class="dashboard-button" id="showAccount">Mostrar Contas</button>
                        </div> 
                        
                        <div class="col-6">
                            <button class="dashboard-button" id="showAccount">Mostrar Lançamentos</button>
                        </div>

                    </div> 

                </div> 
            </div>
            <a href="/InterClone">Voltar para a página Inicial</a>
        </div>
    </div>

    <div
        class="modal fade"
        id="exampleModalCenter"
        tabindex="-1"
        role="dialog"
        aria-labelledby="exampleModalCenterTitle"
        aria-hidden="true"
        >
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-body" id="content"></div>
            </div>
        </div>
    </div>

    <script src="js/jquery-3.6.0.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <script>
        $(document).ready(function () {
            $('#newAccount').click(() => (document.location.href = 'ContaController?acao=inserir'));
            $('#newBankPosting').click(() => (document.location.href = 'LancamentoController?acao=inserir'));
            $('#showAccount').click(() => (document.location.href = 'externo/mostrarContas.jsp'));
        });
    </script>
</body>
</html>
