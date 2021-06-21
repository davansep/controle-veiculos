package com.listagem.veiculos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.listagem.veiculos.DTO.MensagemRespostaDTO;
import com.listagem.veiculos.DTO.UsuarioDTO;
import com.listagem.veiculos.models.Usuario;
import com.listagem.veiculos.service.UsuarioService;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {
	
	private UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
		 Usuario usuario = usuarioDTO.dtoParaUsuario();
         Usuario usuarioSalvo = usuarioService.salvar(usuario);
         
         if (usuarioDTO.equals(null)){
             return new ResponseEntity<>(usuarioSalvo, HttpStatus.BAD_REQUEST);
         }
         
         return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MensagemRespostaDTO<Usuario>> consultarUsuario(@PathVariable("id") long id){
    	
    	var msgResposta = new MensagemRespostaDTO<Usuario>();  	
    	var usuario = usuarioService.consultarUsuario(id);
    	
    	if (usuario == null) {
    		msgResposta.setMensagem("Usuário não encontrado");
    		return new ResponseEntity<>(msgResposta, HttpStatus.NOT_FOUND);
    	}
    	
    	msgResposta.setData(usuario);
    	msgResposta.setMensagem("OK");
        return new ResponseEntity<>(msgResposta, HttpStatus.OK);
    }
}