package br.com.magna.botanica.api.service.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.botanica.api.model.domain.Filo;
import br.com.magna.botanica.api.record.DadosAtualizacaoPlantaRecord;
import br.com.magna.botanica.api.record.DadosCadastroPlantaRecord;
import br.com.magna.botanica.api.record.domain.DadosListagemFiloRecord;
import br.com.magna.botanica.api.repository.domain.FiloRepository;

@Service
public class FiloService {
	@Autowired
	private FiloRepository filoRepository;

	public Page<DadosListagemFiloRecord> listagem( Pageable paginacao) {
	return filoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemFiloRecord::new);
	}
	
	public Filo validaFIlo(DadosCadastroPlantaRecord dados) {
		return filoRepository.getReferenceById(dados.filoId());
	}
	public Filo validaFIloAtualizacao(DadosAtualizacaoPlantaRecord dados) {
		return filoRepository.getReferenceById(dados.filoId());
	}
}
