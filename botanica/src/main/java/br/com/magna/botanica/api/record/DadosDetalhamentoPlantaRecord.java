package br.com.magna.botanica.api.record;

import br.com.magna.botanica.api.model.Planta;

public record DadosDetalhamentoPlantaRecord(
		Long id,
		String nome,
		String cor, 
		String filo,
		String classe, 
		String ordem,
		String raiz, 
		String caule,
		String folhagem,
		Boolean folhas_verdadeiras,
		Boolean caules_verdadeiros,
		Boolean raizes_verdadeiras,
		Boolean flores,
		Boolean frutos,
		Boolean sementes,

		Boolean ativo) {

	public DadosDetalhamentoPlantaRecord(Planta planta) {
		  this(planta.getId(),
		            planta.getNome(),
		            planta.getCor(),
		            planta.getFilo().getDescricao(),
		            planta.getClasse().getDescricao(),
		            planta.getOrdem().getDescricao(),
		            planta.getRaiz().getDescricao(),
		            planta.getCaule().getDescricao(),
		            planta.getFolhagem().getDescricao(),
		            planta.getFilo().getFolhasVerdadeiras(),
		            planta.getFilo().getCauleVerdadeiro(),
		            planta.getFilo().getRaizVerdadeiras(),
		            planta.getFilo().getFlores(),
		            planta.getFilo().getFrutos(),
		            planta.getFilo().getSementes(),
		            planta.getAtivo()
		            );
	}
}
