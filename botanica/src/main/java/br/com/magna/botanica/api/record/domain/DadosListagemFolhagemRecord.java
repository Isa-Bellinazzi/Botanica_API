package br.com.magna.botanica.api.record.domain;

import br.com.magna.botanica.api.model.domain.Folhagem;

public record DadosListagemFolhagemRecord(
		Long id,
		String descricao,
		Long classeId,
        Boolean ativo
         ) {

	public DadosListagemFolhagemRecord(Folhagem folha) {
		this(folha.getId(), folha.getDescricao(), folha.getClasseId().getId(), folha.getAtivo());
}
}