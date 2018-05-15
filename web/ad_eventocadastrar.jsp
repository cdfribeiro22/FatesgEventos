<%-- 
    Document   : cadastrar1
    Created on : 17/05/2017, 18:44:57
    Author     : Carlos Daniel
--%>

<%@page import="com.evento.model.CEventos"%>
<%@page import="com.evento.model.CUsuarioSistema"%>

<%@page import="com.evento.dao.EventoDao"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

        <script src="js/scriptCadastro.js" type="text/javascript"></script>
        <title>Registro | Eventos</title>
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

    <body onload="getLocation()">

        <%@include file="admin_cabecalho.jsp" %>

        <section id="title" class="emerald">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <h1>Cadastrar Novo Evento</h1>
                    </div>
                </div>
            </div>
        </section><!--/#title--> 

        <form  name="form1" action='EventosController'   method="post" >



            <!-- DADOS PESSOAIS-->
            <fieldset>
                <legend>Evento: </legend>
                <table cellspacing="10" class="text-center">
                    <tr>
                        <td>
                            <label for="fcodigoevento">Código do Evento </label>
                        </td>
                        <td align="left">
                            <input type="text" readonly="true" name="fcodigoevento" value="0" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="Cregiao">Descrição do Evento </label>
                        </td>
                        <td align="left">
                            <input required type="text"  name="fdescevento" maxlength="55" size="70" value="<c:out value="${evento.getDescevento()}" />" /> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="fcodigo">Local do Evento </label>
                        </td>
                        <td align="left">
                            <input required type="text"  maxlength="60" size="70" name="flocalevento" value="<c:out value="${evento.getLocalevento()}" />" />  
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="Ccategoria2">Sala/Auditorio</label>
                        </td>
                        <td align="left">
                            <select name="fsala" required> 
                                <option value="">...</option> 
                                <option value="Sala_S101">Sala 101</option>
                                <option value="Sala_S102">Sala 102</option> 
                                <option value="Sala_S103">Sala 103</option> 
                                <option value="Sala_S104">Sala 104</option>
                                <option value="Sala_S105">Sala 105</option> 
                                <option value="Auditorio_AU01">Auditorio 01</option> 
                                <option value="Anfiteatro_AN01">Anfiteatro 01</option> 
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="Cpencontro">Coordenadas Lat. </label>
                        </td>
                        <td align="left">
                            <input required type="number" step = "any" name="flatitude" maxlength="10" size="10" id="fcoodx" value="<c:out value="${evento.getLatitude()}" />" /> 
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label for="Cpencontro">Coordenadas Long. </label>
                        </td>
                        <td align="left">
                            <input  required type="number" step = "any" maxlength="10" size="10" name="flongitude" id="fcoody"  value="<c:out value="${evento.getLongitude()}" />" /> 
                        </td>
                        <td align="left">
                            <p id="geoerro">-</p>
                        </td>

                    </tr>

                    <tr>
                        <td>
                            <label>Data do Evento </label>
                        </td>
                        <td align="left">
                            <input required type="date"  name="fdataevento" value="<c:out value="${evento.getDataevento()}" />" />  
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="Ccategoria2">Horario</label>
                        </td>
                        <td align="left">
                            <select name="fhoraevento" required> 
                                <option value="">...</option> 
                                <option value="7">07:00</option>
                                <option value="8">08:00</option> 
                                <option value="9">09:00</option> 
                                <option value="10">10:00</option>
                                <option value="11">11:00</option> 
                                <option value="12">12:00</option> 
                                <option value="13">13:00</option>
                                <option value="14">14:00</option> 
                                <option value="15">15:00</option> 
                                <option value="16">16:00</option>
                                <option value="17">17:00</option> 
                                <option value="18">18:00</option> 
                                <option value="19">19:00</option>
                                <option value="20">20:00</option> 
                                <option value="21">21:00</option> 
                                <option value="22">22:00</option>
                            </select>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <br/>

            <!--          <input type="button" onclick="location.href = 'EventoController?action=disponibilidade';" value="Reservar" />  -->
            <label name="teste"></label>
            <fieldset >
                <input type="submit" value="Alterar/Incluir">
            </fieldset>
        </form>



        <script>
            var z = document.getElementById("geoerro");
            function getLocation()
            {
                if (navigator.geolocation)
                {
                    navigator.geolocation.getCurrentPosition(showPosition, showError);
                } else {
                    z.innerHTML = "Seu browser não suporta Geolocalização.";
                }
            }
            function showPosition(position)
            {
                document.getElementById("fcoodx").value = position.coords.latitude;
                document.getElementById("fcoody").value = position.coords.longitude;

            }
            function showError(error)
            {
                switch (error.code)
                {
                    case error.PERMISSION_DENIED:
                        z.innerHTML = "Usuário rejeitou a solicitação de Geolocalização.";
                        break;
                    case error.POSITION_UNAVAILABLE:
                        z.innerHTML = "Localização indisponível.";
                        break;
                    case error.TIMEOUT:
                        z.innerHTML = "A requisição expirou.";
                        break;
                    case error.UNKNOWN_ERROR:
                        z.innerHTML = "Algum erro desconhecido aconteceu.";
                        break;
                }
            }
        </script>






    </body>
</html>

