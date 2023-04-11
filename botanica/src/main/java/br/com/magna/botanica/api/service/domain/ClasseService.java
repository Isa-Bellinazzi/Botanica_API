package br.com.magna.botanica.api.service.domain;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.botanica.api.model.domain.Classe;
import br.com.magna.botanica.api.record.DadosAtualizacaoPlantaRecord;
import br.com.magna.botanica.api.record.DadosCadastroPlantaRecord;
import br.com.magna.botanica.api.record.domain.DadosListagemClasseRecord;
import br.com.magna.botanica.api.repository.domain.ClasseRepository;

@Service
public class ClasseService {

	@Autowired
	private ClasseRepository classeRepository;
	
	public Page<DadosListagemClasseRecord> listagem( Pageable paginacao) {
	return classeRepository.findAllByAtivoTrue(paginacao).map(DadosListagemClasseRecord::new);
	}
	
	public Classe valiadandoDadosDeClasse(DadosCadastroPlantaRecord dados) {
		return classeRepository.validandoClasseComFilo(dados.classeId(),dados.filoId());
	}
	public Classe valiadandoDadosAtuliazacaoClasse(DadosAtualizacaoPlantaRecord dados) {
		return classeRepository.validandoClasseComFilo(dados.classeId(),dados.filoId());
	}
}


