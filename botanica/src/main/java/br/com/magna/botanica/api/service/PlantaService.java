package br.com.magna.botanica.api.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.magna.botanica.api.model.Planta;
import br.com.magna.botanica.api.record.DadosAtualizacaoPlantaRecord;
import br.com.magna.botanica.api.record.DadosCadastroPlantaRecord;
import br.com.magna.botanica.api.record.DadosDetalhamentoPlantaRecord;
import br.com.magna.botanica.api.record.DadosListagemPlantaRecord;
import br.com.magna.botanica.api.repository.PlantaRepository;
import br.com.magna.botanica.api.service.domain.CauleService;
import br.com.magna.botanica.api.service.domain.ClasseService;
import br.com.magna.botanica.api.service.domain.FiloService;
import br.com.magna.botanica.api.service.domain.FolhagemService;
import br.com.magna.botanica.api.service.domain.OrdemService;
import br.com.magna.botanica.api.service.domain.RaizService;
import br.com.magna.botanica.api.validation.Validador;

@Service
public class PlantaService {
	@Autowired
	private PlantaRepository repository;
	@Autowired
	private FiloService filoService;
	@Autowired
	private ClasseService classeService;
	@Autowired
	private OrdemService ordemService;
	@Autowired
	private RaizService raizService;
	@Autowired
	private CauleService cauleService;
	@Autowired
	private FolhagemService folhagemService;
	
	@Autowired
	private List<Validador> validadores;
	
	public Planta cadastrar(DadosCadastroPlantaRecord dados) {
		validadores.forEach(v -> v.validar(dados));
		Planta planta = new Planta();
		planta.setNome(dados.nome());
		planta.setCor(dados.cor());
		planta.setFilo(filoService.validaFIlo(dados));
		planta.setClasse(classeService.valiadandoDadosDeClasse(dados));
		planta.setOrdem(ordemService.validandoDadosDeOrdem(dados));
		planta.setRaiz(raizService.validandoDadosDeRaiz(dados));
		planta.setCaule(cauleService.validandoDadosDeCaule(dados));
		planta.setFolhagem(folhagemService.validandoDadosDeFolhagem(dados));
		planta.setAtivo(true);
		repository.save(planta);
		return planta;
	}

	public DadosDetalhamentoPlantaRecord atualizar(DadosAtualizacaoPlantaRecord dados) { 
		validadores.forEach(v -> v.validarAtualizacao(dados));
		Planta planta = repository.getReferenceById(dados.id());
		planta.setNome(dados.nome());
		planta.setCor(dados.cor());
		planta.setFilo(filoService.validaFIloAtualizacao(dados));
		planta.setClasse(classeService.valiadandoDadosAtuliazacaoClasse(dados));
		planta.setOrdem(ordemService.validandoDadosAtualizacaoOrdem(dados));
		planta.setRaiz(raizService.validandoDadosRaizAtualizacao(dados));
		planta.setCaule(cauleService.validandoDadosCauleAtualizacao(dados));
		planta.setFolhagem(folhagemService.validandoDadosFolhagemAtualizacao(dados));
		planta.setAtivo(true);
		repository.save(planta);
		return new DadosDetalhamentoPlantaRecord(planta);
	}

	public DadosDetalhamentoPlantaRecord detalhar(Long id) {
		var planta = repository.getReferenceById(id);
		return new DadosDetalhamentoPlantaRecord(planta);
	}

	public Page<DadosListagemPlantaRecord> listagem(Pageable paginacao) {
		return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPlantaRecord::new);
	}


	public void excluir(Long id) {
		var planta = repository.getReferenceById(id);
		planta.excluir();
	}
	
}
