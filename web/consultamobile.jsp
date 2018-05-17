<%-- 
    Document   : cadastrar1
    Created on : 17/05/2017, 18:44:57
    Author     : Gylles
--%>

<%@page import="com.evento.model.CEventos"%>
<%@page import="com.evento.model.CUsuarioSistema"%>

<%@page import="javax.swing.JOptionPane"%>

<%@page import="com.evento.dao.EventoDao"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

        <script src="js/scriptCadastro.js" type="text/javascript"></script>
        <title>Conslutas E-ventos</title>
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

        <%@include file="admin_cabecalho.jsp" %>

        <section id="title" class="emerald">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <h1><strong>Consultar Eventos</strong></h1>
                    </div>
                </div>
            </div>
        </section><!--/#title--> 
        <p></p>
        <input class="btn btn-warning" type="button" onclick="location.href = 'EventosController?action=listEventosConsultaMobile';" value="ATUALIZAR" />
        <!--       <input class="btn btn-warning"  type="button" onclick="location.href = 'ad_eventocadastrar.jsp';" value="CADASTRAR NOVO EVENTO" />
        -->    
        <p></p>
        <!-- DADOS PESSOAIS-->
    <legend>Dados Eventos</legend>
    <tbody>
        <c:forEach items="${eventos}" var="evento">
        <div class="row">
            <div class="col-sm-9">
                <div class="panel panel-success">
                    <h4>Evento: <c:out value="${evento.getDescevento()}" /></h4>
                </div>
                <div class="row">
                    <div class="col-xs-8 col-sm-6">
                        <div class="alert alert-success">
                            Qnt. Participantes: <c:out value="${evento.getQntparticipantes()}" />
                        </div>
                    </div>
                    <div class="col-xs-4 col-sm-6">
                        <div class="alert alert-success">
                            <a href="RegistroController?action=listParticipantesMobile&CodigoEvento=<c:out value="${evento.getQrcode()}"/>"><b>Listar</b></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>   
    <br />
</body>
</html>