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
import com.evento.util.ValidaCPF;
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
    private GetMACAddressIp ipmac;

    public RegistroController() {
        super();
        daoP = new ParticipanteDao();
        daoE = new EventoDao();
        ipmac = new GetMACAddressIp();
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
            try {
                request.setAttribute("nomeevento", daoE.getEventoById(QRvento).getDescevento());
            } catch (SQLException ex) {
                Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (action.equalsIgnoreCase("registrarparticipante")) {          // Por meio do QRCODE(URL) resgistra presença no evento
//            System.out.println(request.getParameter("QREvento"));
            String QRvento = request.getParameter("QREvento");
            CEventos evento;
            try {
                evento = daoE.getEventoById(QRvento);
                forward = "ad_eventos_aut_cpf.jsp";
                request.setAttribute("participante", evento);
                request.setAttribute("ipserver", ipmac.getArpIpLocalHost());

            } catch (SQLException ex) {
                Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (action.equalsIgnoreCase("CdstrParticipante")) { // Administrador Cadastrar participante que não possui mobile

            String QRvento = request.getParameter("CodigoEvento");
            CEventos evento;
            try {

                evento = daoE.getEventoById(QRvento);

                forward = "ad_eventos_aut_cpf.jsp";
                request.setAttribute("participante", evento);
                request.setAttribute("ipserver", ipmac.getArpIpLocalHost());

            } catch (SQLException ex) {
                Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (action.equalsIgnoreCase("SaidaParticipante")) { // Administrador Cadastrar participante que não possui mobile

            String QRvento = request.getParameter("CodigoEvento");
            String CPF = request.getParameter("CodigoCPF");
            daoP.RegistraSaidaParticipante(QRvento, CPF);
            forward = "url_dev_eventos.jsp";
            String mensagem = "Saida registrada com sucesso!";
            request.setAttribute("valida", mensagem);
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
        ValidaCPF Valcpf = new ValidaCPF();

        participante.setQrcodeTODB(request.getParameter("FQrcodeEvento"));
        participante.setDescevento(request.getParameter("FNomeEvento"));
        participante.setLocalevento(request.getParameter("FLocalEvento"));
//        participante.setSala(request.getParameter("fsala"));
        Date dob;

        try {
            dob = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("FDataEvento"));
            participante.setDataevento(dob);
        } catch (ParseException ex) {
            Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
        }

//        participante.setHoraevento(Integer.parseInt(request.getParameter("FHoraEvento")));
        participante.setCpfParticipante(request.getParameter("Fcpf"));
        participante.setNomeParticipante(request.getParameter("Fnome"));
        String nomeParticipante = request.getParameter("Fnome");
        participante.setTelefoneMovelParticipante(request.getParameter("Ftelefone2"));

        participante.setLatitude(request.getParameter("Flatitude1"));
        participante.setLongitude(request.getParameter("flongitude2"));

//        System.out.println(" iplocal: " + Inet4Address.getLocalHost().getHostAddress()+ "/ IpSite: " +request.getParameter("fip2"));  //iplocal
        participante.setMacAdress(ipmac.getMACAddress(request.getParameter("fip2")));
        String ipParticipante = request.getParameter("fip2");
        String toURL = "url_dev.jsp";
        CEventos evento;

        try {
            evento = daoE.getEventoById(participante.getQrcodeTODB());
            participante.setGeotrue(geo.coordenadas(participante.getLatitude(), participante.getLongitude(), evento.getLatitude(), evento.getLongitude()));
        } catch (SQLException ex) {
            Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
        }

        String mensagem = "";
        try {
            //Valida Localização
            if (participante.isGeotrue()) {

                if (ipmac.getMACAddress(ipParticipante).equalsIgnoreCase("LOCALHOST")) {

                    // Valida se o MAC ja foi registrado ou se é o Admin fazendo o cadastro pelo Site (LOCALHOST)
                    if (!daoP.ConsultarParticipanteRegistrado(participante)) {

                        if (Valcpf.validaCpf(participante.getCpfParticipante())) {
                            daoP.addEventoParticipante(participante);
                            toURL = "url_dev.jsp";
                            mensagem = "Olá " + nomeParticipante.toUpperCase() + " seu registro foi efetuado com sucesso";
                        } else {
                            mensagem = "O CPF informado é inválido!";
                        }

                    } else {
                        toURL = "url_dev_saida.jsp";
                        mensagem = "Ola, existe um registro com o CPF informado. "
                                + "Deseja confirmar a saida do evento?";
                        request.setAttribute("participante", participante);
                    }

                } else {

                    CParticipante pessoa = new CParticipante();

                    pessoa = daoP.ConsultarParticipanteSaida(participante);
                    System.out.println(pessoa.getMacAdress() + "/" + participante.getMacAdress() + "/" + pessoa.getCpfParticipante() + "/" + participante.getCpfParticipante());
                    // Se não existir MAC/CPF o registro será efetuado
                    if (!pessoa.getMacAdress().equals(participante.getMacAdress())
                            && !pessoa.getCpfParticipante().equals(participante.getCpfParticipante())) {

                        if (Valcpf.validaCpf(participante.getCpfParticipante())) {
                            daoP.addEventoParticipante(participante);
                            toURL = "url_dev.jsp";
                            mensagem = "Olá " + nomeParticipante.toUpperCase() + " seu registro foi efetuado com sucesso";
                        } else {
                            mensagem = "O CPF informado é inválido!";
                        }

                    } else if (pessoa.getMacAdress().equals(participante.getMacAdress())
                            && pessoa.getCpfParticipante().equals(participante.getCpfParticipante())) {
                        toURL = "url_dev_saida.jsp";
                        mensagem = "Ola! " + nomeParticipante.toUpperCase() + " você está registrado neste evento. "
                                + "Deseja confirmar sua saida?";
                        request.setAttribute("participante", participante);
                    } else if (pessoa.getMacAdress().equals(participante.getMacAdress())) {
                        toURL = "url_dev.jsp";
                        mensagem = "Este equipamento foi registrado em nosso sistema usando outro CPF. Não será possivel concluir o registro!";
                    } else {
                        toURL = "url_dev.jsp";
                        mensagem = "O CPF foi registrado em nosso sistema usando outro equipamento. Não será possivel concluir o registro!";

                    }

                }

            } else {
                mensagem = "Seu aparelho está fora da area de autenticação. Verifique as permições de localização ou dirija-se ao Balcao de Informação";

            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
        }

//                } else if (!daoP.ConsultarEquipamentoRegistrado(participante)) {
//                            //Valida CPF Cadastrado no Evento
//                            if (!daoP.ConsultarParticipanteRegistrado(participante)) {
//                                 daoP.addEventoParticipante(participante);
//                                 toURL = "url_dev.jsp";
//                                 mensagem = "Olá " + nomeParticipante.toUpperCase() + " seu registro foi efetuado com sucesso";
//                             } else {
//                                 toURL = "url_dev.jsp";
//                                 mensagem = "-Ola, existe um registro feito através deste equipamento. "
//                                         + " Entendemos que deseja registrar sua saida do evento, confirma?";
//                                 request.setAttribute("participante", participante);
//                             }
//
//                        } else {
//                           toURL = "url_dev_saida.jsp";
//                            mensagem = "Ola, existe um registro feito através deste equipamento. "
//                                    + " Entendemos que deseja registrar sua saida do evento, confirma?";
//                            request.setAttribute("participante", participante);
//                        }     
//                
        RequestDispatcher view = request.getRequestDispatcher(toURL);         //devolver informação para esta pagina
        request.setAttribute("valida", mensagem); //devolver informação para esta pagina
        view.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
