/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */










package com.evento.bll;

import com.evento.dao.ParticipanteDao;
import com.evento.model.CParticipante;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Daniel
 */

@WebServlet("/ECadastroController")
public class CadastroController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/cadastroCliente_1_Dados_1.jsp";
    private static String LIST_Cliente = "/cadastroCliente_1_valido.jsp";
    private static String LIST_Admin_Clientes = "/admin_listarclientes.jsp";
    private static String LIST_OCliente = "/admin_dadosCliente.jsp";
    private ParticipanteDao dao;

    public CadastroController() {
        super();
        dao = new ParticipanteDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("ativar")) {
           
//            int CodigoCliente = Integer.parseInt(request.getParameter("CodigoCliente"));
//            dao.ativaCliente(CodigoCliente);
//            forward = LIST_Admin_Clientes;
//            request.setAttribute("clientes", dao.getAllCliente());

        } else if (action.equalsIgnoreCase("inativar")) {
           
//            int CodigoCliente = Integer.parseInt(request.getParameter("CodigoCliente"));
//            dao.inativaCliente(CodigoCliente);
//            forward = LIST_Admin_Clientes;
//            request.setAttribute("clientes", dao.getAllCliente());

        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            
////            JOptionPane.showMessageDialog(null, request.getParameter("CodigoCliente"));
            
//            int CodigoCliente = Integer.parseInt(request.getParameter("CodigoCliente"));
//            CParticipante cliente = dao.getPessoaById(CodigoCliente);
//            request.setAttribute("cliente", cliente);

        } else if (action.equalsIgnoreCase("listCliente")) {
            
//            forward = LIST_Admin_Clientes;
//            
//            request.setAttribute("clientes", dao.getAllCliente());
            
        } else if (action.equalsIgnoreCase("listarCliente")) {
            
//            forward = LIST_OCliente;
//            
//            int CodigoCliente = Integer.parseInt(request.getParameter("CodigoCliente"));
//            CParticipante cliente = dao.getPessoaById(CodigoCliente);
//            request.setAttribute("cliente", cliente);
           
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        JOptionPane.showMessageDialog(null, "DOPOST");
        CParticipante participante = new CParticipante();
//
//        participante.setCpf(request.getParameter("Fcpf"));
////            JOptionPane.showMessageDialog(null, request.getParameter("Ftipopessoa")); 
//            if ( "1".equals(request.getParameter("Ftipopessoa")))
//                participante.setTipoPessoa(1); 
//            participante.setTipoUsuario(1);
//            participante.setNome(request.getParameter("Fnome"));    
//            participante.setSexo(request.getParameter("Fsexo"));  
//            
           
////                   JOptionPane.showMessageDialog(null, request.getParameter("Fnascimento"));
//            Date dob;
//            try {
//                dob = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("Fnascimento"));
//                 participante.setDt_nasc(dob);
//            } catch (ParseException ex) {
//                Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//           
////            JOptionPane.showMessageDialog(null, cliente.getDt_nasc());
//           
//            participante.setDocumento(request.getParameter("Frg")); 
//            participante.setOrgaoExpeditor(request.getParameter("ForgaoExpeditor"));   
//            participante.setTelefoneFixo(request.getParameter("Ftelefone1"));    
//            participante.setTelefoneMovel(request.getParameter("Ftelefone2"));    
//            
// 
//            participante.setLogradouro(request.getParameter("Frua"));    
//            participante.setNumero(Integer.parseInt(request.getParameter("Fnumero")));    
//            participante.setComplemento(request.getParameter("Fcomplemento"));    
//            participante.setBairro(request.getParameter("Fbairro"));    
//            participante.setEstado(request.getParameter("Festado"));    
//            participante.setCidade(request.getParameter("Fcidade"));    
//            participante.setCod_postal(request.getParameter("Fcep"));    
//            participante.setPais(request.getParameter("Fpais"));  
////            String cep = request.getParameter("Fcep");
////            cep = cep.replace(".", "").replace("-", "");
////            cliente.setCod_postal(Integer.parseInt(cep));
//                       
//            participante.setEmail(request.getParameter("Femail"));
//            participante.setSenha(request.getParameter("repetir_senha"));
            
            

//       int CodigoCliente = Integer.parseInt(request.getParameter("Fcodigocliente"));
//       
////       JOptionPane.showMessageDialog(null, "DOPOST Codigo do cliente" + CodigoCliente);
//
//        if (CodigoCliente == 0) {
//            dao.addPessoaCadastro(participante);
//        } else {
//            participante.setCodigoCliente(Integer.parseInt(CodigoCliente+""));
//            dao.updatePessoa(participante);
//        }
//        RequestDispatcher view = request.getRequestDispatcher(LIST_Cliente);
//        request.setAttribute("clientes", dao.getAllCliente());
//        view.forward(request, response);
    }
    
    
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        JOptionPane.showMessageDialog(null, "Request");
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try{
//            ParticipanteDao dao = new ParticipanteDao();
//          
//            CParticipante pf = new CParticipante();
//            
//            PreparedStatement ps = null;
//            Connection cn = null;
//                       
//            pf.setCpf(request.getParameter("Fcpf"));
//            JOptionPane.showMessageDialog(null, request.getParameter("Ftipopessoa")); 
//            if ( "1".equals(request.getParameter("Ftipopessoa")))
//                pf.setTipoPessoa(1); 
//            pf.setTipoUsuario(1);
//            pf.setNome(request.getParameter("Fnome"));    
//            pf.setSexo(request.getParameter("Fsexo"));  
//            
//           
//                   JOptionPane.showMessageDialog(null, request.getParameter("Fnascimento"));
//            Date dob;
//            try {
//                dob = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("Fnascimento"));
//                 pf.setDt_nasc(dob);
//            } catch (ParseException ex) {
//                Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//           
//            JOptionPane.showMessageDialog(null, pf.getDt_nasc());
//           
//            pf.setDocumento(request.getParameter("Frg")); 
//            pf.setOrgaoExpeditor(request.getParameter("ForgaoExpeditor"));   
//            pf.setTelefoneFixo(request.getParameter("Ftelefone1"));    
//            pf.setTelefoneMovel(request.getParameter("Ftelefone2"));    
//            
// 
//            pf.setLogradouro(request.getParameter("Frua"));    
//            pf.setNumero(Integer.parseInt(request.getParameter("Fnumero")));    
//            pf.setComplemento(request.getParameter("Fcomplemento"));    
//            pf.setBairro(request.getParameter("Fbairro"));    
//            pf.setEstado(request.getParameter("Festado"));    
//            pf.setCidade(request.getParameter("Fcidade"));    
//            pf.setCod_postal(request.getParameter("Fcep"));    
//            pf.setPais(request.getParameter("Fpais"));  
//            String cep = request.getParameter("Fcep");
//            cep = cep.replace(".", "").replace("-", "");
//            pf.setCod_postal(Integer.parseInt(cep));
//                       
//            pf.setEmail(request.getParameter("Femail"));
//            pf.setSenha(request.getParameter("repetir_senha"));
            
//            JOptionPane.showMessageDialog(null, pf.getNome() 
//                                        + "\n " + pf.getCpf()
//                                        + "\n " + pf.getSexo()
//                                        + "\n " + pf.getDt_nasc()
//                                        + "\n " + pf.getDocumento()
//                                        + "\n " + pf.getTelefoneFixo()
//                                                + "\n " + pf.getLogradouro()
//                                                + "\n " + pf.getNumero()
//                                                + "\n " + pf.getComplemento()
//                                                + "\n " + pf.getBairro()
//                                                + "\n " + pf.getEstado()
//                                                + "\n " + pf.getCidade()
//                                                + "\n " + pf.getCod_postal()
//                                        + "\n " + pf.getEmail()
//                                        + "\n " + pf.getSenha()
//
//            );
            
                   
//            JOptionPane.showMessageDialog(null, "FIM CADASTRO"); 
//            dao.addPessoaCadastro(pf );
//            
//            String url = "cadastroCliente_1_valido.jsp";
//            response.sendRedirect(url);
//            
//        } finally {
//            out.close();
//        
//         }
    }



    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
