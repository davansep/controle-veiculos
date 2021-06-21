package com.listagem.veiculos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.listagem.veiculos.models.Usuario;
import com.listagem.veiculos.models.Veiculo;
import com.listagem.veiculos.repository.UsuarioRepository;

@Service
public class UsuarioService {
    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario consultarUsuario(long id) {
        return usuarioRepository.findById(id);
    }
    public List<Veiculo> obterVeiculos(long id) {
    	return usuarioRepository.getAllVeiculos(id);
    }


}