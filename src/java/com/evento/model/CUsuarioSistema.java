/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evento.model;

import java.util.Date;

/**
 *
 * @author Avell 1513
 */
public class CUsuarioSistema extends  CPessoa{
    
    protected int tipoUsuario;
    protected String email ;
    protected String senha;
    protected Date DtCadastro;
    protected Date DtAcesso;

    public CUsuarioSistema(int tipoUsuario, String email, String senha, Date DtCadastro, Date DtAcesso) {
        this.tipoUsuario = tipoUsuario;
        this.email = email;
        this.senha = senha;
        this.DtCadastro = DtCadastro;
        this.DtAcesso = DtAcesso;
    }
    
   

    public CUsuarioSistema() {
         super();
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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

    public Date getDtCadastro() {
        return DtCadastro;
    }

    public void setDtCadastro(Date DtCadastro) {
        this.DtCadastro = DtCadastro;
    }

    public Date getDtAcesso() {
        return DtAcesso;
    }

    public void setDtAcesso(Date DtAcesso) {
        this.DtAcesso = DtAcesso;
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
    
    
    
}
