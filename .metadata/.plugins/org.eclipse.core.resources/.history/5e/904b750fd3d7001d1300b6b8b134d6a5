package br.com.magna.botanica.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.magna.botanica.api.model.Planta;
import br.com.magna.botanica.api.record.DadosAtualizacaoPlanta;
import br.com.magna.botanica.api.record.DadosCadastroPlanta;
import br.com.magna.botanica.api.record.DadosDetalhamentoPlanta;
import br.com.magna.botanica.api.record.DadosListagemPlanta;
import br.com.magna.botanica.api.repository.PlantaRepository;

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
	
	public Planta cadastrar(DadosCadastroPlanta dados) {
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

	public DadosDetalhamentoPlanta atualizar(DadosAtualizacaoPlanta dados) { 
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
		return new DadosDetalhamentoPlanta(planta);
	}

	public DadosDetalhamentoPlanta detalhar(Long id) {
		var planta = repository.getReferenceById(id);
		return new DadosDetalhamentoPlanta(planta);
	}

	public Page<DadosListagemPlanta> listagem(Pageable paginacao) {
		return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPlanta::new);
	}


	public void excluir(Long id) {
		var planta = repository.getReferenceById(id);
		planta.excluir();
	}
	
}
