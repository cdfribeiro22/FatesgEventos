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

        <style>
            #map {
                width: 50%;
                height: 250px;
                background-color: grey;
            }
        </style>
    </head><!--/head-->

    <body onload="getLocation()">

        <%@include file="admin_cabecalho.jsp" %>

        <section id="title" class="emerald">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <h1><strong>Cadastrar Novo Evento</strong></h1>
                    </div>
                </div>
            </div>
        </section><!--/#title--> 


        <div class="form-group">
            <div class="col-md-7">
                <form  name="form1" action='EventosController'   method="post" >

                    <!-- DADOS PESSOAIS-->

                    <legend> </legend>
                    <table cellspacing="10" class="table">
                        <!--     <tr>
                                 <td>
                                     <label for="fcodigoevento">Código do Evento </label>
                                 </td>
                                 <td align="left">
                                     <input type="text" readonly="true" name="fcodigoevento" value="0" />
                                 </td>
                             </tr> 
                        -->
                        <tr>
                            <td>
                                <label for="Cregiao" >Descrição do Evento </label>
                            </td>
                            <td align="left">
                                <input class="form-control" required type="text"  name="fdescevento" maxlength="55" size="70" value="<c:out value="${evento.getDescevento()}" />" /> 
                            </td>

                        </tr>
                        <tr>
                            <td>
                                <label for="fcodigo">Local do Evento </label>
                            </td>
                            <td align="left">
                                <input class="form-control" required type="text"  maxlength="60" size="70" name="flocalevento" value="<c:out value="${evento.getLocalevento()}" />" />  
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="Ccategoria2">Sala/Auditorio</label>
                            </td>
                            <td align="left">
                                <select name="fsala" required class="form-control"> 
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
                                <input class="form-control" required type="number" step = "any" name="flatitude" maxlength="10" size="10" id="fcoodx" value="<c:out value="${evento.getLatitude()}" />" /> 
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <label for="Cpencontro">Coordenadas Long. </label>
                            </td>
                            <td align="left">
                                <input class="form-control" required type="number" step = "any" maxlength="10" size="10" name="flongitude" id="fcoody"  value="<c:out value="${evento.getLongitude()}" />" /> 
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
                                <input class="form-control" required type="date"  name="fdataevento" value="<c:out value="${evento.getDataevento()}" />" />  
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="Ccategoria2">Horario</label>
                            </td>
                            <td align="left">
                                <select name="fhoraevento" required class="form-control"> 
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

                        <tr>
                            <td>

                            </td>
                            <td>
                                <p></p>
                                <input type="submit" value="Cadastrar Evento" class="btn btn-default btn-large active">
                            </td>
                        </tr>
                    </table>
                    <br/>






                </form>
            </div>
            <div class="col-md-5">           

                <br/>    
                <h3>Localização no mapa</h3>
                <div id="map" ></div>  


            </div>
        </div>





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

        <script>
            // Note: This example requires that you consent to location sharing when
            // prompted by your browser. If you see the error "The Geolocation service
            // failed.", it means you probably did not give permission for the browser to
            // locate you.

            function initMap() {
                var map = new google.maps.Map(document.getElementById('map'), {
                    center: {lat: -34.397, lng: 150.644},
                    zoom: 15
                });
                var infoWindow = new google.maps.InfoWindow({map: map});

                // Try HTML5 geolocation.
                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(function (position) {
                        var pos = {
                            lat: position.coords.latitude,
                            lng: position.coords.longitude
                        };

                        infoWindow.setPosition(pos);
                        infoWindow.setContent('Location found.');
                        map.setCenter(pos);
                    }, function () {
                        handleLocationError(true, infoWindow, map.getCenter());
                    });
                } else {
                    // Browser doesn't support Geolocation
                    handleLocationError(false, infoWindow, map.getCenter());
                }
            }

            function handleLocationError(browserHasGeolocation, infoWindow, pos) {
                infoWindow.setPosition(pos);
                infoWindow.setContent(browserHasGeolocation ?
                        'Error: The Geolocation service failed.' :
                        'Error: Your browser doesn\'t support geolocation.');
            }
        </script>


        <!--
                 <script>
              function initMap() {
                var uluru = {lat: -16.718, lng: -49.267};
                var map = new google.maps.Map(document.getElementById('map'), {zoom: 15,center: uluru});
                var marker = new google.maps.Marker({
                  position: uluru,
                  map: map
                });
              }
            </script>
        -->    
        <script async defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBxkumZvr9d2FFH73PER2-73vaQlX44a0Q&callback=initMap">
        </script>
    </body>

</html>

