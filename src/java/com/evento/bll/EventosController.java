/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evento.bll;

import com.evento.dao.EventoDao;
import com.evento.model.CEventos;
import com.evento.util.CreateQR;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos Daniel
 */
@WebServlet("/EventosController")
public class EventosController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String URL_DEV = "/ad_eventocadastrar_valida.jsp";
    String mensagem = "";
    private EventoDao daoE;
    private CreateQR qr;

    public EventosController() {
        super();
        //dao = new PasseioDao();
        daoE = new EventoDao();
        qr = new CreateQR();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("imprime")) {                               //Imprime QRCode
            String CodigoEvento = request.getParameter("CodigoEvento");
            CreateQR imprimiQRcode = new CreateQR();
            imprimiQRcode.QRMobile();
            forward = "ad_eventolistarconsultaQRcode.jsp";                          //devolver informação para esta pagina
            request.setAttribute("link", imprimiQRcode.QRcodeLink(CodigoEvento));   //devolver a informação para este link

        } else if (action.equalsIgnoreCase("listEventos")) {                    //Lista Eventos no site (informação basica)
            forward = "ad_eventolistar.jsp";
            request.setAttribute("eventos", daoE.getAllEvento());

        } else if (action.equalsIgnoreCase("listEventosConsulta")) {            //Lista Eventos para o ADMIN - TELA Imprime Lista e QRCODE
            forward = "ad_eventolistarconsulta.jsp";
            request.setAttribute("eventos", daoE.getAllEvento());

        } else if (action.equalsIgnoreCase("listEventosConsultaMobile")) {      //Lista Eventos para o MOBILE - TELA Imprime Lista e QRCODE
            forward = "consultamobile.jsp";
            request.setAttribute("eventos", daoE.getAllEvento());

        } else if (action.equalsIgnoreCase("disponibilidade")) {                //Verifica se da do Evento está Disponível
            forward = "ad_eventolistarconsulta.jsp";
            request.setAttribute("eventos", daoE.getAllEvento());

        } else {
            mensagem = "OPS! Algo deu errado!";
            request.setAttribute("valida", mensagem);
            forward = "ad_eventocadastrar_valida.jsp";
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        CEventos evento = new CEventos();
        evento.setCodigoevento(0);
        evento.setDescevento(request.getParameter("fdescevento"));
        evento.setLocalevento(request.getParameter("flocalevento"));
        System.out.println(request.getParameter("fdescevento"));
        evento.setSala(request.getParameter("fsala"));

        evento.setLatitude(request.getParameter("flatitude"));
        evento.setLongitude(request.getParameter("flongitude"));

        evento.setSala(request.getParameter("fsala"));

        Date dob;

        try {
            dob = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fdataevento"));
            evento.setDataevento(dob);
        } catch (ParseException ex) {
            Logger.getLogger(EventosController.class.getName()).log(Level.SEVERE, null, ex);
        }

        evento.setHoraevento(Integer.parseInt(request.getParameter("fhoraevento")));
        qr.QR(evento.getQrcodeTODB());

        String qrcodeA = evento.getQrcodeTODB();
        String qrcodeB = daoE.getEventoByQrcode(evento.getQrcodeTODB());

//                System.out.println("."+qrcodeA+"." + " - "+ "."+qrcodeB+".");
//                 System.out.println(".");
        if (qrcodeA.equalsIgnoreCase(qrcodeB)) {
            mensagem = " ATENÇÃO!!! A Sala/Data/Horario informado ja possui uma reserva.Gentileza verificar a lista de eventos cadastrados!";
            String url = "ad_eventocadastrar_reservado.jsp";
//            response.sendRedirect(url);

        } else {
            daoE.addEventoCadastro(evento);
            mensagem = "Evento Registrado com Sucesso";
//            String url = "ad_eventocadastrar_valida.jsp";
            //response.sendRedirect(url);                                       //Redireciona para uma pagina

        }

        RequestDispatcher view = request.getRequestDispatcher(URL_DEV);         //devolver informação para esta pagina
        request.setAttribute("valida", mensagem); //devolver informação para esta pagina
        view.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
