package br.com.magna.botanica.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.magna.botanica.api.record.DadosAtualizacaoPlantaRecord;
import br.com.magna.botanica.api.record.DadosCadastroPlantaRecord;
import br.com.magna.botanica.api.record.DadosDetalhamentoPlantaRecord;
import br.com.magna.botanica.api.record.DadosListagemPlantaRecord;
import br.com.magna.botanica.api.service.PlantaService;

@RestController
@RequestMapping("plantas")
class PlantaController {

	@Autowired
	private PlantaService plantaService;

	@PostMapping(value = "/cadastrar")
	@Transactional 
	public ResponseEntity<DadosDetalhamentoPlantaRecord> cadastrar(@RequestBody @Validated DadosCadastroPlantaRecord dados,
			UriComponentsBuilder uriBuilder) {
		var planta = plantaService.cadastrar(dados);
		var uri = uriBuilder.path("/planta/{id}").buildAndExpand(planta.getId()).toUri();
		return ResponseEntity.created(uri).body(plantaService.detalhar(planta.getId()));
	}

	@GetMapping(value = "/listagem") 
	ResponseEntity<Page<DadosListagemPlantaRecord>> listar(@PageableDefault(size = 7, sort = { "nome" }) Pageable paginacao) {
		return ResponseEntity.ok(plantaService.listagem(paginacao));
	}

	@PutMapping(value = "/atualizar")
	@Transactional 
	public ResponseEntity<DadosDetalhamentoPlantaRecord> atualizar(@RequestBody @Validated DadosAtualizacaoPlantaRecord dados) {
		return ResponseEntity.ok(plantaService.atualizar(dados));
	}

	@DeleteMapping("/excluir/{id}")
	@Transactional 
	public ResponseEntity<Long> excluir(@PathVariable Long id) {
		plantaService.excluir(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("detalhar/{id}") 
	public ResponseEntity<DadosDetalhamentoPlantaRecord> detalhar(@PathVariable Long id) {
		return ResponseEntity.ok(plantaService.detalhar(id));
	}
}
