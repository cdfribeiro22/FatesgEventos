/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evento.model;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Carlos Daniel
 */
public class CEventos {

    protected int codigoevento;
    protected String descevento;
    protected String localevento;
    protected String sala;
    protected String latitude;
    protected String longitude;
    protected Date dataevento;
    protected int horaevento;
    protected String Qrcode;
    protected String qrcodeTODB;
    protected int qntparticipantes;

    
    
    public CEventos() {
   
    }
    
    

    /**
     * @return the codigoevento
     */
    public int getCodigoevento() {
        return codigoevento;
    }

    /**
     * @return the descevento
     */
    public String getDescevento() {
        return descevento;
    }

    /**
     * @return the localevento
     */
    public String getLocalevento() {
        return localevento;
    }

    /**
     * @return the coodxevento
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @return the coodyevento
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @return the dataevento
     */
    public Date getDataevento() {
        return dataevento;
    }

    /**
     * @return the horaevento
     */
    public int getHoraevento() {
        return horaevento;
    }

    /**
     * @param codigoevento the codigoevento to set
     */
    public void setCodigoevento(int codigoevento) {
        this.codigoevento = codigoevento;
    }

    /**
     * @param descevento the descevento to set
     */
    public void setDescevento(String descevento) {
        this.descevento = descevento;
    }

    /**
     * @param localevento the localevento to set
     */
    public void setLocalevento(String localevento) {
        this.localevento = localevento;
    }

    /**
     * @param coodxevento the coodxevento to set
     */
    public void setLatitude(String latitude ) {
        this.latitude = latitude;
    }

    /**
     * @param coodyevento the coodyevento to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * @param dataevento the dataevento to set
     */
    public void setDataevento(Date dataevento) {
        this.dataevento = dataevento;
    }

    /**
     * @param horaevento the horaevento to set
     */
    public void setHoraevento(int horaevento) {
        this.horaevento = horaevento;
    }

    /**
     * @return the qrcodeTODB
     */
    public String getQrcodeTODB() {
        setQrcode();
        return qrcodeTODB;
    }

    public String getSala() {
        return this.sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
    
    public void setQrcode1() {
        
        
    }
    
    
   

    /**
     */
    public void setQrcode() {

//        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(dataevento);
        //System.out.println("Report Date: " + reportDate);

        this.qrcodeTODB = sala.substring(sala.indexOf("_")+1) + "_" + reportDate.replace("/", "") + "_H" + horaevento;
        /**
         *
         * @param dtData
         * @return
         */

    }

    public void setQrcodeTODB(String qrcodeTODB) {
        this.qrcodeTODB = qrcodeTODB;
    }
    
    public String getLatitude10() {
        return latitude.substring(0,10);
    }

    /**
     * @return the coodyevento
     */
    public String getLongitude10() {
        return longitude.substring(0,10);
    }

    public String getQrcode() {
        return Qrcode;
    }

    public void setQrcode(String Qrcode) {
        this.Qrcode = Qrcode;
    }

    public int getQntparticipantes() {
        return qntparticipantes;
    }

    public void setQntparticipantes(int qntparticipantes) {
        this.qntparticipantes = qntparticipantes;
    }

    
    
    
}
