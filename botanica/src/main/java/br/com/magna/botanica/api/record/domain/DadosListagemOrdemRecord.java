package br.com.magna.botanica.api.record.domain;

import br.com.magna.botanica.api.model.domain.Ordem;

public record DadosListagemOrdemRecord(
		Long id,
		String descricao,
		Long classeId,
        Boolean ativo
         ) {

	public DadosListagemOrdemRecord(Ordem ordem) {
		this(ordem.getId(), 
			 ordem.getDescricao(), 
			 ordem.getClasseId().getId(), 
			 ordem.getAtivo());
}
}