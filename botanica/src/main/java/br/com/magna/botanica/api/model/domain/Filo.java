package br.com.magna.botanica.api.model.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "TB_DOM_FILO")
@Entity(name = "Filo")
public  class Filo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private Boolean folhaVerdadeira;
	private Boolean cauleVerdadeiro;
	private Boolean raizVerdadeira;
	private Boolean fruto;
	private Boolean flor;
	private Boolean semente;
	private Boolean ativo;


	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Boolean getFolhasVerdadeiras() {
		return folhaVerdadeira;
	}

	public Boolean getCauleVerdadeiro() {
		return cauleVerdadeiro;
	}

	public Boolean getRaizVerdadeiras() {
		return raizVerdadeira;
	}

	public Boolean getFrutos() {
		return fruto;
	}

	public Boolean getFlores() {
		return flor;
	}

	public Boolean getSementes() {
		return semente;
	}

	public Boolean getAtivo() {
		return ativo;
	}
}

