package com.evento.teste;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos Daniel
 */
public class QRCodeGenerator {
    
    public static void main (String[] args) throws FileNotFoundException, IOException{
    
    String details = "TESTE";
    
        ByteArrayOutputStream out = QRCode.from(details).to(ImageType.JPG).stream();
        
        File f = new File ("C:\\temp\\MyChannel_preview.jpeg");
        FileOutputStream fos = new FileOutputStream(f);
        
        fos.write(out.toByteArray());
        
        fos.flush();
        
        
        System.out.println("teste");
    }
    
    
    
}
