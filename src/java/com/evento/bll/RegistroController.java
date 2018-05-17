/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evento.bll;

import com.evento.dao.EventoDao;
import com.evento.dao.ParticipanteDao;
import com.evento.model.CEventos;

import com.evento.model.CParticipante;
import com.evento.util.GetMACAddressIp;
import com.evento.util.ValidaGeolocalizacao;

import java.io.IOException;
import java.sql.SQLException;

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
@WebServlet("/RegistroController")
public class RegistroController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String URL_DEV = "/ad_eventos_aut_cpf_valida.jsp";
    private static String INSERT_OR_EDIT = "/cadastroCliente_1_Dados_1.jsp";
    private ParticipanteDao daoP;
    private EventoDao daoE;

    public RegistroController() {
        super();
        daoP = new ParticipanteDao();
        daoE = new EventoDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("listParticipantes")) {            //Imprime Lista participantes de um determinado evento
            System.out.println("Lista participantes");
            String QRvento = request.getParameter("CodigoEvento");
            
            forward = "ad_eventolistarpresenca.jsp";
            request.setAttribute("participantes", daoP.getListParticipantes(QRvento));
            
      } else if (action.equalsIgnoreCase("listParticipantesMobile")) {            //Imprime Lista participantes apara mobile
            System.out.println("Mobile");
            String QRvento = request.getParameter("CodigoEvento");
            
            forward = "eventolistarpresencamobile.jsp";
            request.setAttribute("participantes", daoP.getListParticipantes(QRvento));
             request.setAttribute("nomeevento", daoE.getEventoById(QRvento).getDescevento());
            
 
              
        } else if (action.equalsIgnoreCase("registrarparticipante")) {
//            System.out.println(request.getParameter("QREvento"));
            String QRvento = request.getParameter("QREvento");
            CEventos evento = daoE.getEventoById(QRvento);
            
            forward = "ad_eventos_aut_cpf.jsp";
            request.setAttribute("participante", evento);

        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        JOptionPane.showMessageDialog(null, "DOPOST");
        CParticipante participante = new CParticipante();
        ValidaGeolocalizacao geo = new ValidaGeolocalizacao();

        participante.setQrcodeTODB(request.getParameter("FQrcodeEvento"));
        participante.setDescevento(request.getParameter("FNomeEvento"));
        participante.setLocalevento(request.getParameter("FLocalEvento"));
//        participante.setSala(request.getParameter("fsala"));
        Date dob;
        try {
            dob = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("FDataEvento"));
            participante.setDataevento(dob);
        } catch (ParseException ex) {
            Logger.getLogger(EventosController.class.getName()).log(Level.SEVERE, null, ex);
        }
//        participante.setHoraevento(Integer.parseInt(request.getParameter("FHoraEvento")));

        participante.setCpfParticipante(request.getParameter("Fcpf"));
        participante.setNomeParticipante(request.getParameter("Fnome"));
        participante.setTelefoneMovelParticipante(request.getParameter("Ftelefone2"));

        participante.setLatitude(request.getParameter("Flatitude1"));
        participante.setLongitude(request.getParameter("flongitude2"));

//        System.out.println(" iplocal: " + Inet4Address.getLocalHost().getHostAddress()+ "/ IpSite: " +request.getParameter("fip2"));  //iplocal
        GetMACAddressIp ipmac = new GetMACAddressIp();
        participante.setMacAdress(ipmac.getMACAddress(request.getParameter("fip2")));

        CEventos evento = daoE.getEventoById(participante.getQrcodeTODB());

        participante.setGeotrue(geo.coordenadas(participante.getLatitude(), participante.getLongitude(), evento.getLatitude(), evento.getLongitude()));

        String mensagem = "";
        
        try {

        if (participante.isGeotrue()) { 
            if (daoP.ConsultarParticipanteRegistrado(participante)){
                 if (daoP.ConsultarEquipamentoRegistrado(participante)){
                    daoP.addEventoParticipante(participante);
                    mensagem = "Registro efetuado com sucesso";
                 }
                 else{
                     mensagem = "Não foi possivel realizar o cadastro. Só é possivel um unico registro por aparelho em cada evento";
                 }
            }else{
                 mensagem = "Não foi possivel realizar o cadastro. O CPF informado ja está cadastrado no evento.";
            }   
        } else {
             mensagem = "Seu aparelho está fora da area de autenticação. Verifique as permições de localização ou dirija-se ao Balcao de Informação";
                
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
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
