<%-- 
    Document   : cabecalho
    Created on : 04/05/2017, 19:29:08
    Author     : Carlos Daniel
--%>

<%@page import="com.evento.model.CPessoa"%>
<%@page import="com.evento.dao.ParticipanteDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
                        <li><a href="ad_eventolistarconsulta.jsp">Consultar Eventos</a></li>
                        <!--                            <li><a href="">Parceiros</a></li>-->
                        <%
                            // verificando se tem um atributo login na sessao
                            // se tiver vai continuar e mostrar o menu
                            if (session.getAttribute("login") != null) {
                                ParticipanteDao dao = new ParticipanteDao();
                                //GuiaDao daoguia = new GuiaDao();
                                CPessoa user = new CPessoa();
                                user = dao.getPessoaByEmail(session.getAttribute("login").toString());

                                //if (daoguia.ConsultarGuiaExistente(user)) {
                        %>
                        <li> <a href="cadastroGuia_ativo.jsp"></a></li>
                            <%                                //} else {
                            %>

                        <li>   <a href="cadastroGuia_1.jsp"></a></li>

                        <%                            // }
                        %>


                        <li>  <% out.print(session.getAttribute("login").toString()); %></a></li>
                        <li>   <a href="#"></a></li>

                        <li><a class="btn btn-danger" href="LoginServlet1?acao=logout">Logout</a></li>
                            <%
                                // se não existir um login na sessao, 
                                // vai enviar para a página de login novamente
                                String logado = "admin@eventos.com";
                                if (session.getAttribute("login") != null && (logado.equals(session.getAttribute("login")))) {
                            %>
                        <li><a href="admin_index.jsp">Gerenciar Site</a></li>

                        <%
                            }
                        %>                            
                        <%
                            // se não existir um login na sessao, 
                            // vai enviar para a página de login novamente
                        } else {
                        %>
                        <li><a href="login.jsp">Login</a></li>
                            <%
                                }
                            %>                    

                    </ul>
                </div>



            </div>
        </header><!--/header-->

    </body>


</html>
