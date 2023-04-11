package br.com.magna.botanica.api.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name = "TB_DOM_CLASSE")
@Entity(name = "Classe")

public class Classe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	@OneToOne(targetEntity = Filo.class)
	@JoinColumn(name = "fk_filo")
	private Filo idFilo;
	private Boolean ativo;


	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Filo getIdFilo() {
		return idFilo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

}
