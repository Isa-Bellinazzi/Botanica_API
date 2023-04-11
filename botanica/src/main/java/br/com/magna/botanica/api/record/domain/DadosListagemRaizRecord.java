package br.com.magna.botanica.api.record.domain;

import br.com.magna.botanica.api.model.domain.Raiz;

public record DadosListagemRaizRecord(
		Long id,
		String descricao,
		Long classeId,
        Boolean ativo
         ) {

	public DadosListagemRaizRecord(Raiz raiz) {
		this(raiz.getId(), raiz.getDescricao(), raiz.getClasseId().getId(), raiz.getAtivo());
}
}