/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evento.util;

import java.io.IOException;
import java.util.Scanner;

public class GetMACAddressIp {
    
    
    private String ARP_GET_IP_HW = "arp -a ";
    private String saida = "";


    public String getARPTable(String cmd) throws IOException {
        Scanner s = new Scanner(Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
       return s.hasNext() ? s.next() : "";

    }

    public String getMACAddress(String Ip) throws IOException {
        System.out.println("GetMACAddressIp recebido > " + Ip);
        saida = getARPTable(ARP_GET_IP_HW + Ip);
        
                                                                                System.out.println("IP " + (saida.indexOf("IP", 0)+63) + " / " + "Din " + saida.indexOf("din"));
                                                                                System.out.println("GetMACAddressIp para DB > " + saida.substring(107, 129));
        
        String macAddress = saida.substring((saida.indexOf("IP", 0)+63),saida.indexOf("din"));
        
                                                                                System.out.println(">" + macAddress);
                                                                                System.out.println(macAddress.replace(" ", ""));
        return macAddress.replace(" ", "");
    }
    
    
    public String getArpIp() throws IOException {

        saida = getARPTable(ARP_GET_IP_HW);
        
         String ip = saida.substring((saida.indexOf("Interface")+11),saida.indexOf("---"));                                                                        System.out.println("IP " + (saida.indexOf("IP", 0)+63) + " / " + "Din " + saida.indexOf("din"));
                                                                                
                                                                                System.out.println(">" + ip);
                                                                                System.out.println(ip.replace(" ", ""));
        return ip.replace(" ", "");
    }
    
    




}
