package com.listagem.veiculos.models;

import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.listagem.veiculos.DTO.VeiculoDTO;


@Entity
@Table(name = "VEICULOS")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnoreProperties("veiculos")
	@ManyToOne(optional = false)
	@JoinColumn(name = "usuario_id", foreignKey = @ForeignKey(name="fk_usuario", value = ConstraintMode.CONSTRAINT))
	private Usuario usuario;
	
	@Column(nullable = false, length = 30)
	private String marca;
	
	@Column(nullable = false, length = 30)
	private String modelo;
	
	@Column(nullable = false, length = 4)
	private String ano;

	@Transient
	private String diaRodizio;
	
	@Column(nullable = true, length = 30)
	private String valorVeiculo;

	//Construtores e getters e setters
	public Veiculo() {
	}
	
    public Veiculo(Long usuarioId, String marca, String modelo, String ano) {
    	this.usuario = new Usuario();
    	this.usuario.setId(usuarioId);
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }	
    
	public VeiculoDTO veiculoParaDTO() {
		return new VeiculoDTO(this.id, this.usuario.getId(), this.marca, this.modelo, this.ano, this.getDiaRodizio(), this.isRodizioAtivo(), this.valorVeiculo);
	}

	public Long getId() {
		return id;
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

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getValorVeiculo() {
		return valorVeiculo;
	}

	public void setValorVeiculo(String valorVeiculo) {
		this.valorVeiculo = valorVeiculo;
	}
	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Veiculo)) return false;
        Veiculo veiculo = (Veiculo) o;
        return id.equals(veiculo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

	public String getDiaRodizio() {
	
		var ultimoNumeroAno = this.ano.charAt(this.ano.length()-1);
        
		switch (ultimoNumeroAno) {
		case '0':
		case '1':
			diaRodizio = "segunda-feira";
			break;
		case '2':
		case '3':
			diaRodizio = "terça-feira";
			break;
		case '4':
		case '5':
			diaRodizio = "quarta-feira";
			break;
		case '6':
		case '7':
			diaRodizio = "quinta-feira";
			break;
		case '8':
		case '9':
			diaRodizio = "sexta-feira";
			break;				
		}
		
		return diaRodizio;
	}


	public boolean isRodizioAtivo() {		
		Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        var rodizioAtivo = false;
        
        if (day == 2 && diaRodizio == "segunda-feira") {
        	rodizioAtivo = true;
        } else if (day == 3 && diaRodizio == "terça-feira") {
        	rodizioAtivo = true;
        } else if (day == 4 && diaRodizio == "quarta-feira") {
        	rodizioAtivo = true;
        } else if (day == 5 && diaRodizio == "quinta-feira") {
        	rodizioAtivo = true;
        } else if (day == 6 && diaRodizio == "sexta-feira") {
        	rodizioAtivo = true;
        }
        
		return rodizioAtivo;
	}
}