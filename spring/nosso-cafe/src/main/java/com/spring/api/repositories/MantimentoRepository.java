package com.spring.api.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.api.entities.MantimentoEntity;

@Repository
public interface MantimentoRepository extends JpaRepository<MantimentoEntity, Long> {
	@Query(value = "SELECT * FROM mantimento", nativeQuery = true)
	List<MantimentoEntity> findAllNativeQuery();

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO mantimento (descricao) VALUES (:descricao)", nativeQuery = true)
	void saveNativeQuery(@Param("descricao") final String descricao);
}
