package com.evento.util;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class CreateQR {
    
    

    public void QR(String qrcode) {
        GetMACAddressIp ip  = new GetMACAddressIp();
        try {
//            String hostaddress = InetAddress.getLocalHost().getHostAddress(); // Buscar ip virtual
            //String linkValidaQrcode = "10.21.5.232"+":8080/E-ventos/CadastroController?action=listarCliente&CodigoCliente="+44;   //TESTE
            String linkValidaQrcode = "https://" + ip.getArpIp() + ":8181/FatesgEventos/RegistroController?action=registrarparticipante&QREvento=" + qrcode; //Correto

            System.out.println("QRcode hostaddress " + ip.getArpIp());
            System.out.println(linkValidaQrcode);

            int size = 300;
            String nomeArquivo;
//        if(hostaddress.substring(1, 10).equalsIgnoreCase("192.168.1")){

            nomeArquivo = "C:\\Users\\Carlos Daniel\\Documents\\NetBeansProjects\\FatesgEventos\\web\\Qrcode\\" + qrcode + ".jpg";
//        
//        }else{
//                
//         nomeArquivo = "C:\\Users\\Carlos Daniel\\Documents\\NetBeansProjects\\FatesgEventos\\web\\Qrcode\\"+qrcode+".jpg";
//        }
            try {
                FileOutputStream f = new FileOutputStream(nomeArquivo);
                ByteArrayOutputStream out = QRCode.from(linkValidaQrcode).to(ImageType.JPG).withSize(size, size).stream();

                f.write(out.toByteArray());
                f.close();
                System.out.println("OK");

            } catch (UnknownHostException ex) {
                Logger.getLogger(CreateQR.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreateQR.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CreateQR.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public String QRcodeLink(String qrcode) throws IOException {
        GetMACAddressIp ip  = new GetMACAddressIp();
        
//            String hostaddress = InetAddress.getLocalHost().getHostAddress(); // Buscar ip virtual
            //String linkValidaQrcode = "10.21.5.232"+":8080/E-ventos/CadastroController?action=listarCliente&CodigoCliente="+44;   //TESTE
            String linkValidaQrcode = "https://" + ip.getArpIp() + ":8181/FatesgEventos/RegistroController?action=registrarparticipante&QREvento=" + qrcode; //Correto

            System.out.println("QRcode hostaddress " + ip.getArpIp());
            System.out.println(linkValidaQrcode);

            int size = 300;
            String nomeArquivo;
//        if(hostaddress.substring(1, 10).equalsIgnoreCase("192.168.1")){

            nomeArquivo = "Qrcode\\" + qrcode + ".jpg";
            return nomeArquivo;
//        }else{
//                
//         nomeArquivo = "C:\\Users\\Carlos Daniel\\Documents\\NetBeansProjects\\FatesgEventos\\web\\Qrcode\\"+qrcode+".jpg";
//        }

        
        
    }
}
