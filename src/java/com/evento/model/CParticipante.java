/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evento.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Carlos Daniel
 */
public class CParticipante extends CEventos {
    
    private String nomeParticipante;
    private String macAdress; 
    private String telefoneMovelParticipante;    
    private String cpfParticipante;
    private boolean geotrue = false;
    private Timestamp datahoraregistro;

    
    public CParticipante() {
        super();
    }

    public String getNomeParticipante() {
        return nomeParticipante;
    }

    public void setNomeParticipante(String nomeParticipante) {
        this.nomeParticipante = nomeParticipante;
    }

    public String getMacAdress() {
        return macAdress;
    }

    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
    }

    public String getTelefoneMovelParticipante() {
        return telefoneMovelParticipante;
    }

    public void setTelefoneMovelParticipante(String telefoneMovelParticipante) {
        this.telefoneMovelParticipante = telefoneMovelParticipante;
    }

    public String getCpfParticipante() {
        return cpfParticipante;
    }

    public void setCpfParticipante(String cpfParticipante) {
        this.cpfParticipante = cpfParticipante.replace(".", "").replace("-", "");
    }

    
    public int getCodigoevento() {
        return codigoevento;
    }

    public void setCodigoevento(int codigoevento) {
        this.codigoevento = codigoevento;
    }

    public String getDescevento() {
        return descevento;
    }

    public void setDescevento(String descevento) {
        this.descevento = descevento;
    }

    public String getLocalevento() {
        return localevento;
    }

    public void setLocalevento(String localevento) {
        this.localevento = localevento;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Date getDataevento() {
        return dataevento;
    }

    public void setDataevento(Date dataevento) {
        this.dataevento = dataevento;
    }

    public int getHoraevento() {
        return horaevento;
    }

    public void setHoraevento(int horaevento) {
        this.horaevento = horaevento;
    }

    public String getQrcodeTODB() {
        return qrcodeTODB;
    }

    public void setQrcodeTODB(String qrcode) {
        this.qrcodeTODB = qrcode;
        this.Qrcode = qrcode;
    }

    public boolean isGeotrue() {
        return geotrue;
    }

    public void setGeotrue(boolean geotrue) {
        this.geotrue = geotrue;
    }

    public Timestamp getDatahoraregistro() {
        return datahoraregistro;
    }

    public void setDatahoraregistro(Timestamp datahoraregistro) {
        this.datahoraregistro = datahoraregistro;
    }
    
    
    


 
    
    

   

    
    
   
    
    
    

    

    
    
}
