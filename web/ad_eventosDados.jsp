<%-- 
    Document   : cadastrar1
    Created on : 17/05/2017, 18:44:57
    Author     : Gylles
--%>

<%@page import="com.evento.model.CPessoaFisica"%>
<%@page import="com.evento.model.CUsuarioSistema"%>

<%@page import="javax.swing.JOptionPane"%>

<%@page import="com.evento.dao.UsuarioDao"%>
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
        <title>Registro</title>
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

     <body >



        <section id="title" class="emerald">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <h1>Registrar Presença</h1>
                    </div>
                </div>
            </div>
        </section><!--/#title--> 

        <form method="post" action="CadastroController" name="form1"  >

            <!-- DADOS PESSOAIS-->
            <fieldset>
                <legend>Dados Pessoais</legend>
                <table cellspacing="10" class="text-center">
                    <tr>
                        <td>
                            <label for="Cnome">Código Cliente: </label>
                        </td>
                        <td align="left">
                        <td> <input type="text" readonly="readonly"  name="fcodigo" value="<c:out value="${cliente.getCodigoCliente()}" />" /> </td> 
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <label for="Cnome">Nome Completo: </label>
                        </td>
                        <td align="left">
                        <td> <input type="text" readonly="readonly"   name="fnome" value="<c:out value="${cliente.getNome()}" />" /> </td> 
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <label for="Csexo">Sexo:</label>
                        </td>
                        <td align="left">
                        <td> <input type="text"  readonly="readonly"   name="fsexo" value="<c:out value="${cliente.getSexo()}" />" /> </td> 
                        </td>

                    </tr>

                    <tr>
                        <td>
                            <label>Nascimento: </label>
                        </td>
                        <td align="left">
                        <td> <input type="date" readonly="readonly"   name="Fnascimento" value="<c:out value="${cliente.getDt_nasc()}" />" /> </td> 
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label for="rg">RG: </label>
                        </td>
                        <td align="left">
                        <td> <input type="text"  readonly="readonly" name="Frg" value="<c:out value="${cliente.getDocumento()}" />" /> </td> 
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label>CPF:</label>
                        </td>
                        <td align="left">
                        <td> <input type="text"  readonly="readonly" name="Fcpf" value="<c:out value="${cliente.getCpf()}" />" /> </td> 
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label>Telefone:</label>
                        </td>
                        <td align="left">
                        <td> <input type="text" readonly="readonly" name="codigo" value="<c:out value="${cliente.getTelefoneFixo()}" />" /> </td> 
                        </td>
                    </tr>
                </table>
            </fieldset>
            <br />



            <a href="*.jsp"></a>
            <br />





        </form>




        <!--
                <p><button onclick="geoFindMe()">Show my location</button></p>
                <div id="out1"></div>
        
                <script>
                    function geoFindMe() {
                        var output = document.getElementById("out1");
        
                        if (!navigator.geolocation) {
                            output.innerHTML = "<p>Geolocation is not supported by your browser</p>";
                            return;
                        }
        
                        function success(position) {
                            var latitude = position.coords.latitude;
                            var longitude = position.coords.longitude;
        
                            output.innerHTML = '<p>Latitude is ' + latitude + '° <br>Longitude is ' + longitude + '°</p>';
        
                            var img = new Image();
                            img.src = "https://maps.googleapis.com/maps/api/staticmap?center=" + latitude + "," + longitude + "&zoom=13&size=300x300&sensor=false";
        
                            output.appendChild(img);
                        }
        
                        function error() {
                            output.innerHTML = "Unable to retrieve your location";
                        }
        
                        output.innerHTML = "<p>Locating…</p>";
        
                        navigator.geolocation.getCurrentPosition(success, error);
                    }
                </script>
        
        -->
       
        <p>--------------------------------------------------------------------</p>
  <!--      
        

    <p id="demo6">Clique no botão para receber sua localização em Latitude e Longitude:</p>
        <button onclick="getLocation1()">Clique Aqui</button>
    <script>
    var x=document.getElementById("demo6");
    function getLocation1()
      {
      if (navigator.geolocation)
        {
        navigator.geolocation.getCurrentPosition(showPosition);
        }
      else{x.innerHTML="O seu navegador não suporta Geolocalização.";}
      }
    function showPosition(position)
      {
      x.innerHTML="Latitude: " + position.coords.latitude +
      "<br>Longitude: " + position.coords.longitude; 
      }
    </script>
-->



<p id="demo">Clique no botão para receber as coordenadas:</p>
<button onclick="getLocation()">Clique Aqui</button>
<script>
var x=document.getElementById("demo");
function getLocation()
  {
  if (navigator.geolocation)
    {
    navigator.geolocation.getCurrentPosition(showPosition,showError);
    }
  else{x.innerHTML="Seu browser não suporta Geolocalização.";}
  }
function showPosition(position)
  {
  x.innerHTML="Latitude: " + position.coords.latitude +
  "<br>Longitude: " + position.coords.longitude; 
  }
function showError(error)
  {
  switch(error.code)
    {
    case error.PERMISSION_DENIED:
      x.innerHTML="Usuário rejeitou a solicitação de Geolocalização.";
      break;
    case error.POSITION_UNAVAILABLE:
      x.innerHTML="Localização indisponível.";
      break;
    case error.TIMEOUT:
      x.innerHTML="A requisição expirou.";
      break;
    case error.UNKNOWN_ERROR:
      x.innerHTML="Algum erro desconhecido aconteceu.";
      break;
    }
  }
</script>



        </body>
    </html>

