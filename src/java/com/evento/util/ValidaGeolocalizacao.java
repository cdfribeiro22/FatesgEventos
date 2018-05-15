/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




//Dividindo um minuto por 60, tem-se que um segundo (") equivale a 30,87 m 


package com.evento.util;

/**
 *
 * @author Carlos Daniel
 */
public class ValidaGeolocalizacao {
       
    int latitudePes;
    int longitudePes;
    int latitudeEv;
    int longitudeEv;
        
          
//        *1000^6)+(z*cemmetros)
//    +(z*cemmetros)*1000^6;
    
    // x latitude, y longitude, z tolerancia em metros
    public boolean coordenadas (String latitudeP, String longitudeP, String latitudeE, String longitudeE){  //E evento P pessoa
        
        latitudePes = Integer.parseInt(latitudeP.substring(0,10).replace(".", "")) ;
        System.out.println( "Posição Pessoa LAT " + latitudePes);
        
        longitudePes = Integer.parseInt(longitudeP.substring(0,10).replace(".", "")) ;
        System.out.println( "Posição Pessoa LON " + longitudePes);
         System.out.println( " - " );
        
        latitudeEv = Integer.parseInt(latitudeE.substring(0,10).replace(".", "")) ;
        
        System.out.println( "Min " + (latitudeEv+1000));
        System.out.println( "Evento " + latitudeEv);
        System.out.println( "Max " + (latitudeEv-1000));
         System.out.println( " - " );
        
        longitudeEv = Integer.parseInt(longitudeE.substring(0,10).replace(".", "")) ;
       
        System.out.println( "Min " + (longitudeEv+1000));
         System.out.println( "Evento " + longitudeEv);
        System.out.println("Max " + (longitudeEv-1000) );
        System.out.println( " - " );
     
        
         System.out.println( (latitudeEv+1000) + " / " + latitudePes + " / " + (latitudeEv-1000));

        if (  (latitudePes < (latitudeEv+1000)) && (latitudePes > (latitudeEv-1000))  ){
           
            System.out.println( (longitudeEv+1000) + " / " + longitudePes + " / " + (longitudeEv-1000));
            
            if (  (longitudePes < (longitudeEv+1000)) && (longitudePes > (longitudeEv-1000))  ){
                 System.out.println("Dentro da area de autenticação");
                return true;
                
            }else{
                System.out.println("lat lon falso");
                return false;
            }    
        }else{
            System.out.println("lat falso");
            return false;
        }
            

    }
   
    
    
}
