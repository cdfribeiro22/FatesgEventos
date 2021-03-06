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

        <input class="btn btn-warning" type="button" onclick="location.href = 'EventosController?action=listEventosConsulta';" value="LISTAR" />
        
        <input class="btn btn-warning"  type="button" onclick="location.href = 'ad_eventocadastrar.jsp';" value="CADASTRAR NOVO EVENTO" />
     
        
        <p></p>



        <!-- DADOS PESSOAIS-->

    <legend>Dados Eventos</legend>
    <table  class="table table-striped table-bordered table-condensed table-hover">
        <thead>
            <tr align="center">
                <th>Código </th>
                <th>Descrição</th>
                <th>Local</th>
                <th>Sala/Auditorio</th>
                <th>Data</th>
                <th>Hora</th>
                <th>Qrcode</th>
                <th>Participantes Registrados</th>
                <th><FONT COLOR="FF0000">Lista Participantes</th>
                <th><FONT COLOR="0000FF">Imprimir QRCODE</th>

                
            </tr>    
        </thead>        
        <tbody>
            <c:forEach items="${eventos}" var="evento">
                <tr align="center">
                    <td><c:out value="${evento.getCodigoevento()}" /></td>
                    <td><c:out value="${evento.getDescevento()}" /></td>
                    <td><c:out value="${evento.getLocalevento()}" /></td>
                    <td><c:out value="${evento.getSala()}" /></td>
                    <td><c:out value="${evento.getDataevento()}" /></td>
                    <td><c:out value="${evento.getHoraevento()}:00" /></td>
                    <td><c:out value="${evento.getQrcode()}" /></td>
                    <td><c:out value="${evento.getQntparticipantes()}" /></td>
                    <td><a href="RegistroController?action=listParticipantes&CodigoEvento=<c:out value="${evento.getQrcode()}"/>"><FONT COLOR="FF0000"><b>Listar</b></a></td>
                    <td><a href="EventosController?action=imprime&CodigoEvento=<c:out value="${evento.getQrcode()}"/>"><FONT COLOR="0000FF"><b>Imprimir</b></a></td>
                    

                </tr>
            </c:forEach>   
        </tbody>   

    </table>

    <br />
    

</body>
</html>