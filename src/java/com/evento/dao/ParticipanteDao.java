/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evento.dao;

import com.evento.model.CUsuarioSistema;
import com.evento.util.Conexao;
import com.evento.model.CParticipante;
import com.evento.model.CPessoaFisica;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Avell 1513
 */
public class ParticipanteDao {

    private Connection connection;

    Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
    Date d = new Date(System.currentTimeMillis());
//    

    public ParticipanteDao() {
        connection = Conexao.getConnection();

    }

    public void addEventoParticipante(CParticipante participante) {
        Date d = new Date(System.currentTimeMillis());

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into eventoregistro (  codigoevento , horaentrada , nome,"
                            + "cpf , telefone, macaddress, latitude, longitude, datahoraentrada )"
                            + "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, participante.getQrcodeTODB());
            preparedStatement.setTimestamp(2, dataDeHoje);
            preparedStatement.setString(3, participante.getNomeParticipante());
            preparedStatement.setString(4, participante.getCpfParticipante());
            preparedStatement.setString(5, participante.getTelefoneMovelParticipante());
            preparedStatement.setString(6, participante.getMacAdress());
            preparedStatement.setString(7, participante.getLatitude());
            preparedStatement.setString(8, participante.getLongitude());
            preparedStatement.setTimestamp(9, dataDeHoje);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean ConsultarParticipanteRegistrado(CParticipante p) throws SQLException {

        PreparedStatement preparedStatement = connection.
                prepareStatement("SELECT * FROM public.eventoregistro WHERE codigoevento=? AND cpf=?");

        preparedStatement.setString(1, p.getQrcode());
        System.out.println("Evento: " + p.getQrcode());
        preparedStatement.setString(2, p.getCpfParticipante());
        System.out.println("CPF: " + p.getCpfParticipante());

        ResultSet rs = preparedStatement.executeQuery();
        boolean found = false;
        while (rs.next()) {
            found = true;
        }
        if (!found) {
            return true;
        } else {
            return false;
        }

    }

    public boolean ConsultarEquipamentoRegistrado(CParticipante p) throws SQLException {

        PreparedStatement preparedStatement = connection.
                prepareStatement("SELECT * FROM public.eventoregistro WHERE codigoevento=? AND macaddress=?");
        preparedStatement.setString(1, p.getQrcode());
        preparedStatement.setString(2, p.getMacAdress());

        ResultSet rs = preparedStatement.executeQuery();
        boolean found = false;
        while (rs.next()) {
            found = true;
        }
        if (!found) {
            return true;
        } else {
            return false;
        }
    }


    public boolean ConsultarLogin(CUsuarioSistema login) {

        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from public.pessoa where uemail=? and usenha = ?");
            preparedStatement.setString(1, login.getEmail());
            preparedStatement.setString(2, login.getSenha());

            ResultSet rs = preparedStatement.executeQuery();
//			                 JOptionPane.showMessageDialog(null, "teste Dao");
            if (rs.next()) {
                return true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<CParticipante> getListParticipantes(String codEvento) {
        List<CParticipante> partipantes = new ArrayList<CParticipante>();
        try {
              PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from eventoregistro where codigoevento=?");
            preparedStatement.setString(1, codEvento);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("CE > " + codEvento);
            while (rs.next()) {
                CParticipante srv = new CParticipante();
                    
                System.out.println("Dao list " + rs.getString("nome"));
                srv.setQrcode(rs.getString("codigoevento"));
                srv.setNomeParticipante(rs.getString("nome"));
                srv.setCpfParticipante(rs.getString("cpf"));
                srv.setDatahoraregistro(rs.getTimestamp("datahoraentrada"));
                srv.setMacAdress(rs.getString("macaddress"));
                srv.setLatitude(rs.getString("latitude"));
                srv.setLongitude(rs.getString("longitude"));


                partipantes.add(srv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return partipantes;
    }
    
    
     public int getNumParticipantes(String codEvento) {
         int i=0;
         try {
             PreparedStatement preparedStatement = connection.
                    prepareStatement("select count(codigoevento) from  eventoregistro where codigoevento=?");
            preparedStatement.setString(1, codEvento);
            ResultSet rs = preparedStatement.executeQuery();
           
            while(rs.next())
            i = rs.getInt(1);
             rs.close();
            return i; 
         } catch (SQLException e) {
            e.printStackTrace();
        }
         return i; 
        
    }
    
   

    public CPessoaFisica getPessoaByEmail(String Email) {
        CPessoaFisica srv = new CPessoaFisica();

        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from pessoa where uemail=?");
            preparedStatement.setString(1, Email);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                srv.setDocumento(rs.getString("pdocumento"));
                srv.setDt_nasc(rs.getDate("pdtnascimento"));
                srv.setSexo(rs.getString("psexo"));
                srv.setTelefoneFixo(rs.getString("ptelefonefixo"));
                srv.setTelefoneMovel(rs.getString("ptelefonemovel"));
                srv.setOrgaoExpeditor(rs.getString("porgaoexpeditor"));
                srv.setCpf(rs.getString("pcpfcnpj"));
                srv.setNome(rs.getString("pnome"));
                srv.setTipoPessoa(Integer.parseInt(rs.getString("ptipopessoa")));
                srv.setTipoUsuario(Integer.parseInt(rs.getString("utipousuario")));
                srv.setEmail(rs.getString("uemail"));
                srv.setSenha(rs.getString("usenha"));
                srv.setDt_nasc(rs.getDate("udtcadastro"));
                srv.setDtAcesso(rs.getDate("udtultacesso"));
                srv.setCodigoCliente(Integer.parseInt(rs.getString("codigocliente")));
            }
            rs.close();
            return srv;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return srv;
    }


}
