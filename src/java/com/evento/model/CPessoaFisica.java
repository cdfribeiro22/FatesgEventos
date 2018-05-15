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
public class CPessoaFisica extends CPessoaEndereco{
    
    
    protected String documento;
    protected Date dt_nasc;
    protected String sexo;     
    protected String telefoneFixo; 
    protected String telefoneMovel;    
    protected String cpf;
    protected String orgaoExpeditor;
    protected String statusUsuario; // Se a conta está ativa ou inativa
    protected String Guia; //Informar se é Guia Turistico.
    
    public CPessoaFisica() {
        
        super();
    }
    
    

    public CPessoaFisica(String documento, Date dt_nasc, String sexo, String telefoneFixo, String telefoneMovel, String cpf, String orgaoExpeditor, int codigoUser) {
        this.documento = documento;
        this.dt_nasc = dt_nasc;
        this.sexo = sexo;
        this.telefoneFixo = telefoneFixo;
        this.telefoneMovel = telefoneMovel;
        this.cpf = cpf;
        this.orgaoExpeditor = orgaoExpeditor;
        
    }

   
    
    
    

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(Date dt_nasc) {
        this.dt_nasc = dt_nasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneMovel() {
        return telefoneMovel;
    }

    public void setTelefoneMovel(String telefoneMovel) {
        this.telefoneMovel = telefoneMovel;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getOrgaoExpeditor() {
        return orgaoExpeditor;
    }

    public void setOrgaoExpeditor(String orgaoExpeditor) {
        this.orgaoExpeditor = orgaoExpeditor;
    }

    public String getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(String statusUsuario) {
        this.statusUsuario = statusUsuario;
    }


    public int getCodigoendereco() {
        return codigoendereco;
    }

    public void setCodigoendereco(int codigoendereco) {
        this.codigoendereco = codigoendereco;
    }

    public int getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(int codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
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

    public String getGuia() {
        return Guia;
    }

    public void setGuia(String Guia) {
        this.Guia = Guia;
    }

    

    
    
}
