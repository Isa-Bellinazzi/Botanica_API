package br.com.magna.botanica.api.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.botanica.api.record.DadosAtualizacaoPlantaRecord;
import br.com.magna.botanica.api.record.DadosCadastroPlantaRecord;
import br.com.magna.botanica.api.repository.domain.CauleRepository;
import br.com.magna.botanica.api.repository.domain.ClasseRepository;
import br.com.magna.botanica.api.repository.domain.FolhagemRepository;
import br.com.magna.botanica.api.repository.domain.OrdemRepository;
import br.com.magna.botanica.api.repository.domain.RaizRepository;

@Component
public class ValidationClasse implements Validador {

	@Autowired
	ClasseRepository classe;

	@Autowired
	OrdemRepository ordem;

	@Autowired
	CauleRepository caule;

	@Autowired
	FolhagemRepository folhagem;

	@Autowired
	RaizRepository raiz;

	@Override
	public void validar(DadosCadastroPlantaRecord dados) {
		if (classe.validandoClasseComFilo(dados.classeId(), dados.filoId()) == null
				|| ordem.validandoOrdemComClasse(dados.ordemId(), dados.classeId()) == null
				|| caule.validandoCauleComClasse(dados.cauleId(), dados.classeId()) == null
				|| raiz.validandoRaizComClasse(dados.raizId(), dados.classeId()) == null
				|| folhagem.validandoFolhaComClasse(dados.folhagemId(), dados.classeId()) == null) {
			throw new ValidationException("Seu cadastro possue dados que não são compatíveis!"
					+ "Os seguintes campos precisam ser compatíveis: Filo, Classe, Ordem, Raiz, Folhagem e Caule.");
		}
	}

	@Override
	public void validarAtualizacao(DadosAtualizacaoPlantaRecord dados) {
		if (classe.validandoClasseComFilo(dados.classeId(), dados.filoId()) == null
				|| ordem.validandoOrdemComClasse(dados.ordemId(), dados.classeId()) == null
				|| caule.validandoCauleComClasse(dados.cauleId(), dados.classeId()) == null
				|| raiz.validandoRaizComClasse(dados.raizId(), dados.classeId()) == null
				|| folhagem.validandoFolhaComClasse(dados.folhagemId(), dados.classeId()) == null) {
			throw new ValidationException("Seu cadastro possue dados que não são compatíveis!"
					+ "Os seguintes campos precisam ser compatíveis: Filo, Classe, Ordem, Raiz, Folhagem e Caule.");
		}
	}
}
