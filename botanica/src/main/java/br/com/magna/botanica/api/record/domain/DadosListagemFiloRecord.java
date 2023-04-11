package br.com.magna.botanica.api.record.domain;

import br.com.magna.botanica.api.model.domain.Filo;

public record DadosListagemFiloRecord(Long id,
        String descricao,
        Boolean folhasVerdadeiras,
        Boolean cauleVerdadeiro,
        Boolean raizVerdadeiras,
        Boolean frutos,
        Boolean flores,
        Boolean sementes,
        Boolean ativo

         ) {
	

	public DadosListagemFiloRecord(Filo filo) {
		this(filo.getId(), 
			 filo.getDescricao(), 
			 filo.getFolhasVerdadeiras(), 
			 filo.getCauleVerdadeiro(),
			 filo.getFolhasVerdadeiras(),
			 filo.getFrutos(), 
			 filo.getFlores(), 
			 filo.getSementes(),
			 filo.getAtivo());
}
}