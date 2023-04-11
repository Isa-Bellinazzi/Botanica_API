package br.com.magna.botanica.api.controller.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.botanica.api.record.domain.DadosListagemOrdemRecord;
import br.com.magna.botanica.api.service.domain.OrdemService;

@RestController
@RequestMapping("ordens")
public class OrdemController {
	
	@Autowired
	private OrdemService service;

	@GetMapping(value = "/listagem") // METODO DE LISTAGEM
	public ResponseEntity<Page<DadosListagemOrdemRecord>> listar(
			@PageableDefault(size = 7, sort = { "descricao" }) Pageable paginacao) {
		return ResponseEntity.ok(service.listagem(paginacao));
	
	}
}
