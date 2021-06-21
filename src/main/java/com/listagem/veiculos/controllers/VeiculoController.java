package com.listagem.veiculos.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.listagem.veiculos.DTO.MensagemRespostaDTO;
import com.listagem.veiculos.DTO.VeiculoDTO;
import com.listagem.veiculos.models.Veiculo;
import com.listagem.veiculos.service.UsuarioService;
import com.listagem.veiculos.service.VeiculoService;

@RestController
@RequestMapping(path = "/carros")
public class VeiculoController {
	VeiculoService veiculoService;
	UsuarioService usuarioService;
	
	@Autowired
	public VeiculoController(
			VeiculoService veiculoService,
			UsuarioService usuarioService) {
		this.veiculoService = veiculoService;
		this.usuarioService = usuarioService;
	}
	
	@GetMapping(path = "/usuario/{usuarioId}")
	public ResponseEntity<MensagemRespostaDTO<List<VeiculoDTO>>> consultarVeiculo(@PathVariable("usuarioId")long usuarioId){
		
		var resposta = new MensagemRespostaDTO<List<VeiculoDTO>>();
		
		if (usuarioId <= 0) {
			resposta.setMensagem("usuário id inválido");
			return new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
		}
		
		var usuario = usuarioService.consultarUsuario(usuarioId);
		
		if (usuario == null) {
			resposta.setMensagem("usuário não encontrado");
			return new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
		}
		
		var listaVeiculos = usuarioService.obterVeiculos(usuarioId);
		var listaVeiculosDTO = new ArrayList<VeiculoDTO>();
		
		for (Veiculo veiculo : listaVeiculos) {
			listaVeiculosDTO.add(veiculo.veiculoParaDTO());			
		}
				
		resposta.setMensagem("OK");
		resposta.setData(listaVeiculosDTO);
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@PostMapping
    public ResponseEntity<VeiculoDTO> criarVeiculo(@RequestBody @Valid VeiculoDTO veiculoDTO){
         Veiculo veiculoSalvo = veiculoService.salvar(veiculoDTO.dtoParaVeiculo());
         
         if (veiculoDTO.equals(null)){
             return new ResponseEntity<>(veiculoSalvo.veiculoParaDTO(), HttpStatus.BAD_REQUEST);
         }
         
         return new ResponseEntity<>(veiculoSalvo.veiculoParaDTO(), HttpStatus.CREATED);
    }

	
}
