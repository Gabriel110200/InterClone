
<%@page import="aplicacao.Administrador"%>
<%@page import="aplicacao.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>  
        <base href="/InterClone/" target="_self" />
       
        <link rel="stylesheet" href="css/bootstrap.min.css" /> 
        <style>
          
            
            .sidebar{
                position: fixed; 
                top:0; 
                left:0px; 
                background: rgb(255, 122, 0); 
                width:250px; 
                height: 100%; 
                transition: .3s;
            } 
            
            .active{
                left:-250px;
            }
            
            ul{
                margin: 0; 
                padding:20px 0; 
            } 
            
            ul li 
            {
                list-style: none;
            }  
            
            ul li a 
            {
                padding: 10px 20px; 
                color:#fff; 
                display: block; 
                text-decoration: none; 
                border-bottom: 1px solid rgba(0,0,0,.2);
            } 
            
            .sidebarBtn 
            {
                position: absolute; 
                top:0; 
                right: -50px;  
                width: 50px; 
                height: 50px; 
                box-sizing: border-box; 
                cursor: pointer; 
                background: #f5f5f5; 
                border: none; 
                outline: none; 
                
                
            } 
            
            .sidebarBtn span 
            {
                display: block; 
                width: 35px; 
                height: 3px; 
                background: #262626 ; 
                position: absolute; 
                top: 24px; 
                transition: .3s;
                    
            } 
            
            .sidebarBtn span:before 
            {
                
                content: ''; 
                position: absolute; 
                top: -10px; 
                left:0; 
                width:100%; 
                height:3px; 
                background:#262626; 
                transition: .3s;
                
            }  
            
            .sidebarBtn span:after 
            {
                
                content: ''; 
                position: absolute; 
                top: 10px; 
                left:0; 
                width:100%; 
                height:3px; 
                background:#262626; 
                transition: .3s;
                
            } 
            
            
            
           
          
            
        </style>
    </head>
    <body>
        <div class="sidebar">  
            
            <% Administrador adm  = (Administrador) session.getAttribute("adm"); %>
            
            <h1><span style="color: rgb(0, 150, 219)">Inter</span>clone</h1>
            
            <ul>
                <li><a href="interno/index.jsp" target="_self">Home </a></li> 
                <li><a href="UsuarioController?acao=inserir" target="_self">Cadastrar Usuários </a></li>  
                <li><a href="interno/mostrarUsuarios.jsp" target="_self">Mostrar Usuários </a></li>
                <li><a href="AdministradorController?acao=inserir" target="_self">Cadastrar Administrador</a></li>   
                <li><a href="interno/mostrarAdmin.jsp" target="_self">Mostrar Administrador</a></li>    
                <li><a href="CategoriaController?acao=inserir" target="_self">Cadastrar Categoria</a></li>   
                <li><a href="interno/mostrarCategoria.jsp" target="_self">Mostrar Categoria</a></li> 
                <li><a href="index.html" target="_self">Sair</a></li>
               
                
            </ul> 
            
            <button class="sidebarBtn">
                
                <span></span>
                
            </button>  
            
           
          
            
        </div>

        <script src="js/jquery-3.6.0.min.js"></script>
        <script src="js/jquery.mask.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.validate.min.js"></script>
        <script src="js/localization/messages_pt_BR.js"></script> 
        
        <script>
            
            $(document).ready(function(){ 
                $('.sidebarBtn').click(function(){
                    $('.sidebar').toggleClass('active');
                })
    })
            
        </script>
        
    </body>
</html>

