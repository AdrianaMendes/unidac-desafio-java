package com.spring.api.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import br.com.caelum.stella.bean.validation.CPF;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "colaborador")
public final class ColaboradorEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 64)
	@NotBlank(message = "Campo nome obrigatório.")
	private String nome;

	@Column(nullable = false, length = 11, unique = true)
	@NotBlank(message = "Campo CPF obrigatório.")
	@CPF(message = "CPF inválido.")
	private String cpf;

	@OneToMany(mappedBy = "colaborador")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private List<MantimentoEntity> listaMantimentos;
}
