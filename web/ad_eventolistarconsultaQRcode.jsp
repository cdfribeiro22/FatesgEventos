<%-- 
    Document   : QRCODE
    Created on : 17/05/2017, 18:44:57
    Author     : Carlos Daniel
--%>

<%@page import="com.evento.model.CEventos"%>
<%@page import="com.evento.model.CUsuarioSistema"%>

<%@page import="javax.swing.JOptionPane"%>

<%@page import="com.evento.dao.ParticipanteDao"%>

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
        <title>Imprime QRcode</title>
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
        <br><input type="button" name="print" value="Imprimir" onClick="javascript:window.print();">
        <style media="print">
            .botao {
                display: none;
            }
        </style>            
        <input type="button" onclick="location.href = 'ad_eventolistarconsulta.jsp';" value="Voltar" />
        <br/>
        <br/>

        <div align="center">
            <img src="images/fatesg.png" width="400" height="400" />
        </div>    

        <br/>
        <br/>
        <br/>
        <br/>
        <div align="center">
            <script>
                String link;
            </script>
           
            <img src="<c:out value="${link}" />"  />

           

        </div>                

        <br/>
        <br/>
        <br/>
        <br/>
        <br/>

        

    </body>
</html>

