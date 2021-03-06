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
        <%@include file="sidebar.jsp" %>
        <div class="dashboard">
            <div class="dashboard-container">
                <h1>Bem vindo:<%= adm.getNome() %>!<br /> Acesso administrativo</h1>

                <div class="buttons-container">
                    <div class="row">
                        <div class="col-4">
                            <button class="dashboard-button" id="newAdm">Cadastrar Admins</button>
                        </div>
                        <div class="col-4">
                            <button class="dashboard-button" id="newUser" >Cadastrar Usu?rios</button>
                        </div>
                        <div class="col-4">
                            <button class="dashboard-button" id="newCategory">Cadastrar Categorias</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4">
                            <button class="dashboard-button" id="showAdmin">Listar Admins</button>
                        </div>
                        <div class="col-4">
                            <button class="dashboard-button" id="showUser" >Listar Usu?rios</button>
                        </div>
                        <div class="col-4">
                            <button class="dashboard-button" id="showCategoria">Listar Categorias</button>
                        </div>
                    </div>
                </div>
                <a href="/InterClone">Voltar para a p?gina Iniciall</a>
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
                $('#newAdm').click(() => (document.location.href = 'AdministradorController?acao=inserir'));
                $('#newUser').click(() => (document.location.href = 'UsuarioController?acao=inserir'));
                $('#newCategory').click(() => (document.location.href = 'CategoriaController?acao=inserir')); 
                $('#showAdmin').click(()=>(document.location.href='interno/mostrarAdmin.jsp')); 
                $('#showUser').click(()=>(document.location.href='interno/mostrarUsuarios.jsp')); 
                $('#showCategoria').click(()=>(document.location.href='interno/mostrarCategoria.jsp'));
            }); 
        </script>
    </body>
</html>
