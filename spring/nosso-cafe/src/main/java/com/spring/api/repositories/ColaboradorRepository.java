package com.spring.api.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.api.entities.ColaboradorEntity;

@Repository
public interface ColaboradorRepository extends JpaRepository<ColaboradorEntity, Long> {
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO colaborador (nome, cpf) VALUES (:nome, :cpf);", nativeQuery = true)
	public void saveNativeQuery(@Param("nome") final String nome, @Param("cpf") final String cpf);
	
	@Query(value = "SELECT * FROM colaborador;", nativeQuery = true)
	public List<ColaboradorEntity> findAllNativeQuery();
}

