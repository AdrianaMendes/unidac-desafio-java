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
	@Query(value = "UPDATE mantimento m SET colaborador_id = :colaboradorId WHERE m.id = :mantimentoId", nativeQuery = true)
	void addMantimentoNativeQuery(@Param("colaboradorId") final Long colaboradorId, @Param("mantimentoId") final Long mantimentoId);

	@Query(value = "SELECT * FROM colaborador", nativeQuery = true)
	List<ColaboradorEntity> findAllNativeQuery();

	@Query(value = "SELECT * FROM colaborador c WHERE c.cpf = :cpf", nativeQuery = true)
	List<ColaboradorEntity> findByCpfNativeQuery(@Param("cpf") final String cpf);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO colaborador (nome, cpf) VALUES (:nome, :cpf)", nativeQuery = true)
	void saveNativeQuery(@Param("nome") final String nome, @Param("cpf") final String cpf);
}
