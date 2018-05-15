package com.evento.model;



import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class CPessoa {
    
    protected int CodigoCliente; 
    protected int TipoPessoa;
    protected String nome; 
    
    public CPessoa() {
      super();
    }

    public CPessoa(int CodigoCliente, int TipoPessoa, String nome) {
        this.CodigoCliente = CodigoCliente;
        this.TipoPessoa = TipoPessoa;
        this.nome = nome;
    }
        
    

    public int getCodigoCliente() {
        return CodigoCliente;
    }

    public void setCodigoCliente(int CodigoCliente) {
        this.CodigoCliente = CodigoCliente;
    }

    public int getTipoPessoa() {
        return TipoPessoa;
    }

    public void setTipoPessoa(int TipoPessoa) {
        this.TipoPessoa = TipoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCodigoClienteString (){
        return "" + CodigoCliente;
    }



    
    
    
    
    
}