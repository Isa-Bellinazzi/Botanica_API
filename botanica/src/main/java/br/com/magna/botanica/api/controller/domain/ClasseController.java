package br.com.magna.botanica.api.controller.domain;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.botanica.api.record.domain.DadosListagemClasseRecord;
import br.com.magna.botanica.api.service.domain.ClasseService;

@RestController
@RequestMapping("classes")
public class ClasseController {

	@Autowired
	private ClasseService classeService;

	@GetMapping(value = "/listagem") // METODO DE LISTAGEM
	public ResponseEntity<Page<DadosListagemClasseRecord>> listar(
			@PageableDefault(size = 7, sort = { "descricao" }) Pageable paginacao) {
	    return ResponseEntity.ok(classeService.listagem(paginacao));
	}
}