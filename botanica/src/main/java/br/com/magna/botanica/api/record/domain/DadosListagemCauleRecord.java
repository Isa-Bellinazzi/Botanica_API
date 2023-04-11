package br.com.magna.botanica.api.record.domain;

import br.com.magna.botanica.api.model.domain.Caule;

public record DadosListagemCauleRecord(
		Long id,
		String descricao,
		Long classeId,
        Boolean ativo
         ) {
	

	public DadosListagemCauleRecord(Caule caule) {
		this(caule.getId(), caule.getDescricao(), caule.getClasseId().getId(), caule.getAtivo());
}

}