/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evento.dao;

import com.evento.util.Conexao;
import com.evento.model.CEventos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Avell 1513
 */
public class EventoDao {

    private Connection connection;
    private ParticipanteDao daoP;

    Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
    Date d = new Date(System.currentTimeMillis());

    public EventoDao() {
        connection = Conexao.getConnection();
        daoP = new ParticipanteDao();
    }

    public void addEventoCadastro(CEventos evento) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into eventos (  descevento , localevento , salaevento,"
                            + "latitudeevento , longitudeevento , dataevento , horaevento, qrcodeevento )"
                            + "values ( ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, evento.getDescevento());
            preparedStatement.setString(2, evento.getLocalevento());
            preparedStatement.setString(3, evento.getSala());
            preparedStatement.setString(4, evento.getLatitude());
            preparedStatement.setString(5, evento.getLongitude());
            preparedStatement.setDate(6, new Date(evento.getDataevento().getTime()));
            preparedStatement.setInt(7, evento.getHoraevento());
            preparedStatement.setString(8, evento.getQrcodeTODB());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CEventos> getAllEvento() {
        List<CEventos> srvs = new ArrayList<CEventos>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from eventos");

            while (rs.next()) {
                CEventos srv = new CEventos();
                srv.setCodigoevento(rs.getInt("codigoevento"));
                srv.setDescevento(rs.getString("descevento"));
                srv.setLocalevento(rs.getString("localevento"));
                srv.setSala(rs.getString("salaevento"));
                srv.setLatitude(rs.getString("latitudeevento"));
                srv.setLongitude(rs.getString("longitudeevento"));
                srv.setDataevento(rs.getDate("dataevento"));
                srv.setHoraevento(rs.getInt("horaevento"));
                srv.setQrcode(rs.getString("qrcodeevento"));
                srv.setQntparticipantes(daoP.getNumParticipantes(srv.getQrcode()));

                srvs.add(srv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return srvs;
    }

    public CEventos getEventoById(String Qrcode) {
        CEventos srv = new CEventos();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from eventos where qrcodeevento=?");
            preparedStatement.setString(1, Qrcode);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                srv.setCodigoevento(rs.getInt("codigoevento"));
                srv.setDescevento(rs.getString("descevento"));
                srv.setLocalevento(rs.getString("localevento"));
                srv.setLatitude(rs.getString("latitudeevento"));
                srv.setLongitude(rs.getString("longitudeevento"));
                srv.setDataevento(rs.getDate("dataevento"));
                srv.setHoraevento(rs.getInt("horaevento"));
                srv.setQrcode(rs.getString("qrcodeevento"));

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return srv;
    }

    public String getEventoByQrcode(String Qrcode) {
        String srv = null;
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select qrcodeevento from eventos where qrcodeevento=?");
            preparedStatement.setString(1, Qrcode);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                srv = (rs.getString("qrcodeevento"));

            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return srv;
    }

    
    
    
    
}
//

