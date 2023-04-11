package br.com.magna.botanica.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.magna.botanica.api.model.Filo;
import br.com.magna.botanica.api.record.DadosAtualizacaoPlanta;
import br.com.magna.botanica.api.record.DadosCadastroPlanta;
import br.com.magna.botanica.api.record.DadosListagemFilo;
import br.com.magna.botanica.api.repository.FiloRepository;

@Service
public class FiloService {
	@Autowired
	private FiloRepository filoRepository;

	public Page<DadosListagemFilo> listagem( Pageable paginacao) {
	return filoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemFilo::new);
	}
	
	public Filo validaFIlo(DadosCadastroPlanta dados) {
		return filoRepository.getReferenceById(dados.filoId());
	}
	public Filo validaFIloAtualizacao(DadosAtualizacaoPlanta dados) {
		return filoRepository.getReferenceById(dados.filoId());
	}
}
