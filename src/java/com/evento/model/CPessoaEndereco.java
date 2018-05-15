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
public class CPessoaEndereco extends CUsuarioSistema {

    protected int codigoendereco;
    protected int codigoPessoa;
    protected String logradouro;
    protected int numero;
    protected String complemento;
    protected String bairro;
    protected String estado;
    protected String cidade;
    protected String Pais;
    protected String cod_postal;

   
    public CPessoaEndereco(int codigoendereco, int codigoPessoa, String logradouro, int numero, String complemento, String bairro, String estado, String cidade, String Pais, String cod_postal) {
        this.codigoendereco = codigoendereco;
        this.codigoPessoa = codigoPessoa;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.estado = estado;
        this.cidade = cidade;
        this.Pais = Pais;
        this.cod_postal = cod_postal;
    }

    public CPessoaEndereco() {
        super();
    }

    
    

    public void CPessoaEndereco(CPessoaEndereco endereco) {
        this.codigoendereco = endereco.codigoendereco;
        this.codigoPessoa = endereco.codigoPessoa;
        this.logradouro = endereco.logradouro;
        this.numero = endereco.numero;
        this.complemento = endereco.complemento;
        this.bairro = endereco.bairro;
        this.estado = endereco.estado;
        this.cidade = endereco.cidade;
        this.Pais = endereco.Pais;
        this.cod_postal = endereco.cod_postal;
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
    
    
}
