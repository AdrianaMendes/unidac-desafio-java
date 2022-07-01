package com.spring.api.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.api.entities.ColaboradorEntity;

@Repository
public interface ColaboradorRepository extends JpaRepository<ColaboradorEntity, Long> {
	@Modifying
	@Transactional
	@Query(value = "UPDATE mantimento SET colaborador_id = :colaboradorId WHERE id = :mantimentoId", nativeQuery = true)
	void addMantimentoNativeQuery(final Long colaboradorId, final Long mantimentoId);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM colaborador WHERE id = :id", nativeQuery = true)
	void deleteByIdNativeQuery(final Long id);

	@Modifying
	@Transactional
	@Query(value = "UPDATE mantimento SET colaborador_id = NULL WHERE colaborador_id = :id", nativeQuery = true)
	void deleteMantimentoFromColaborador(final Long id);

	@Query(value = "SELECT * FROM colaborador", nativeQuery = true)
	List<ColaboradorEntity> findAllNativeQuery();

	@Query(value = "SELECT * FROM colaborador WHERE cpf = :cpf", nativeQuery = true)
	ColaboradorEntity findByCpfNativeQuery(final String cpf);

	@Query(value = "SELECT * FROM colaborador WHERE id = :id", nativeQuery = true)
	ColaboradorEntity findByIdNativeQuery(final Long id);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE colaborador SET nome = :nome WHERE id = :id", nativeQuery = true)
	void updateNativeQuery(final Long id, final String nome);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO colaborador (nome, cpf) VALUES (:nome, :cpf)", nativeQuery = true)
	void saveNativeQuery(final String nome, final String cpf);
}
