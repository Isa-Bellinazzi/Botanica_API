package br.com.magna.botanica.api.repository;

import org.springframework.data.domain.Page; 
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.magna.botanica.api.model.Planta;

public interface PlantaRepository extends JpaRepository<Planta, Long> {

	Page<Planta> findAllByAtivoTrue(Pageable paginacao);

	@Query("""
			SELECT  p FROM Planta p
			WHERE
			(p.ativo = true)
			and
			(p.nome >= :nome)
			""")
	String validaNome(String nome);



}    
