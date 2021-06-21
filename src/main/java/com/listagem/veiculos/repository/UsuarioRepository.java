package com.listagem.veiculos.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.listagem.veiculos.models.Usuario;
import com.listagem.veiculos.models.Veiculo;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
	Usuario findById(long id);
	Usuario deleteById(long id);
	@Transactional
	@Modifying
    @Query("SELECT u from Veiculo u WHERE u.usuario.id = ?1")
	List<Veiculo> getAllVeiculos(Long usuarioId); 
}
