package br.com.magna.botanica.api.validation;

import br.com.magna.botanica.api.record.DadosAtualizacaoPlantaRecord;
import br.com.magna.botanica.api.record.DadosCadastroPlantaRecord;

public interface Validador {
	
	void validar(DadosCadastroPlantaRecord dados);
	
	void validarAtualizacao(DadosAtualizacaoPlantaRecord dados);


}
