package com.listagem.veiculos.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.listagem.veiculos.models.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo,Long> {
	
	//Veiculo findById(Long id);
	@Transactional
	@Modifying
    @Query("SELECT v from Veiculo v WHERE v.usuario.id = ?1")
	List<Veiculo> findByUsuarioId(Long usuarioId);    
	
	
}
