package com.listagem.veiculos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.listagem.veiculos.models.Veiculo;
import com.listagem.veiculos.models.VeiculoFipe;
import com.listagem.veiculos.repository.VeiculoRepository;


@Service
public class VeiculoService {
	FipeService fipeService;
	VeiculoRepository veiculoRepository;
	
	@Autowired
	public VeiculoService(
			VeiculoRepository veiculoRepository,
			FipeService fipeService) {
		this.veiculoRepository = veiculoRepository;
		this.fipeService = fipeService;
	}
	

	public Veiculo salvar(Veiculo veiculo){

		VeiculoFipe veiculoFipe = this.fipeService.BuscarVeiculoFipe(veiculo.getMarca(), veiculo.getModelo(), veiculo.getAno());
		veiculo.setValorVeiculo(veiculoFipe.getValor());
	    return veiculoRepository.save(veiculo);
	}
	

	public List<Veiculo> consultarVeiculosPorUsuarioId(long usuarioId) {
	    return veiculoRepository.findByUsuarioId(usuarioId);
	}
	
}