<%-- 
    Document   : cabecalho
    Created on : 04/05/2017, 19:29:08
    Author     : Carlos Daniel
--%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <link href="css/diversos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header class="navbar navbar-inverse navbar-fixed-top wet-asphalt" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="./">Inicio</a></li>                        
                            <%  String Str = new String("admin");
                                if (session.getAttribute("login") != null) {
                                    String logado = "admin";
                                    if (session.getAttribute("login") != null && (logado.equals(session.getAttribute("login")))) {
                            %>                           
                        <li><a href="ad_eventolistarconsulta.jsp">*Eventos</a></li>
                        <li><a href="https://10.21.5.232:8181/FatesgEventos/RegistroController?action=registrarparticipante&QREvento=S101_05012018_H7">*Participantes</a></li>
                            <%
                                }
                            %>

                        <li><a class="btn-default"  ><% out.print(session.getAttribute("login").toString().substring(0, 5)); %> </a></li>
                        <li><a class="btn btn-danger" href="ELoginServlet1?acao=logout">Logout</a></li>
                        
                        <li><a class="btn-social"  ></a></li>
                        <li><a class="btn-social"  ></a></li>
                            <%
                            } else {
                            %>
                        
                            <%
                                }
                            %>                    
                            <li><a href="login.jsp">Login</a></li>
                    </ul>
                </div>
            </div>
        </header><!--/header-->
    </body>
</html>
