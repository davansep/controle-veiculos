package com.listagem.veiculos.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VeiculoFipe {
	
	@JsonProperty(value = "Valor")
	private String valor;
	@JsonProperty(value = "Marca")
	private String marca;
	@JsonProperty(value = "Modelo")
	private String modelo;
	@JsonProperty(value = "AnoModelo")
	private String anoModelo;
	@JsonProperty(value = "Combustivel")
	private String combustivel;
	@JsonProperty(value = "CodigoFipe")
	private String codigoFipe;
	@JsonProperty(value = "MesReferencia")
	private String mesReferencia;
	@JsonProperty(value = "TipoVeiculo")
	private int tipoVeiculo;
	@JsonProperty(value = "SiglaCombustivel")
	private String siglaCombustivel;
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public String getCodigoFipe() {
		return codigoFipe;
	}
	public void setCodigoFipe(String codigoFipe) {
		this.codigoFipe = codigoFipe;
	}
	public String getMesReferencia() {
		return mesReferencia;
	}
	public void setMesReferencia(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}
	public int getTipoVeiculo() {
		return tipoVeiculo;
	}
	public void setTipoVeiculo(int tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	public String getSiglaCombustivel() {
		return siglaCombustivel;
	}
	public void setSiglaCombustivel(String siglaCombustivel) {
		this.siglaCombustivel = siglaCombustivel;
	}
	
}
