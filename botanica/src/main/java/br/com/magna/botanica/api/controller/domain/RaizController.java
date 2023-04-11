package br.com.magna.botanica.api.controller.domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.botanica.api.record.domain.DadosListagemRaizRecord;
import br.com.magna.botanica.api.service.domain.RaizService;

@RestController
@RequestMapping("raizes")
public class RaizController {
	@Autowired
	private RaizService raizService;

	@GetMapping(value = "/listagem") // METODO DE LISTAGEM
	public ResponseEntity<Page<DadosListagemRaizRecord>> listar(
		@PageableDefault(size = 7, sort = { "descricao" }) Pageable paginacao) {
        return ResponseEntity.ok(raizService.listagem(paginacao));
	}
}


