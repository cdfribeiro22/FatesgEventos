/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evento.model;

import java.util.Date;

/**
 *
 * @author Carlos Daniel
 */
public  class Pessoa extends CPessoa{
        
    private int tipo_usuario;
    private String email;
    private String senha;
    private Date dtCadatro;
    private Date dtUltAcess; 
    private int status;


    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDtCadatro() {
        return dtCadatro;
    }

    public void setDtCadatro(Date dtCadatro) {
        this.dtCadatro = dtCadatro;
    }

    public Date getDtUltAcess() {
        return dtUltAcess;
    }

    public void setDtUltAcess(Date dtUltAcess) {
        this.dtUltAcess = dtUltAcess;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


  
}
