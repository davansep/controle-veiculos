package com.listagem.veiculos.DTO;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.listagem.veiculos.models.Veiculo;

public class VeiculoDTO {

	private Long id;
	
	@NotNull(message = "Digite o id do Usuário")
	private Long usuarioId;

    @NotBlank(message = "Digite a marca do veículo")
	private String marca;

	@NotBlank(message = "Digite o modelo do veículo")
	private String modelo;

	@NotBlank(message = "Digite o ano do veículo")
	private String ano;
	
	private String diaRodizio;
	
	private boolean rodizioAtivo;
	
    private String valorVeiculo;

	public VeiculoDTO() {

	}
	// Construtores e getters e setters

	public Long getId() {
		return id;
	}

	public VeiculoDTO(Long id,
			@NotNull(message = "Digite o id do usuário") Long usuarioId,
			@NotBlank(message = "Digite a marca do veículo") String marca,
			@NotBlank(message = "Digite o modelo do veículo") String modelo,
			@NotBlank(message = "Digite o ano do veículo") String ano,
			String diaRodizio,
			boolean rodizioAtivo,
			String valorVeiculo) {
		super();
		this.id = id;
		this.usuarioId = usuarioId;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.diaRodizio = diaRodizio;
		this.rodizioAtivo = rodizioAtivo;
		this.valorVeiculo = valorVeiculo;
	}

	
	public String getDiaRodizio() {
		return diaRodizio;
	}

	public void setDiaRodizio(String diaRodizio) {
		this.diaRodizio = diaRodizio;
	}

	public boolean isRodizioAtivo() {
		return rodizioAtivo;
	}

	public void setRodizioAtivo(boolean rodizioAtivo) {
		this.rodizioAtivo = rodizioAtivo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	
	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	public Veiculo dtoParaVeiculo() {
		return new Veiculo(this.usuarioId, this.marca, this.modelo, this.ano);
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setEmail(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof VeiculoDTO))
			return false;
		VeiculoDTO that = (VeiculoDTO) o;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getMarca(), that.getMarca())
				&& Objects.equals(getModelo(), that.getModelo()) && Objects.equals(getAno(), that.getAno());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getMarca(), getModelo(), getAno());
	}

	public String getValorVeiculo() {
		return valorVeiculo;
	}

	public void setValorVeiculo(String valorVeiculo) {
		this.valorVeiculo = valorVeiculo;
	}
}
