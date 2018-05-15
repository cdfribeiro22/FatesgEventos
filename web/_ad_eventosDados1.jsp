<%-- 
    Document   : cadastrar1
    Created on : 17/05/2017, 18:44:57
    Author     : Gylles
--%>

<%@page import="com.evento.model.CEventos"%>
<%@page import="com.evento.model.CPessoaFisica"%>
<%@page import="com.evento.model.CUsuarioSistema"%>


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

    <body onload="getLocation()">



        <section id="title" class="emerald">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <h1>Registrar Presença no evento</h1>
                    </div>
                </div>
            </div>
        </section><!--/#title--> 

        <form method="post" action="EventosController" name="form1"  >

            <!-- DADOS PESSOAIS-->
            <fieldset>
                <legend>Dados Pessoais</legend>
                <table cellspacing="10" class="text-center">
                    <tr>
                        <td>
                            <label for="QrcodeEvento">Código do Evento</label>
                        </td>
                        <td align="left"> <input type="text"  readonly="readonly" name="FQrcodeEvento"  value="<c:out value="${evento.getQrcode()}" />" /> </td> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="NomeEvento">Nome Evento</label>
                        </td>
                        <td align="left"> <input type="text"  readonly="readonly" name="FNomeEvento" value="<c:out value="${evento.getDescevento()}" />" /> </td> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="LocalEvento">Local Evento</label>
                        </td>
                        <td align="left"> <input type="text"  readonly="readonly" name="FLocalEvento" value="<c:out value="${evento.getLocalevento()}" />" /> </td> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="DataEvento">Data Evento </label>
                        </td>
                        <td align="left"> <input type="date" readonly="readonly"   name="FDataEvento" value="<c:out value="${evento.getDataevento()}" />" /> </td> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="HoraEvento">Hora Evento </label>
                        </td>
                        <td align="left"> <input type="text" readonly="readonly" size="2"  name="FHoraEvento" value="<c:out value="${evento.getHoraevento()}:00" />" </td> 
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label > </label>
                        </td>
                        <td align="left"> <h6 > _____________________________ </h6>   </td> 
                        </td>
                    </tr>



                    <tr>
                        <td>
                            <label for="Cpencontro"  style="display:none">Coordenadas Lat. </label>
                        </td>
                        <td align="left">
                            <input type="text"  name="flatitude" maxlength="10" size="20" id="fcoodx"  style="display:none" value="<c:out value="${evento.getLatitude()}" />" /> 
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label for="Cpencontro" style="display:none">Coordenadas Long. </label>
                        </td>
                        <td align="left">
                            <input type="text"   name="flongitude" maxlength="10" size="20" id="fcoody"  style="display:none" value="<c:out value="${evento.getLongitude()}" />" /> 
                        </td>
                        <td align="left">
                            <p id="geoerro">-</p>
                        </td>
                    </tr>




                    <tr>
                        <td>
                            <label for="Cnome">Nome Completo: </label>
                        </td>
                        <td align="left"> <input type="text" size="70" name="fCnome" /> </td> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="CCpf">CPF:</label>
                        </td>
                        <td align="left"> 
                            <input id="cpf" type="text" name="Fcpf" onBlur="ValidarCPF(form1.Fcpf);" onKeyPress="MascaraCPF(form1.Fcpf);"  maxlength="14" required>
                        </td> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="CFone">Telefone Celular:</label>
                        </td>
                        <td align="left">
                            <input type="text" name="Ftelefone2" onKeyPress="MascaraTelefoneMovel(form1.Ftelefone2);" maxlength="15" >
                        </td>
                    </tr>
                </table>        
            </fieldset>
            </br>

            <input type="submit" value="Confirmar">    

        </form>

        </br>
        </br>
        </br>
        </br>
        
        <table>     
            <tr>
                <td>
                </td>
                <td align="left">
                    <input type="text"  name="flatitude2" maxlength="10" size="20" id="fcoodx1" value="<c:out value="${evento.getLatitude()}" />" /> 
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td align="left">
                    <input type="text"   name="flongitude2" maxlength="10" size="20" id="fcoody1"  value="<c:out value="${evento.getLongitude()}" />" /> 
                </td>
                <td align="left">
                    <p id="geoerro">-</p>
                </td>
            </tr>
        </table>   
                
                
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
                document.getElementById("fcoodx1").value = position.coords.latitude + "";
                document.getElementById("fcoody1").value = position.coords.longitude + "";
                document.getElementById("fcoodx").value = position.coords.latitude + "";
                document.getElementById("fcoody").value = position.coords.longitude + "";

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

