package br.com.magna.botanica.api.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.botanica.api.model.domain.Filo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class FiloControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void testListagemFilos() {
		ResponseEntity<Filo> responseEntity = restTemplate.getForEntity("/filos/listagem", Filo.class);
		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		Assert.assertNotNull(responseEntity.getBody());
	}
}

