package com.spring.api.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.api.entities.MantimentoEntity;

@Repository
public interface MantimentoRepository extends JpaRepository<MantimentoEntity, Long> {
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM mantimento m WHERE m.id = :id", nativeQuery = true)
	void deleteByIdNativeQuery(final Long id);

	@Query(value = "SELECT * FROM mantimento", nativeQuery = true)
	List<MantimentoEntity> findAllNativeQuery();

	@Query(value = "SELECT * FROM mantimento m WHERE m.id = :id", nativeQuery = true)
	MantimentoEntity findByIdNativeQuery(final Long id);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO mantimento (descricao) VALUES (:descricao)", nativeQuery = true)
	void saveNativeQuery(final String descricao);
}
