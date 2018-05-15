<%-- 
    Document   : login1
    Created on : 17/05/2017, 18:45:48
    Author     : Carlos Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Login | E-ventos *</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    </head><!--/head-->

    <body>
        <%@include file="cabecalho.jsp" %>
        <section id="title" class="emerald">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <h1>Faça seu Login</h1>
                    </div>
                </div>
            </div>
        </section><!--/#title--> 
        <div id="login-box">
            <div id="login-box-interno">
                <div id="login-box-label">
                    LOGIN
                </div>
                <form method="post" action="ELoginServlet1">
                    <div class="input-div" id="input-usuario">
                        Usuário<input type="text" name="login" required />
                    </div>
                    <div class="input-div" id="input-senha">
                        Senha<input type="password" name="senha" required/>
                        <input type="submit" value="Entrar" />
                        <input type="hidden" name="acao" value="login" />
                    </div>
                </form> 
                <div id="botoes">
                    <div id="lembra-senha">
                        <input type="checkbox"/> Lembrar minha Senha</div>
                </div> 
                <div id="esqueceu-senha">
                    <a href="recuperarsenha.jsp"><b>Esqueceu a senha?</b></a>
                </div>
            </div>
        </div>
        <%@include file="rodape.jsp" %>
    </body>
</html>

