package br.com.magna.botanica.api.record.domain;

import br.com.magna.botanica.api.model.domain.Classe;

public record DadosListagemClasseRecord(
		Long id,
		String descricao,
		Long filoId,
        Boolean ativo
         ) {
	

	public DadosListagemClasseRecord(Classe classe) {
		this(classe.getId(), classe.getDescricao(), classe.getIdFilo().getId(), classe.getAtivo());
}
}
