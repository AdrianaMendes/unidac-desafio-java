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
	@Query(value = "UPDATE mantimento m SET m.colaborador_id = :colaboradorId WHERE m.id = :mantimentoId", nativeQuery = true)
	void addMantimentoNativeQuery(final Long colaboradorId, final Long mantimentoId);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM colaborador c WHERE c.id = :id", nativeQuery = true)
	void deleteByIdNativeQuery(final Long id);

	@Modifying
	@Transactional
	@Query(value = "UPDATE mantimento m SET m.colaborador_id = NULL WHERE m.colaborador_id = :id", nativeQuery = true)
	void deleteMantimentoFromColaborador(final Long id);

	@Query(value = "SELECT * FROM colaborador", nativeQuery = true)
	List<ColaboradorEntity> findAllNativeQuery();

	@Query(value = "SELECT * FROM colaborador c WHERE c.cpf = :cpf", nativeQuery = true)
	ColaboradorEntity findByCpfNativeQuery(final String cpf);

	@Query(value = "SELECT * FROM colaborador c WHERE c.id = :id", nativeQuery = true)
	ColaboradorEntity findByIdNativeQuery(final Long id);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO colaborador (nome, cpf) VALUES (:nome, :cpf)", nativeQuery = true)
	void saveNativeQuery(final String nome, final String cpf);
}
