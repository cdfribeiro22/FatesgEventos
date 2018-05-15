/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evento.teste;

//import com.eventos.dao.EventosDao;
//import com.eventos.dao.UsuarioDao;
//import com.eventos.model.CEventos;
//import com.eventos.model.CPessoaEndereco;
//import com.eventos.model.CParticipante;
//import com.eventos.model.CParticipante;
//import com.eventos.model.Pessoa;
import com.evento.dao.ParticipanteDao;
import com.evento.model.CParticipante;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Carlos Daniel
 */
public class PessoaTeste {

    public static void main(String[] args) throws IOException, SQLException {
//        CParticipante p = new CParticipante();
//        p.setCpfParticipante("043245036052");
//        p.setQrcode("S105_05022018_H17");
//        p.setMacAdress("98-39-8e-9f-01-e9");
//        
//        ParticipanteDao dao = new ParticipanteDao();
//        
////        System.out.println(dao.ConsultarRegistroParticipante(p));
////        System.out.println(dao.ConsultarParticipanteRegistrado(p));
//
//        System.out.println(dao.getNumParticipantes());
//        
        Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
        Date d = new Date(System.currentTimeMillis());
       
        System.out.println(dataDeHoje);
        System.out.println(d);
    
    }
//    
//    
//    public class PessoaTeste {
//
//    public static void main(String[] args) throws IOException {
//       CreateQR novoqr = new CreateQR();
//       
//       novoqr.QR("S101_05012018_H7");
//        
//    
//    }
//    
//    public static void main(String[] args) throws IOException {
//        ValidaGeolocalizacao val = new ValidaGeolocalizacao();
//        val.coordenadas("-16,671900", "-49,238400", "-16,671700", "-49,238700");
//        
//    }
//    
//--------------------------------------------------------------------------------------------------------------------------    
//   public static void main(String[] args) throws IOException  { 
//    
//
//   
//  
//        String ARP_GET_IP_HW = "arp -a" + " 192.168.1.107";
//        
//
//                
//        GetMACAddressIp get = new GetMACAddressIp();
////        String saida2 = get.getMACAddress("192.168.1.103");
////         System.out.println(saida2);
//         String saida1 = get.getArpIp();
//         System.out.println(saida1);
//        
//   }  
//        
//    public String getARPTable(String cmd) throws IOException {
//        Scanner s = new Scanner(Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
//        return s.hasNext() ? s.next() : "";
//         
//    }
//--------------------------------------------------------------------------------------------------------------------------
//    public static void main(String[] args) throws IOException {
//
//        CEventos ev = new CEventos();
//        EventoDao dao = new EventoDao();
//
//        ev = dao.getEventoById("S101_05012018_H7");
//
//        System.out.println(ev.getLocalevento());
//
//        CreateQR qr = new CreateQR();
//
//        qr.QR( "S101_05012018_H7");
//        
//
//
//    }
//        
//        String x = request.getParameter("dataUsuario"); //pegando dados de um formulário WEB
//
//        Date d = new Date();
//        Calendar cal = new GregorianCalendar();
//        cal.getTime();
//
//
//
//        EventosDao Edao = new EventosDao();
//        CEventos evento = new CEventos();
//        evento.setDescevento("TESTE LINUX1");
//        evento.setLocalevento("Fatesg Goiania1");
//        evento.setCoodxevento(-47589554);
//        evento.setCoodyevento(-47689554);
//        evento.setHoraevento(10);
//        evento.setDataevento(cal.getTime());
//
//        Edao.addEventosCadastro(evento);
//
//    
//        try {
//        UsuarioDao dao = new UsuarioDao();
//
//        CParticipante cliente = new CParticipante();
//        BigInteger num = BigInteger.valueOf(0);
//        Date d = new Date();
//        Calendar cal = new GregorianCalendar();
//        cal.getTime();
//        BigDecimal decimal = new BigDecimal(num);
//
//        cliente.setTipoPessoa(1);
//        cliente.setNome("Carlos 2");
//
//        cliente.setTipoUsuario(1);
//        cliente.setEmail("carlos1@gmail.com2");
//        cliente.setSenha("1234562");
//
//        cliente.setDocumento("10554201-12");
//
//        cliente.setSexo("Masculino2");
//        cliente.setTelefoneFixo("(62)98182-8461");
//
//        cliente.setTelefoneMovel("(62)98182-8461");
//        cliente.setCpf("043.345.036.05");
//        cliente.setOrgaoExpeditor("SSP-MG2");
//
//        cliente.setLogradouro("Rua 1");
//        cliente.setNumero(12345);
//        cliente.setComplemento("apto 1");
//        cliente.setBairro("bairro 1");
//        cliente.setEstado("Estado 1");
//        cliente.setCidade(" cidade 1");
//        cliente.setCod_postal("74.223-045");
//        cliente.setPais("Brasil 1");
//
//        dao.addPessoaCadastro(cliente);
//        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e);
//        }
//    }

}
