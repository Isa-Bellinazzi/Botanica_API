package br.com.magna.botanica.api.record;

import br.com.magna.botanica.api.model.Planta;

public record DadosListagemPlanta(
Long id,
String nome,
String cor, 
String filo,
String classe, 
String ordem,
String raiz, 
String caule,
String folhagem,
Boolean ativo) {

	public DadosListagemPlanta(Planta planta) {
	    this(planta.getId(),
	            planta.getNome(),
	            planta.getCor(),
	            planta.getFilo().getDescricao(),
	            planta.getClasse().getDescricao(),
	            planta.getOrdem().getDescricao(),
	            planta.getRaiz().getDescricao(),
	            planta.getCaule().getDescricao(),
	            planta.getFolhagem().getDescricao(),
	            planta.getAtivo()
	            );
	   }
	}

